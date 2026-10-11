--[예측] 어떤 에러 번호가 나올 지 먼저 적어보고 실행할 것.
-- 예시 1: 지점별 고객 수
SELECT MGMT_BRANCH_CD, COUNT(*) AS CUST_CNT
FROM CUSTOMER
GROUP BY MGMT_BRANCH_CD
ORDER BY MGMT_BRANCH_CD;
-- [예측]
-- BRANCH 테이블에는 지점이 6개 있다. 결과는 몇 행일까? 실행해보고 예측과 다르다면, 왜 그런지 한 줄로 적어두기

-- 예시 2: COUNT(*) 와 COUNT(컬림)


-- 예시 3: 여러 집계를 한 번에


-- 예시 4: WHERE + GROUP BY + HAVING 전부


-- 예시 5: 일부러 에러 내보기