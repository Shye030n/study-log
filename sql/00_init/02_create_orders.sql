CREATE TABLE ORDERS (
    order_id NUMBER PRIMARY KEY,
    member_id NUMBER NOT NULL,
    product_name VARCHAR2(90) NOT NULL,
    quantity NUMBER(3),
    price NUMBER (8),
    order_date DATE
);