console.log("===== A. 선언과 호출, return =====");
function add(a, b) {    
    return a + b;
}
const result = add(2, 3);
console.log(result);    //예측 : 5
console.log(add("2", 3));    //예측 : 23

function greet(name) {
    console.log(`안녕, ${name}`);   //출력만하고 return은 없음.
}
const g = greet("홍길동");  //예측: 안녕, 홍길동
console.log(g);     //예측: 안녕, 홍길동 | 땡 => undefined. 이유: greet함수는 코드를 호출한 곳에 값을 반환하지 않아서.
// ***** 출력(console.log)과 반환(return)은 다르다. 함수에 return 값이 없으면 undefined를 반환한다.

console.log("===== B. 매개변수 개수와 기본값 =====");
function multiply(a, b) {
    return a * b;
};
console.log(multiply(2, 3));    //예측: 6
console.log(multiply(2));       //예측: 2? undefined? | 땡 => NaN(인자누락버그)
console.log(multiply(2, 3, 4)); //예측: 6? undefined? | 6. | 넘친 4는 무시해버림.

function multiply2(a, b=1) {    //b가 없다면 1을 사용
    return a * b;
}
console.log(multiply2(5));      //예측: 5
console.log(multiply2(5, 3));   //예측: 15

console.log("===== C. 함수표현식과 화살표함수 =====");
const subtract = function(a, b) {
    return a - b;
};          // ***** 변수 선언문이라 끝에 ; 필요
console.log(subtract(10, 4));   //예측: 6

const square = (x) => x * x;
console.log(square(4));     //예측: 16

const divide = (a, b) => {
    return a / b;
};
console.log(divide(7, 2));  //***** 예측: 3   | 땡 => 3.5 | 이유: 왜? '/'연산은 몫만 계산하는 연산 아님? 아니래~ | 나머지 연산은 % 지만, 몫만 필요한 경우에는 Math.floor(7 / 2)를 사용해야 함.

console.log("===== D. 함수도 값이다. =====");
console.log(typeof add);    //예측: function

const plus = add;       // *괄호 없이 함수 자체를, const 변수 plus에 담음.
console.log(plus(10, 20));      //예측: 30   
console.log(typeof plus);   //예측: function

const value = add(10, 20);      
console.log(typeof value);  //***** 예측: function | 땡 => number |이유: add함수를 호출해서 반환한 값이 30이라서 마지막에 const value = 30 이니까, number출력인가? ㅇㅇ 마즘.

console.log("===== E. 함수 호이스팅 =====");
 console.log(hoisted(2));   //예측: 20 | 함수 선언문이라, 선언 위에서도 정상 작동.
 //함수선언식
 function hoisted(x) {
    return x * 10;
 }
 
 try {
    console.log(exprConst(2));
 } catch (e) {
    console.log("에러: ", e.message);   //예측: 에러 exprConst is not initial... => Cannot access 'exprConst' before initialzation
 }
 //함수표현식
 const exprConst = function(x) { return x * 10; }

try {
    console.log(exprVar(2));
} catch (e) {
    console.log("에러: ", e.message);   //***** 예측: var라서 에러가 아니라, 값인 undefined | 잉? 에러라고? 값아녀? | 이유: console.log(exprVar); 이었다면 undefined 이 맞음. undefined인 상태에 ()를 붙여 실행하려 했기에, 실행할 수 없는 값을 실행하려 했으니, exprVar is not a function(TypeError). 에러 발생. fn vs fn() 문제.
}
 //함수 표현식
 var exprVar = function(x) { return x * 10; }

console.log("===== F. 함수 스코프 =====");
const project = "차세대";
function showInfo() {
    const team = "계정계";
    var inner = "함수 안의 var";
    console.log(project);   //예측: 차세대
    console.log(team);      //예측: 계정계
}
showInfo();    //예측: 차세대 enter 계정계

try {
    console.log(team);  //예측: undefined (변수 범위 벗어남.) => team is not defined
} catch (e) {
    console.log("에러: ", e.message);
}
try {
    console.log(inner);   //***** 예측: 함수 안의 var | 이유: var는 한 블럭 바깥까지가 스코프라서 | 헐, var는 if/for에서는 여러 겹이어도 전부 뚫지만, function을 만나면 범위가 막혀버리는 걸 이제 알았네~
} catch (e) {
    console.log("에러: ", e.message);
}

