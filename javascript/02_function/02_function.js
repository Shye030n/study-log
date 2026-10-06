console.log("===== A. 선언과 호출, return =====");
function add(a, b) {    
    return a + b;
}
const result = add(2, 3);
console.log(result);    //예측 : 5
console.log(add("2" + 3));    //예측 : 5

function greet(name) {
    console.log(`안녕, ${name}`);   //출력만하고 return은 없음.
}
const g = greet("홍길동");  //예측: 안녕, 홍길동
console.log(g);     //예측: 안녕, 홍길동 | 땡 => undefine. 이유: greet함수는 코드를 호출한 곳에 값을 반환하지 않아서.
//잉? 출력과 반환은 다르다는 걸 보여준다는뎅 그냥 fn이랑 fn() 이랑 다르다는 거 아냐?

console.log("===== B. 매개변수 개수와 기본값 =====");
function multiply(a, b) {
    return a * b;
};
console.log(multiply(2, 3));    //예측: 6
console.log(multiply(2));       //예측: 2? undefined?
console.log(multiply(2, 3, 4)); //예측: 6? undefined?

function multiply2(a, b=1) {    //b가 없다면 1을 사용
    return a * b;
}
console.log(multiply2(5));      //예측: 5
console.log(multiply2(5, 3));   //예측: 15

console.log("===== C. 함수표현식과 화살표함수 =====");
const subtract = function(a, b) {
    return a - b;
};          // !!!!!변수 선언문이라 끝에 ; 필요
console.log(subtract(10, 4));   //예측: 6

const square = (x) => x * x;
console.log(square(4));     //예측: 16

const divide = (a, b) => {
    return a / b;
};
console.log(divide(7, 2));  //예측: 3   | 땡 => 3.5 | 이유: 왜? '/'연산은 몫만 계산하는 연산 아님?

console.log("===== D. 함수도 값이다. =====");
console.log(typeof add);    //예측: function

const plus = add;       // *괄호 없이 함수 자체를, const 변수 plus에 담음.
console.log(plus(10, 20));      //예측: 30   

const value = add(10, 20);      
console.log(typeof plus);   //예측: function
console.log(typeof value);  //예측: function | 땡 => number |이유: add함수를 호출해서 반환한 값이 30이라서 마지막에 const value = 30 이니까, number출력인가? 
// ***** 이거 이유 명확하게 알아야겠음 

console.log("===== E. 함수 호이스팅 =====");
 console.log(hoisted(2));
 //함수선언식
 function hoisted(x) {
    return x * 10;
 }
 
 try {
    console.log(exprConst(2));
 } catch (e) {
    console.log("에러: ", e.message);   //예측: 
 }

 //함수표현식
 const exprConst = function(x) { return x * 10; }

 //함수 표현식
 var expVar = function(x) { return x * 10; }

console.log("===== A. 선언과 호출 =====");

