-- CREATE SEQUENCE seq_member
--     START WITH 1
--     INCREMENT BY 1
--     NOCACHE;
 
-- CREATE SEQUENCE seq_orders
--     START WITH 1
--     INCREMENT BY 1
--     NOCACHE;
 
-- CREATE SEQUENCE seq_test
--     START WITH 1 INCREMENT BY 1 NOCACHE;

SELECT seq_test.CURRVAL FROM dual;  
SELECT seq_test.NEXTVAL FROM dual;  
SELECT seq_test.NEXTVAL FROM dual;  
SELECT seq_test.CURRVAL FROM dual;  
-- 예상 : 1 => 땡 ! ) NEXTVAL(번호 뽑기) 전에 CURRVAL 하면 ORA-08002 에러 : 뽑은 번호표가 없는데, 번호표를 보여달라 하기에!
-- 예상 : 2 => 땡
-- 예상 : 3 => 떙
-- 예상 : 3 => 땡

-- 답안 : X, 1, 2, 2 (이해 완)

-- CREATE SEQUENCE seq_test2
--     START WITH 100 INCREMENT BY 10 NOCACHE;

SELECT seq_test2.CURRVAL FROM dual;  
SELECT seq_test2.NEXTVAL FROM dual;  
SELECT seq_test2.NEXTVAL FROM dual;  
SELECT seq_test2.CURRVAL FROM dual;  
-- 예상 : X
-- 예상 : 100
-- 예상 : 110
-- 예상 : 110

-- 아 데이터 파일 돌릴 때마다 누적되네. 그래서 두번 돌리니까 에러 안남