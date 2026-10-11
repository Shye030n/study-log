# GROUP BY

1 ) 핵심 키워드
* GROUP BY
* HAVING
* 집계 함수 (COUNT, SUM, AVG, MAX, MIN)
* COUNT(*) VS COUNT(컬럼)
* 실행 순서 확장
* ORA-00979

2 ) 학습 목표
1. 결과의 한 행이 무엇을 뜻하는지(고객 한 명인지, 지점 하나인지 요약) 말할 수 있다.
2. WHERE 과 HAVING 의 차이를 실행 순서로 설명할 수 있다.
3. 집계 함수가 NULL을 어떻게 다루는지 알고, COUNT(*) 와 COUNT(컬럼)을 구분해 쓴다
4. "GROUP BY에 없는 컬럼은 SELECT에 못쓴다"는 규칙을 이유와 함께 설명할 수 있다.

3 ) 연습 문제 (미리보기)
개념과 예시를 다 해본 뒤에 풀어요
1. 계좌상태별 계좌 수를 조회
2. 고객 등급별 고객 수 조회
3. 거래 유형별 거래 건수와 총 거래금액 조회
4. 2026년 9월에 출금성 거래 ('출금', '이체출금') 금액 합계가 100만원 이상인 계좌의 계좌번호와 합계를 합계가 큰 순으로 조회
5. (도전) 2026년 9월 중 거래가 3건 이상 발생한 날짜와 그 날의 거래 건수를 조회

4 ) 개념

### * GROUP BY : 같은 값끼리 바구니에 담고, 바구니마다 한 줄 요약
```
CUSTOMER 16행                       GROUP BY MGMT_BRANCH_CD
C0001 | 0101 ┐
C0002 | 0101 │  → [0101 바구니] 4명   →  0101 | 4
C0011 | 0101 │
C0014 | 0101 ┘
C0004 | 0102 ┐
C0005 | 0102 │  → [0102 바구니] 3명   →  0102 | 3
C0013 | 0102 ┘
   ...                                     ...
```
    - WHERE 까지는 (GROUP BY 전에는) 결과 한 행 = 고객 한 명
    - GROUP BY 후에는 결과 한 행 = 바구니 하나(지점)의 요약
    - Java로 치면, HashMap으로 하는 그룹별 개수 세기와 동일
```
Map<String, Integer> cnt = new HashMap<>();
for (Customer c : customers) {          //FROM
    String key = c.getMgmtBranchCd();   //GROUP BY의 Map의 key
    cnt.put(key, cnt.getOrDefault(key, 0) + 1);     //COUNT(*) = value의 누적
}
```

### 실행 순서
FROM        -- 무슨 테이블에서
WHERE       -- 행 하나 하나를 보고 걸러     <- 아직 바구니 없음
GROUP BY    -- 남은 행을 바구니에 담아
HAVING      -- 바구니(그룹) 단위로 거른다    <- 집계값으로 판단 가능
SELECT      -- 바구니마다 한 줄을 만들어
ORDER BY    -- 정렬

### 규칙
규칙 1: WHERE 에는 집계 함수를 못쓴다.
규칙 2: SELECT 에는 GROUP BY에 있는 컬럼/집계함수 만 쓸 수 있다
    (지점 별로 묶었는데 SELECT MGMT_BRANCH_CD, CUST_NM 을 하면, 0101 바구니에 이름이 4개 있는데, 한 줄에 무엇을 보여줄 지 정할 수 없다. 그래서 오라클은 ORA-00979:not GROUP BY expression 에러를 낸다._현장에서 자주 보임)

### 집계함수와 NULL
| 함수 | 뜻 | NULL 처리 |
|---|---|---|
| COUNT(*) | 행 개수 | 행 자체를 셈 (NULL 상관 없음) |
| COUNT(컬럼) | 그 컬럼에 값이 있는 행 개수 | NULL 제외하고 셈 |
| SUM AVG MIN MAX | 합계 평균 최대 최소 | NULL은 무시하고 계산 |
- GROUP BY 없이 집계 함수만 쓰면 테이블 전체가 바구니 하나가 되어 결과는 1 행이다.
