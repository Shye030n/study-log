# 객체와 배열
1) 핵심 키워드
- 객체 리터럴 {}
- 속성(key: value)
- 점 표기법 obj.key
- 대괄호 표기법 obj["key"]
- 없는 속성 -> undefined
- 속성 추가/수정/삭제
- 배열[] 인덱스
- length
- push / pop
- for ... of
- 객체 배열
- 메서드
- this
- 참조 복사
- Cannot read properties of undefined

2) 학습 목표
1. 객체를 만들고 속성을 읽기/추가/수정/삭제할 수 있다.
2. 점 표기법과 대괄호 표기법의 차이를 설명하고, 변수에 담긴 키로 값을 꺼낼 수 있다.
3. 배열을 만들고 인덱스, length, push/pop, for ... of 로 다룰 수 있다.
4. 객체 배열을 SQL 조회 결과 (행/컬럼)와 연결해서 읽고, 합계/검색 함수를 만들 수 있다.
5. 메서드 안의 this 가 무엇을 가리키는지 설명할 수 있다.
6.const b = a 가 객체를 복사하는 게 아니라, 같은 객체를 가리키게 한다는 걸 설명할 수 있다.
7. 실무에서 가장 흔한 JS 에러 Cannot read properties of undefined의 원인을 읽을 수 있다.


3) 연습 문제: 실습을 다 한 후에 풉니다
문제 1) 결과 예측
문제 2) 결과 예측
문제 3) 함수 작성_아래 계좌 목록으로 두 함수를 만드세요.
문제 4) scwin 흉내 _ 아래 조건의 scwin 객체를 만드세요.
- 속성 searchCount: 0
- 메서드 btn_search_onclick: 호출될 때마다 this.searchCount를 1 증가 시키고, "조회 N회차" 출력
- 두 번 호출해서 조회 1회차, 조회 2회차가 나오는지 확인

4) 개념
4-1. 객체 = {key: value} 의 쌍 모음.
```
const Member = {
    name: "홍길동",
    grade: "VIP",
    balance: 50000
};
```
{key: value}의 값을 모아놓은 객체 Member
- 자바와 비교했을 때,
- 클래스 없이 바로 만드는 VO라고 보면 된다.
- 자바는 Member 클래스를 먼저 정의하고, new Member() 를 해야하지만, 
- JS 는 {}로 바로 만든다.
- 동작은 HashMap<String, Object>에 가깝다. 키로 값을 넣고 꺼내고, 실행중에 키를 추가/삭제할 수 있다.

| 자바 HashMap | JS 객체 |
|---|---|
| map.put("name", "홍길동") | member.name = "홍길동" |
| map.get("name") | member.name 또는 member["name"]
| 없는 키 -> null | 없는 키 -> undefined (에러아니고 값)
| map.remove("name") | delete member.name |

4-2. 점 표기법 vs 대괄호 표기법
```
member.grade    //키 이름을 코드에 직접 씀
member["grade"] //키를 문자열로 씀
                // => 결과는 같음

const key = "grade";
member["key"]     // 변수 key 안의 값 "grade"로 찾음 -> "VIP"
member.key      // "key"라는 이름의 속성을 찾음 -> 없음 -> undefined
```
- 키가 변수에 들어 있으면 반드시 대괄호를 써야 한다.
- 점 표기법은 점 뒤에 글자를 그대로 키 이름으로 쓴다.
- 실무에서 "어떤 컬럼을 꺼낼지가 실행중에 정해지는" 경우가 많아서 대괄호도 자주 쓴다.
? 이해 존나 안가는데 쉬발 뭔소리야 그래서 뭐가다른건데. 진짜 코드 예시가 없으니까 이해 안되는거 같음

4-3. 배열 = 번호 붙은 칸
```
const banks = ["농협", "국민", "신한"]; 

banks.length   //3
banks[3]        // undefined (없는 칸이지만 에러 아님.)
```
- 자바의 ArrayList와 비슷.
- push: 끝에 추가 (= 자바의 add)
- pop: 끝에 꺼내기
- 크기: length (= 자바의 size())
- 타입 제한이 없음. => 숫자, 문자열, 객체를 한 배열에 넣을 수 있다. (자바와 다른 점)

반복은 두 가지가 있다
```
for (int i = 0; i < banks.length; i++ { banks[i] }  //  자바와 같은 for문
for (const bank of banks) { bank }                  // 자바의 for-each 문과 비슷
```
- 인덱스로 접근 필요가 없다면 for ... of 문이 깔끔하다. (자바의 for-each)


4-4. 객체 배열 = SQL 조회 결과
지금하고 있는 SQL과 직결된다.
```
SELECT account_no, name, balance FROM account;
```

```
const accountList = [
    { accountNo: "101-01", name: "김서현", balance: 50000 },    //[0]
    { accountNo: "101-02", name" "송미심", balance: 100000 }    //[1]
]

accontList[1].name  // "송미심"
```
- 행 = 객체
- 컬럼 = 키
- 결과 집합 = 배열

- 서버(Spring + MyBatis) 가 조회한 결과를 화면으로 보내면, 화면에서는 대체로 이런 모양으로 받아서 그리드에 뿌린다.

4-5. 메서드와 this
- 메서드 = 객체의 속성에 함수를 담은 것
- Day2에서 봤던 scwin.btn_onclick = function() {}
```
const account = {
    balance: 50000,
    deposit: function(amount) {
        this.balance = this.balance + amount;   //this = 점 앞의 객체 = account
        return this.balance;
    }
};
account.deposit(10000);     //60000
```
- 여기서 this는 "이 메서드를 호출할 때 점 앞에 있던 객체."
- account.deposit()이면, this = account
- 자바의 this와 비슷한 감각
- 하지만, 화살표 함수의 경우는 다르다.
- 화살표 함수는 자기만의 this 가 없다. 
- 그래서 객체 메서드를 화살표 함수로 만들면 this가 그 객체를 가리키지 않기 때문에,
- Day2에서 이벤트 함수는 function() 형태를 따르는 것이 안전하다고 한 이유가 이것.

4-6. 참조 복사 _ 자바와 동일
```
const a = { balance: 1000 };
const b = a; 
```
= 객체는 하나고, a 와 b는 같은 주소를 가리킴.
- 그래서.
- b.balance = 0 하면 -> a.balance = 0이 된다
- 자바에서 Member b = a; 후에 b.setBalance(0) 하면 a도 바뀌는 것과 동일
- 배열도 이와 같다.

4-7. 실무 최다 에러: Cannot read properties of undefined
```
const lis = [{ name: "홍길동" }];
list[0].name    //"홍길동"
list[5]         //undefined(값)
list[5].name    //Cannot read properties of undefined (reading 'name')=> 존재하지 않는 키의 속성을 꺼내려할/불러올 때 발생하는 에러.
```
- TypeError: Cannot read properties of undefined (reading 'name') 는,
- 자바의 NullPointException과 같은 위치의 에러.
- 'name'이라는 속성을 꺼내다 터진 에러인지 친절히 알려줌.
- 그 앞쪽이 undeifined 였으니, 거슬러 올라가며 에러를 찾으면 됨.

5) 실무 연결 포인트
* 그리드 데이터 = 객체 배열
    - WebSquare 그리드에 연결된 데이터는 구조적으로 "행 객체들의 목록".
    - WebSquare에는 이걸 다루는 전용 객체(DataList)와 API가 있지만, 그 안의 데이터 감각은 오늘 배우는 객체 배열과 같다.
* 서버 통신 데이터
    - Spring Controller가 VO/DTO 리스트를 반환하면, JSON 으로 바뀌어 화면에 뿌려지고, 화면에서는 객체 배열로 받는다. 
    - 오늘 배우는 부분이 Java VO <-> JS객체 의 연결 고리. (JSON 자체는 04에서)
* scwin
    - scwin은 그냥 객체다.
    - scwin.onpageload, scwin.btn_search_onclick 
    - 처럼 화면의 함수들을 한 객체에 모아두는 관례. 
    - 다른 화면과 함수 이름이 겹치지 않게 묶어두는 역할.
* Cannot read properties undefined (reading 'x')
    - WebSquare 화면 개발에서도 가장 자주 보이게 될 에러 중 하나.
    - "조회 결과가 0건인데, 첫 행을 꺼냈다.", "컬럼 ID 오타"
    - 같은 상황에서 나오기에, 망분리 상황에서 혼자 읽어낼 수 있어야 함.
* 참조 복사 버그
    "원본 데이터를 보관해두고, 수정본과 비교"하려고,
    - const origin = data; 를 하면
    - 수정할 때 origin도 같이 바뀌기 때문에, 비교할 수 없다.
    - 이는 "변경 여부 체크"할 때 실제로 생기는 버그.
