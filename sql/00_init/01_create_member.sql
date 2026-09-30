CREATE TABLE member (      -- <->  public class Member{}
    id NUMBER PRIMARY KEY,  -- 컬럼명 타입 제약조건
    name VARCHAR2(50) NOT NULL,     -- 최대 50byte(한글은 한 글자당 3byte => 최대 16글자)
    age NUMBER(3),
    region VARCHAR2(30)
);

-- id, name 으로 총 2개