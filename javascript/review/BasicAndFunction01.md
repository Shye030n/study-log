----- 01_basics -----

문제 1) falsy 값 6개
: 
0, "", null, false, Nan, undefined


문제 2) 결과 예측
```
console.log("7" + 1);
console.log("7" - 1);
console.log(Boolean("0"));
console.log(1 === "1");
```
:
71
6
false
false



문제 3) 결과 예측
```
function f() {
  if (true) {
    var a = 1;
  }
  console.log(a);
}
f();
console.log(a);
```
: 
1
a is not defined


----- 02_function -----

문제 4) 결과 예측 (몇 줄이 출력되는지도)
```
function show(n) {
  console.log(n * 2);
}
const r = show(5);
console.log(r);
```
:
(show(5)의 값 자체가 console.log라서, const r = console.log(10);)이라서
아무 값도 출력되지 않을 것 같은데. 그냥 상수 r에 저장/담은 거잖아
r is not function



문제 5) 결과 예측
```
function sum(a, b = 10) {
  return a + b;
}
console.log(sum(5));
console.log(sum(5, 1));
console.log(sum());
```
:
15
6
undefined/Nan 둘 중 하나 (이 부분 왜 헷갈리지?)
(undefined 도 NaN도 다 falsy 값인데, NaN이 더 맞는거 같은 느낌? undefined는 var 위에서 변수사용하는 코드 썼을 때 나오니까?)


문제 6) 결과 예측 (먼저 x, y안에 무엇이 들었는지 적고 시작)
```
function getName() { return "홍길동"; }
const x = getName;
const y = getName();
console.log(x());
console.log(y);
console.log(typeof x());
console.log(y());
```
:
홍길동
홍길동
function
y is not a function

문제 7) 결과 예측 : (try/catch 없음 주의)
```
console.log(a(1));
console.log(b(1));
function a(n) { return n + 1; }
var b = function(n) { return n + 1; };
```
:
2
undefine


문제 8) 직접 작성_ 지난 번 TODO 였던 calcTotal(price, qty)를 함수 선언문으로 보지 않고 써보세요.
- price, qty 는 문자열
- qty가 "" 또는 "0"이면 "수량을 입력하세요.
- 아니면 숫자로 바꿔서 단가 x 수량 반환.
:
```
function calcTototal(price, qty) {
	if (qty === "" || qty === "0") {
		console.log("수량을 입력하세요.")
		return 0;
	} else {
		return price * qty;
	}
}
```