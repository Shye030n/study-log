### 문제 풀며 추가 개념
undefined 는 값, 변수는 있는데 값이 없는 상태라 에러 없이 출력
not defined 는 에러, 현재 위치에서 그 이름 자체를 모른다는 뜻으로 실행 중단

호이스팅 에서
Cannot access 'q' before initialization 에러가 발생하면 코드 중단. 하위코드 실행 X

=> 최종
undefined / not defined / before initialization 핵심
is
- (에러) x is not defined
    스코프 밖
    선언 안함
    오타
- (에러) Cannot access 'x' before initialization 
    let/const 선언 줄 보다 위에서 사용
- (값) undefined
     var 선언 줄 보다 위에서 사용
     let x; 처럼 값 초기화 없이 사용


지금 위치에서 x라는 이름을 찾을 수 없는 경우 두 가지 상황
1. 선언은 했지만 스코프 밖에서 사용 (Q5의 y, E-4의 j)
2. 아예 선언한 적이 없는 이름을 사용 (오타 포함)

truthy / falsy
밑에 재정리함.

---

### console.log();
    = 자바의 System.out.println();

### typeof 값
    = 값의 타입을 문자열로 반환
    + typeof null = object로 나오는 이유는, JS 초창기 버그가 그대로 굳은 것. 따라서 null인지 확인하려면, 
        !!!) 
        ```
        value === null
        ``` 
    로 확인한다.

###  JS 가 자동으로 데이터 타입을 바꿔버림.
    +는 문자열도 가능하니 상관 없지만, -, *, / 연산자 앞에서는 문자열을 숫자로 바꿔서 계산을 시도.
    ex) "5" + 3 = 53, "5" - 3 = 2

### Number(값)
    = 명시적으로 숫자로 변환.
    = 자바의 Integer.parseInt();
    - 숫자로 못바꾸는 값은 Nan(Not a Number)

### == vs ===
    == 는 값만 비교 (타입이 다른 경우 JS가 자동으로 타입을 변환하여, 값 자체만 비교)
    === 는 값 + 데이터 타입까지 비교
    null인지 확인하려면 === null로 비교해야 한다.

### console.log
    에서 ` 은 백틱. 작은따옴표 쓰면 ${} 작동 X
    ${} 은, 변수나 식의 값을 끼워넣는 문법

### truthy/falsy
     자바의 if 안에는 boolean 형만 들어갈 수 있어 if(qty)는 컴파일 에러가 난다.
    하지만, JS의 경우 "5" - 3 처럼 문자열 -> 숫자로 자동 변환해서 계산하듯
    ```
    "5" - 3   →  "5"를 숫자로 자동 변환   →  5
    if ("0")  →  "0"을 boolean으로 자동 변환  →  ?
    ```
    문자열을 true/false로 구분하는 규칙은 정해졌다. falsy인 경우만 알면 된다.
    falsy 에 해당하는 경우에는, ""(빈문자열), null, undefined, 0, false, Nan 만 false로 반환된다.
    여기서 "0"은 문자열이 있기에 true.

### var
    - 재할당 : 가능
    - 재선언 : 가능(경고 X)
    - 범위 : 함수스코프 (가장 가까운 함수의 바깥까지. 감싸는 함수가 없으면 파일 전역이 범위가 됨)

### let 
    - 재할당 : 가능
    - 재선언 : 불가
    - 스코프 : 블럭{}

### const
    - 재할당 : 불가
    - 재선언 : 불가
    - 스코프 : 블럭{}
    - 자바의 final 상수와 비슷
    - !!!!) 변수가 다른 객체를 가리키게 바꿀 수는 없지만, 객체 내부 값은 바꿀 수 있음. 
    ```
    const user = { name: "A" };   // 1
    user.name = "B";              // 2 객체 내부 값 변경 O
    user = { name: "C" };         // 3 재할당 불가 X

    ```
    const member = { name: "홍길동" };
        //member ──(const로 고정)──▶ { name: "홍길동" }

    member.name = "김철수";
        //→ 화살표는 그대로, 화살표 끝 객체의 내용만 변경 → OK

    member = { name: "김철수" };
        //→ 화살표를 새 객체로 돌리려 함 = 재할당 → TypeError
    ```
    즉, 변수의 재할당은 안되지만, 내부의 값 변경은 가능하다.



### 실무 변수 사용 선택 기준
    1. 기본은 const
    2. 값만 바꿔야 할 때만 let
    3. var는 새로 쓰지 않지만, 읽을 줄은 알아야 한다. (함수 스코프)

### 호이스팅 : JS 엔진은 코드를 두 번 훑는다.
: JS 엔진은 코드를 실행하기 전에 준비 단계를 거친다.

    1. 준비 : 코드 전체를 훑어서 '선언'을 미리 등록한다.
            var 변수 -> 등록 + undefined 초기화
            let / const ->등록만 하고 초기화는 하지 않는다. (TDZ:접근금지구역)
    2. 실행 : 위에서 아래로 한 줄씩 실행
            선언문에 도달해야 let/const 가 사용 가능해진다.

    Cannot access 'x' before initialization 을 보면, 선언 전에 먼저 사용한 것을 인지하는 습관 형성 필요.

    코드 실행 준비 단계에서 변수/함수 등의 존재를 "등록" 해놓고, 실제 코드 실행 단계에서 값을 넣거나 코드를 실행하는 것.
    var, let, const가 등록한 뒤 사용할 수 있는 상태가 서로 다름.

    let과 const는 초기화한 이후에만 사용할 수 있다. 초기화 이전에는 사용이 불가하다. 
    변수는 등록되었는데, 초기화가 되지 않음. 
    var는 undefined로 초기화되기에 접근할 수 있음.
    ```
    console.log(a);     //등록됨 / TDZ  //Cannot access 'a' before initialization
    const a = 10;
    console.log(a);     //10


    console.log(b);     //등록됨 / TDZ  //Cannot access 'b' before initialization
    let b = 10;
    console.log(b);     //10


    console.log(c);     // undefined  
    var c = 10;
    console.log(c);     //10
    ``` 
    TDZ (= Temporal Dead Zone)

### 선언
: 이런 이름의 변수를 등록해두는 것
### 초기화
: 처음으로 값을 넣는 것

### try {} catch (e) {}
: 에러가 나면 코드가 실행 중단하기에, 실행 중단하지 않고, 다음 코드로 진행하기 위하여 try{}catch() 구문을 썼다. e 는 에러객체를 출력하기 위한 파라미터.