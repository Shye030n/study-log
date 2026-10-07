-- day15: 단일 테이블 조회 (SELECT / WHERE /ORDER BY / NULL)
-- 대상 DB: bank_setup.sql
-- 각 쿼리 위에 [예측] -> 실행 후 [결과] -> 다르면 [이유]를 주석으로 남긴다.

------------------------(직접 코드 작성)--------------------
-- 1. 상태가 '정상'이 아닌 계좌의 계좌번호, 계좌상태, 해지일을 조회
-- [예측]
-- [결과]
SELECT ACCT_NO, ACCT_STAT, CLOSE_DT
    FROM ACCOUNT
    WHERE ACCT_STAT != '정상';

-- 2. 판매 중인 에금 상품의 상품명과 금리를 금리가 높은 순으로 조회
-- [예측]
-- [결과]
SELECT PROD_NM, INT_RATE
    FROM PRODUCT
    WHERE SALE_YN = 'Y' AND PROD_TYPE = '예금'
    ORDER BY INT_RATE DESC;

SELECT * FROM CUSTOMER;
SELECT * FROM PRODUCT;
SELECT * FROM ACCOUNT;
SELECT * FROM TRX_HIST;
SELECT * FROM BRANCH;
-- 3. 휴대폰 번호가 등록되지 않은 고객의 고객번호, 이름, 고객등록일을 최근 등록순으로 조회
-- [예측]
-- [결과]
SELECT CUST_NO, CUST_NM, JOIN_DT
    FROM CUSTOMER
    WHERE PHONE IS null
    ORDER BY JOIN_DT DESC;

-- 4. 2026/09/30 하룰 동안 발생한 거래의 거래ID, 계좌번호, 거래일시, 거래유형 금액을 조회
-- [예측]
-- [결과]
SELECT TRX_ID, ACCT_NO, TRX_DTM, TRX_TYPE, TRX_AMT
    FROM TRX_HIST
    WHERE TRX_DTM >= DATE '2026-09-30' AND TRX_DTM < DATE '2026-10-01';


-------------------------(실습)---------------------------
-- 예시 1) 기본 조회
SELECT CUST_NO, CUST_NM, GRADE
    FROM CUSTOMER
    WHERE MGMT_BRANCH_CD = '0101'
    ORDER BY CUST_NO;

-- [예측]
-- 조회할 컬럼 : 고객번호, 고객명, 등급
-- 고객 테이블에서
-- 테이블 CURSTOMER의 FK인 MGMT_BRANCH_CD 가 0101에 해당하는 가로(행)들을 뽑아
-- 고객번호를 기준으로 오름차순으로 정렬한다.
-- [결과]
-- 고객테이블에서, CUST_NO 가 C0001, C0002, C0011, C0014 순으로 출력될 듯. (딩동댕)


-- 예시 2) 조건 조합과 정렬 방향
SELECT ACCT_NO, CUST_NO, BALANCE
    FROM ACCOUNT
    WHERE PROD_CD IN ('P001', 'P002')
        AND BALANCE >= 10000000
    ORDER BY BALANCE DESC;

-- [예측]
-- 컬럼 계좌번호, 고객번호, 잔액을 조회한다
-- 계좌 테이블에서
-- 상품코드가 'P001', 'P002' 이고, 잔액이 천만원 이상인 행들을 뽑아
-- 잔액이 많은 순으로 정렬한다.


-- 예시 3: NULL - 가장 많이 실수하는 부분
--          : GRADE 가 비어있는 고객을 찾고 싶을 때
-- 올바른 방법
SELECT CUST_NO, CUST_NM
FROM CUSTOMER
WHERE GRADE IS NULL;

-- 잘못된 방법
--SELECT CUST_NO, CUST_NM
--FROM CUSTOMER
--WHERE GRADE = NULL;

SELECT CUST_NO, CUST_NM, GRADE
FROM CUSTOMER
WHERE GRADE <> 'VIP';

-- [예상] 
-- VIP가 4개니까, 총 고객 16 - 4 = 12

-- [실제 결과]
-- GRADE 가 null 인 값도 빠져서 10

-- !!!!![이유]
-- WHERE은 참인 결과만 남기는데, NULL은 참이 아닌 unknown
-- 만약 null 인 값도 포함하여, GRADE가 VIP가 아닌 모든 고객을 조회하고 싶다면,
-- WHERE GRADE <> 'VIP' OR GRADE IS NULL

