# 자바 | DB (Oracle)
class Member  <->  TABLE member
필드 (id, name ...)  <-> column (열)
new Member(...) 객체/인스턴스 하나  <->  row (행) 1줄
List<Member>  <->   SELECT 결과 (여러 행)
HashMap의 key   <->    PRIMARY KEY
생성자에서 null 검증    <->     NOT NULL 제약 조건

# DB
- 디스크에 데이터 영구 저장 (자바는, 프로그램이 끄나면 메모리에서 사라짐)
    => 잘못된 데이터가 애초에 들어오지 못하도록 막는 규칙 (제약조건)을 테이블 설계 단계에 걸어둠.
- member라고 해도, 내부적으로는 MEMBER 로 기록됨.

## 데이터 타입
- VARCHAR2 : 오라클은 무조건 VARCHAR2 (Oracle 표준)
- VARCHAR2(4) : 최대 4byte 문자열  <->     String(java)

- NOT NULL : 이 컬럼은 비워둘 수 없다.

- NUMBER : 자릿수 제한 없는 숫자    <->     long,double(java)
- NUMBER(3) : 최대 3자리 정수 (0~999)    <->     int(java)
- NUMBER(5,2) : 12345.67    <->     double/BigDecimal

- Date : 날짜 + 시각(초단위)    <->     LocalDateTime

### 
1층 : 터미널 (zsh)
---
docker exec -it oracle sqlplus ...
---
2층 : SQLPlus (Oracle)

```
docker exec -it oracle sqlplus study_log/study_log@FREEPDB1
```
- docker exec : 실행중인 컨테이너 안에서 명령을 하나 실행하라
- -it : 키보드로 입력을 주고받을 수 있게 대화형으로 열어라
- oracle : 대상 컨테이너명
- sqlplus : 컨테이너 안에서 실행할 프로그램(Oracle 전용 SQL 입력창)
- study_log/study_log : 계정명/비밀번호
- FREEPDB1 : 접속할 DB 명(java로 치면 JDBC URL의 DB명 부분)

## 에러 로그
ORA- 로 시작 : DB가 낸 에러(SQL 문법, 테이블 없음 등)
SP2- 로 시작 : sqlplus 프로그램이 낸 에러 (파일 못찾음, sqlplus 명령 오타 등)

### @/sql/00_init/01_create_member.sql
@ : sqlplus 명령어. 이 파일을 실행해라
/ : 가장 앞의 /는 최상위 폴더(루트)부터 시작해라. 이 경로는 맥이 아니라 SQL 컨테이너 안의 경로다.
    - 최상위 폴더는 `/` 자체이고, `sql`은 그 바로 아래에 있는 폴더 중 하나다.
    - 경로 중간의 / 는 폴더 구분 기호 (/ → sql → 00_init → 01_create_member.sql)
```
컨테이너 안 (sqlplus가 보는 세상)       맥 (VS Code)
/                                      ~/workspace/lab/study-log/
└── sql/        ◀══ 서로 연결됨 ══▶     └── sql/
    └── 00_init/                            └── 00_init/
        └── 01_create_member.sql                └── 01_create_member.sql
```
    - 그래서 VS Code에서 파일 수정 → 저장하면 컨테이너 안 /sql/... 에도 바로 반영됨

### SQL 입력기가 지저분할 땐
Ctrl + U 로 현재 줄 통째로 지우면 됑 ~

### 내 계정에 어떤 테이블이 있는지 확인하려면,
```
SELECT table_name FROM user_tables;
```
user_tables는 Oracle이 관리하는 내 테이블 목록.