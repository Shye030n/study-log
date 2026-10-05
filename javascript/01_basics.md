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

### console.log
    에서 ` 은 백틱. 작은따옴표 쓰면 ${} 작동 X
    ${} 은, 변수나 식의 값을 끼워넣는 문법

### truthy/falsy
    - 자바의 if 문 안에는 boolean 값만 들어갈 수 있지만, js 는 아니다.
    - !!) falsy로 취급되는 값 : false, 0, ""(빈문자열), null, undefined, NaN

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