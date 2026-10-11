--[예측] 어떤 에러 번호가 나올 지 먼저 적어보고 실행할 것.
-- 예시 1: 지점별 고객 수
SELECT MGMT_BRANCH_CD, COUNT(*) AS CUST_CNT
FROM CUSTOMER
GROUP BY MGMT_BRANCH_CD
ORDER BY MGMT_BRANCH_CD;
-- [예측]
-- BRANCH 테이블에는 지점이 6개 있다. 결과는 몇 행일까? 실행해보고 예측과 다르다면, 왜 그런지 한 줄로 적어두기
-- 지금이 6개니까, MGMT_BRANCH_CD | CUST_CNT 로 2행 6열의 지점코드 | 지점의고객수 로 나올 것 같아.

-- 예시 2: COUNT(*) 와 COUNT(컬림)
SELECT COUNT(*)     AS 전체,                --모든 행
    COUNT(GRADE)    AS 등급있음,             -- GRADE 가 NULL이 아닌 행 전부
    COUNT(PHONE)    AS 폰있음,              -- PHONE 이 NULL이 아닌 행 전부
    COUNT(DISTINCT GRADE)   AS 등급종류     -- 중복을 제외한 GRADE의 개수
FROM CUSTOMER;                              -- GROUP BY 없음. 전체가 한 그룹으로. (1행)
-- [예측] 
-- | 전체 | 등급있음 | 폰있음 | 등급종류 |
-- | 전체개수 | GRADE의 값이 NULL이 아닌 행의 총 개수 | PHONE의 값이 NULL이 아닌 행의 총 개수 | 등급이 몇개로 나뉘는지 종류나열|
-- 일 거 같은데

-- 예시 3: 여러 집계를 한 번에
SELECT PROD_CD,
    COUNT(*)    AS ACCT_CNT,    
    SUM(BALANCE)    AS SUM_BAL,
    MAX(BALANCE)    AS MAX_BAL,
    ROUND(AVG(BALANCE))     AS AVG_BAL
FROM ACCOUNT
GROUP BY PROD_CD
ORDER BY SUM_BAL DESC;
-- [예측]
-- ACCOUNT 테이블에서, PROD_CD가 같은 행끼리 그룹핑하여,
-- | PROD_CD | ACCT_CNT | SUM_BAL | MAX_BAL | AVG_BAL |
-- | 상품코드 | 전체개수 | 잔액합계 | 최대잔액 | 잔액의평균에서소수점을반올림 | 
--이렇게 잔액합계가 많은->적은 순으로 출력될 거 같아.

-- 예시 4: WHERE + GROUP BY + HAVING 전부
SELECT ACCOUT_NO,
    COUNT(*)    AS TRX_CNT,
    SUM(TRX_AMT)    AS SUM_AMT
FROM TRX_HIST
WHERE TRX_DTM >= DATE '2026-09-01'
    AND TRX_DTM < DATE '2026-10-01'
GROUP BY ACCT_NO
HAVING COUNT(*) >=3
ORDER BY TRX_CNT DESC, ACCT_NO;
-- [예측]
-- | ACCOUNT_NO | TRX_CNT | SUM_AMT |
-- | 계좌번호 | 이체횟수 | 전체이체금액합계 |
-- 이렇게 이체횟수가 많->적 순서로, 중복된 값이 있다면, 계좌번호는 오름차순으로. 조회될 거 같아



-- 예시 5: 일부러 에러 내보기
SELECT MGMT_BRANCH_CD, CUST_NM, COUNT(*)
FROM CUSTOMER
GROUP BY MGMT_BRANCH_CD;
-- [예측]
-- 고객 테이블에서
-- 관리지점코드가 같은 행끼리 그룹핑하여
-- 관리지점코드 | 고객명 | 전체개수 를 출력하려 하는데,
-- 고객명을 GROUP BY에서 사용하지 않았기 때문에, ORA-00979: not a GROUP BY expression 에러가 나올 거 같아.