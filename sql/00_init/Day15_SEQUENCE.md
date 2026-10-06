# SEQUENCE: Oracle의 번호 자동 발급기
시퀀스란, 
- MySQL의 AUTO_INCREMENT 처럼 PK의 중복값 방지하기 위한 독립 객체
- 두 가지 호출 방식으로 여러 테이블 간 채번 값을 공유할 수 있게 하는 객체. 
사용 순서만 정확히 지킨다면, 부-자 테이블과 가이 여러 테이블에 얽힌 INSERT 도 어렵지 않게 구현 가능.
- 시퀀스 생성 시, 옵션 뒤에 , 붙이지 않음 (테이블과 다름)

- !) NEXTVAL
(= 시퀀스카운터(DB에 저장된)에서 + INCREMENT BY 숫자 만큼 증감한 값을 반환. 단, 첫 번째 호출은 START WITH 값 그대로 반환)

- !)CURRVAL
(= 현재 세션에서 가장 최근에 NEXTVAL로 받은 값)
- 내 세션이 마지막으로 뽑은 번호 조회. exit하면 사라짐

```
CREATE SEQUENCE 시퀀스명 
    START WITH 시작숫자
    INCREMENT BY 증감숫자

    NOMINVALUE OR MINVALUE 최소값
    NOMAXVALUE OR MAXVALUE 최대값

    CYCLE OR NOCYCLE   
    CACHE OR NOCACHE;
```
- CREATE SEQUENCE 시퀀스명 : 테이블이 아닌, 채번값 공유 독립 객체 생성

- MINVALUE : 최소값 설정 (시작숫자 =< MINVALUE < MAXVALUE)
- MAXVALUE : 최대값 설정 (시작 숫자 =< MAXVALUE && MINVALUE < MAXVALUE)



- NOMINVALUE : 디폴트값 설정 (증가일 때 1, 감소일 때 −(10²⁷−1))
- NOMAXVALUE : 디폴트값 설정 (증가일 때 10²⁸−1,, 감소일 때 -1)

- CYCLE : 최대값에 도달하면, 최소값부터 다시 시작
(** PK용 
- NOCYCLE : 최대값에 도달 후, NEXTVAL 하면 에러(ORA-08004), 발급 중단

- CACHE : 메모리에 시퀀스 값을 미리 할당
- NOCACHE : 메모리에 시퀀스 값 할당하지 않음


## NEXTVAL vs CURRVAL

- NEXTVAL : 다음 번호로 증가시킨 걸 반환 (언제든 호출 가능. 카운터는 DB에 저장)
- CURRVAL (Current, 현재의)
: 현재 세션에서 가장 최근 NEXTVAL 값 재반환 (현재 세션에만 저장. NEXTVAL 하기 전에 하면 ORA-08002 에러)

- DUAL : 
- 번호 건너뜀 (gap)
- (참고) IDENTITY

## gap 이유 (번호 건너뜀)
- ** PK 시퀀스는 고유값을 보장하지, 숫자의 연속성/순서를 보장하는 것이 아니기에,
- PK 들 사이에 gap(차이/구멍)이 발생하는 것은 정상이다. 
이유는
- CACHE 옵션을 설정한 경우, 시퀀스는 성능을 위해 여러 개의 번호를 메모리에 미리 확보해 두는데,
1. 서버가 비정상 종료
2. RAC 환경에서 인스턴스가 바뀌는 
등의 경우에, 미리 뽑아둔 시퀀스를 버림.
- INSERT 후 ROLLBACK 하거나 INSERT 실패해도 이미 뽑은 번호는 돌아오지 않음

### MyBatis에서 selectKey 순서를 잘못 두는 경우
```
<selectKey keyProperty="id" resultType="long" order="BEFORE">
    SELECT seq_member.NEXTVAL FROM dual
</selectKey>
```
-- INSERT 하기 전에 번호표를 먼저 뽑아, 자바 객체의 id 필드에 넣어라 라는 뜻.

- INSERT 이전에 시퀀스 값을 미리 받아와야 하는 selectKey는 order="BEFORE"로 설정해야 한다. 
- 이 순서를 반대로 두면 INSERT 문에서 필요한 PK 값이 아직 채번되지 않은 상태로 실행되어 오류가 발생한다.

### 배치 작업에서 시퀀스를 대량으로 소모하는 경우
- 야간 배치로 수만 건을 한 번에 INSERT하는 작업은 시퀀스 번호를 그만큼 빠르게 소모한다. 
- CACHE 옵션 값이 너무 작으면 매번 시퀀스 정보를 디스크에서 다시 읽어오느라 배치 속도가 느려질 수 있으므로, 대량 처리가 잦은 시퀀스는 CACHE 값을 여유 있게 잡아두는 편이 성능에 유리하다. 
- 반대로 시퀀스 값이 실제 데이터양보다 지나치게 빨리 늘어나는 것이 부담스럽다면 CACHE 값을 낮추는 대신 배치 처리 방식을 다시 검토하는 편이 낫다.



## 실무 연결 포인트


3. IDENTITY 컬림이 있기도 하지만, Oracle 12c 부터 id NUMBER GENERATED ALWAYS AS IDENTITY 처럼 SQL 자동 증가를 붙일 수 있지만, 금융권 SI 는 오래된 방식인 sequence를 많이 사용한다.
4. CURRVAL은 내 세션 전용. 다른 사람이 동시에 NEXTVAL 을 뽑아도, 현재 

## SEQUENCE 는 왜 필요한가,
- DB가 번호를 자동으로 +1
- = (MySQL, AUTO_INCREMENT)

### 비유 : 은행 번호표 기계
- NEXTVAL : 번호표를 새로 한 장 뽑는다. 뽑는 순간 숫자가 올라간다
- CURRVAL : 방금 뽑은 번호표를 다시 들여다본다. 새로 뽑지 않는다.
- gap : 번호표를 뽑고 창구에 가지 않고, 가버리면 그 번호는 버려진다. 기계는 번호를 되돌리지 않는다. 이게 번호 건너뜀.

### 자바로 동작 원리를 바라보면
```
public class Member {
    private static long nextId = 1;     //SEQUENCE
    private final long id;

    public Member(String name) {
        this.id = nextId++;     //NEXTVAL : 즉시 숫자 자동 + 1
    }
}
```
여기서 static은, 
- 여러 객체들이 공통적으로 공유하는 필드.
- 카운터가 객체들 바깥에서 하나만 존재하며 번호를 나눠주는 것과 같다. 
- 시퀀스도 테이블 바깥에 따로 존재하는 독립 객체이다.

### MySQL AUTO_INCREMENT 의 차이
MySQL (AUTO_INCREMENT)
```
CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ...
);
```
- 컬럼에 붙은 속성
- INSERT 할 때 id 생략해도 자동으로 +1 됨

Oracle (SEQUENCE)
```
CREATE SEQUENCE seq_member ... ;    //SEQUENCE 따로 생성

CREATE TABLE member (
    id NUMBER PRIMARY KEY, ...
);
```
- INSERT 할 때 seq_member.NEXTVAL 을 직접 넣어줌
- 넣어주지 않으면 id 는 비어 있음 (PK 위반 에러)
** Oracle에서 SEQUENCE와 TABLE은 서로를 모른다. 이름이 seq_member 라서 member 전용처럼 보이지만, 이는 사람이 정한 이름일 뿐.
** 연결은 개발자가 직접 해야 함. 
- 테이블 안에 시퀀스를 붙이는 문법 자체가 존재하지 않는다.
```
CREATE SEQUENCE seq_member      //seq_member 라는 이름의 번호 발급기를 만듦 (실무 이름 규칙 = SEQ_테이블명/테이블명_SEQ)
    START WITH 1                //처음 뽑을 때의 번호는 1 (생략해도 1)
    INCREMENT BY 1              //한 번 뽑을 때 1씩 증가 (생략해도 1)
    NOCACHE;                    //번호 20개를 메모리에 미리 뽑아두지 마라. (성능 옵션: 번호를 몇 장씩 미리 준비할 지)
```
** 테이블과 다르게, 쉼표(,)로 구분하지 않는다.
NOCACHE : ?? 
- Oracle은 기본적으로 속도를 위해 번호 20개를 미리 메모리에 뽑아둔다(CACHE 20). 
- DB 재시작되면 메모리에 있던 번호들이 날아가서
- 1,2,3 다음에 21이 나오기도 한다.
- 따라서 연습할 때는 번호가 눈에 보이게 이어지도록 NOCACHE를 쓴다. 
NOCACHE를 안쓰면?
- 기본값 CACHE 20 이 적용된다. 번호 20개를 메모리에 미리 준비해두니 빠르지만, DB를 재시작하게 되면, 남은 번호가 버려져 gap이 생긴다. 실무에서는 성능 때문에 CACHE 를 쓰는 경우가 많다. gap이 생기는 것은 자연스러운 일.

### 번호 뽑아보기 : DUAL

시퀀스명.NEXTVAL = 번호 뽑기
```
SELECT seq_member.NEXTVAL FROM dual;    --번호표 뽑기

SELECT seq_member.CURRVAL FROM dual;    --현재 세션에서 마지막 번호
```
? ) NEXTVAL 와 CURRVAL dual의 풀네임은 뭘까
? ) dual은 뭐야? 객체? 번호 저장 가짜 테이블? 
dual 이란, (두 개의)
- Oracle이 제공하는 행 1개짜리 가짜 테이블
- Oracle의 SELECT는 반드시 "FROM 테이블"이 있어야 하는데,
- 현재 테이블에서는 꺼낼 게 없고, 값 하나만 보고 싶기에, dual을 사용한다.
? ) 그냥 간단하게, NEXTVAL은 다음 번호 뽑는거고(숫자 자동 증가)  CURRVAL은 그냥 현재 세션에서 숫자 확인만하는 건가?

### 실제 테이블 사용 예시
```
INSERT INTO member (id, name, age, region)
    VALUES (seq_member.NEXTVAL, '김철수', 26, '서울');
```
