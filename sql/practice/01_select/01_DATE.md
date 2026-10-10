# DATE 타입과 TODATE 

## DATE 타입
### 무엇이 저장되는가
    -Oracle의 Date는 '세기,연,월,일,시,분,초'를 7byte 숫자로 저장한다. (문자열 X)
    - 그래서 같은 데이터지만, sqlplus에서는 30-SEP-26, VSCode에서는 2026-09-30처럼 툴의 보여주는 방식에 따라 다르게 보일 수 있다. 

### 왜 문자열이 아닌, DATE(숫자)로 저장되는가
    1. 유효성 검사 (9월 31일이 없다는 것을 인지하고 있음)
    2. 날짜 계산 가능 (DATE에 숫자를 더하면 일(day) 단위로 계산된다.)
        숫자처럼 크기 비교가 되기에, => 나 < 로 범위 조회 가능
```
SELECT SYSDATE      AS 지금,
    SYSDATE + 1     AS 내일_이시각,
    SYSDATE + 1/24    AS 한_시간_뒤,
    DATE '2026-10-01' - DATE'2026-09-30' AS 일_수_차이
FROM DUAL;
```
    - SYSDATE 은, DB 서버의 현재 날짜와 시각 (내 PC 시간 X)
    - +1 은 하루 뒤, +1/24 는 한 시간 뒤.
    - DATE 끼리 빼면 며칠 사이인지 숫자로 나옴.
    - DUAL은 테이블 없이 값을 계산할 때 쓰는 Oracle의 더미 테이블.

```
SELECT ACCT_NO, OPEN_DT, ADD_MONTHS(OPEN_DT, 12) AS 만기일
FROM   ACCOUNT
WHERE  PROD_CD = 'P003';
```

    - ADD_MONTHS(날짜, n) : n개월 뒤 날짜를 구하는 함수. 
        - 12개월 정기예금의 만기일 계산에 사용
        - 그냥 +365하면, 윤년/월말 처리가 틀어지는데, ADD_MONTHS는 알아서 처리해줌.

## TODATE

### 왜 필요한가
    - 날짜를 다루는 경우, 문자열 형태로 들어오는 경우가 대부분. 
    - (사용자가 화면에서 고른 날짜, 프로그램이 넘긴 파라미터, 엑셀에서 가져온 데이터 등) '20260930'같은 문자열.
    - 하지만, DATE 컬럼과 비교/날짜계산을 하려면 진짜 DATE 값이어야 하기에,
    - 문자열 -> DATE 타입으로 변환해주는 메서드가 TODATE(들어온문자열값, DATE타입으로바꿀형식)
```
TO_DATE('20260930 1455', 'YYYYMMDD HH24MI')

문자열:  2 0 2 6 | 0 9 | 3 0 |   | 1 4 | 5 5
형식:    Y Y Y Y | M M | D D | 공백| HH24 | M I
```
    - 형식과 문자열 조각이 짝지어지는 구조. 조금이라도 어긋나면 에러.
```
TO_DATE('2026-09-30', 'YYYYMMDD')     -- ✗ 형식엔 '-'가 없는데 문자열엔 있음
TO_DATE('2026-13-01', 'YYYY-MM-DD')   -- ✗ 13월은 없음
```

### 언제 무엇을 쓸까,
| | | 
| --- | --- |  
쿼리에 고정 날짜를 적을 때	DATE '...'	DATE '2026-09-30'
시간까지 지정할 때 | TO_DATE | TO_DATE('2026-09-30 14:00', 'YYYY-MM-DD HH24:MI')
문자열로 받은 값을 날짜로 바꿀 때 | TO_DATE | TO_DATE('20260930', 'YYYYMMDD')
날짜를 원하는 모양으로 보여줄 때 | TO_CHAR | TO_CHAR(TRX_DTM, 'YYYY-MM-DD HH24:MI)

## 실무 연결 포인트
- 현장에서 가장 많이 보게될 패턴은, 화면에서 조회기간을 고르면, 
- 프로그램이 '20260901'같은 문자열을 넘기고, MyBatis 쿼리에서 이렇게 받는다.
```
WHERE TRX_DTM >= TO_DATE(#{startDt}, 'YYYYMMDD')
    AND TRX_DTM < TO_DATE(#{endDt}, 'YYYYMMDD') + 1 
```

+ ${} : MyBatis에서 Java가 넘긴 값을 SQL안에 끼워넣는 자리표시자
    - 왜 쓰냐면,
        사용자 입력값을 SQL에 바로 이어붙이게되면,
        SQL Injection (값에 SQL문법을 섞어 DB를 조작하는 공격)이 가능하기에,
        문법이 아닌 순수 데이터로만 취급하여 공격을 막음

    - 동작 원리
```
//Java
dto.setEndDt("20260930");   //값 준비

//Mapper
WHERE TRX_DTM < TO_DATE(#{endDt}, ...) //이름으로 자리 지정
    //이를 MyBatis가 변환

-- SQL 실행
WHERE TRX_DTM < TO_DATE(?, ...)
-- ? 자리에 '20260930'을 안전하게 바인딩.
```

### 참고 : '#{ }' MyBatis에서 자세히
    + 같이 나오는 키워드 : #{ }, ${ }, PreparedStatement, ?, Mapper XML, MyBcd atis
        => 실무에서는 기본적으로 #{ }, 
            꼭 필요할 때만 ${ }를 사용.
        - #{endDt} : endDt는 Java 객체의 필드 이름(getter)와 연결
        - ${ } : 값을 문자열로 그대로 이어붙여서 위험.
        
