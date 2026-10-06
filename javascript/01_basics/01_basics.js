console.log("===== A. 동적 타입 =====");

//let
let data = 10;
console.log(typeof data);   //예측: int (X) -> number
data = "열";
console.log(typeof data);   //예측: String -> string
data = true;
console.log(typeof data);   //예측: boolean (O)
//선언만. 값 안넣음.
let notAssigned;
console.log(notAssigned);   //예측: 지정되지 않음 => undefined (진회색)
console.log(typeof notAssigned);    //예측: 지정되지 않은 타입 => undefined
console.log(typeof null);   //예측: 지정되지 않은 타입 => object

console.log(7 / 2);     //예측 3 (X) => 3.5
console.log(0.1 + 0.2);     //예측 0.3 => 0.30000000000000004

console.log("===== B. 형변환 =====");   
console.log("5" + 3);           //예측: 53 (O)
console.log("5" - 3);           //예측: 53(X) => 2
console.log("5" * 3);           //예측: 555(X) => 15
console.log(Number("5") + 3);   //예측: 8
console.log(Number("abc"));     //예측: NaN

const userName = "홍길동";
const userAge = 30;
console.log(`이름: ${userName}, 나이: ${userAge}`);    //예측: 이름: 홍길동, 나이: 30

console.log("===== C. 비교 =====");
console.log(1 == "1");      //예측: true
console.log(1 === "1");      //예측: false
console.log(0 == "");      //예측: false (X) => true
console.log(0 === "");      //예측: false
console.log(null == undefined);     //예측: false(X) => true
console.log(null === undefined);      //예측: false


console.log("===== D. truhty/falsy =====");
console.log(Boolean(0));     //예측: false
console.log(Boolean(""));     //예측: false
console.log(Boolean("0"));     //예측: true
console.log(Boolean(" "));     //예측: true
console.log(Boolean("false"));     //예측: true
console.log(Boolean(null));     //예측: false
console.log(Boolean([]));     //예측: true

const cellValue = "";
if (cellValue) {
    console.log("값 있음");
} else {
    console.log("값 없음");
}   //예측: 값 없음

console.log("===== E. var/let/const =====");

//E-1. const 재할당
const MAX = 100;
try {
    MAX = 200;
} catch (e) {
    console.log("에러: ", e.message);   //const로 초기화 된 변수라, 값 변경이 불가능하다는 에러메세지
}

//E-2. const 객체 내부의 값 변경
const member = {name: "홍길동"};
member.name = "김철수";
console.log(member.name);   //예측: 김철수. 가리키는 값 변경은 안된다했지만, 가리키는 객체의 내부 값 변경은 가능하다 했음. 

//E-3. 블록 스코프
if (true) {
    var a = "var 변수";
    let b = "let 변수";
}
console.log(a); //예측: var 변수. 근데 함수 스코프는 함수 내부에서 가능한거아냐? 이건 함수 안이 아닌데? : 가까운 함수의 바깥까지. 현재는 전역
try {
    console.log(b);
} catch (e) {
    console.log("에러: ", e.message);   //예측: b라는 변수가 없습니다?
}

//E-4. for문 변수
for (var i = 0; i < 3; i++) {}// 반복을 진행함
console.log(i);                     //예측: 3 // 반복이 끝난 뒤 i의 값.
for (let j = 0; j < 3; j++) {}        //여기서 j는 초기화가 됐네.
try {
    console.log(j);
} catch (e) {
    console.log("에러: ", e.message);   //j is not defined (j는 정의되지 않았다.) => 이유는, scope 문제
}

//E-5. 호이스팅
console.log(h1);    //예측 : undefined
var h1 = "var 호이스팅";
try {
    console.log(h2)
} catch (e) {
    console.log("에러: ", e.message);   //Cannot access 'h2' before initialization (h2가 초기화 되기 전에는 접근할 수 없다.)
}
let h2 = "h2 호이스팅";
// JS 실행 준비 단계에, var은 undefined로 초기화 되고, const와 let로 선언된 변수/함수는 코드 작성시 초기화 후 사용이 가능하다.


//E-6. 재선언
var dup = 1;
var dup = 2;
console.log(dup);   //예측: 2
let dup2 = 1;
//let dup2 = 2;
// => JS가 코드 실행 준비 할 때 문법검사/선언등록을 하는데 여기서 let dup2를 두 번 발견해서 SyntaxError 발생. 그래서 실행 단계로 넘어가지 못해서 모든 console.log 가 콘솔에 출력되지 않음
// = 자바의 컴파일 에러 (코드 실행 X)
/*
PS C:\Users\user\Desktop\김서현\workspace\study-log\javascript> node 01_basics.js
C:\Users\user\Desktop\김서현\workspace\study-log\javascript\01_basics.js:109
let dup2 = 2;
    ^

SyntaxError: Identifier 'dup2' has already been declared
    at wrapSafe (node:internal/modules/cjs/loader:1861:18)
    at Module._compile (node:internal/modules/cjs/loader:1903:20)
    at Object..js (node:internal/modules/cjs/loader:2060:10)
    at Module.load (node:internal/modules/cjs/loader:1651:32)
    at Module._load (node:internal/modules/cjs/loader:1443:12)
    at wrapModuleLoad (node:internal/modules/cjs/loader:261:19)
    at Module.executeUserEntryPoint [as runMain] (node:internal/modules/run_main:154:5)
    at node:internal/main/run_main_module:33:47

Node.js v24.21.0
*/


