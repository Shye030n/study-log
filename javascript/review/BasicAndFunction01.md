| ()가 보이면
1. 지금 실행한다.
2. 함수가 아니면, is not a function
3. 함수면 그 자리는 return 값으로 바뀐다. (return이 없으면 undefined)

## 오답 노트
### 2번 Boolean("0") -> true
- 따옴표 = 문자열. 문자열은 빈 문자열만 ""만 false, 글자가 하나라도 있으면 true.
- falsy 목록에 없으면 전부 true

### 4번 const r = show(5); console.log(r); -> 10, undefined
- show(5): () 있음. -> 지금 실행 -> 함수 안에서 10 출력 -> return 없음 -> r = undefined
- console.log(r): r 뒤에 () 없음 -> 실행 X -> 값만 꺼냄 -> r에는 show(5)의 반환값 undefined만 들어있음. (r은 함수 X)
- is not a function 은 r()처럼 괄호를 붙였을 때만 발생한다.

### 5번 sum() -> NaN
- a = undefined, b = 10 -> undefined + 10 -> 문자열이 없으니 숫자 계산 -> 실패 -> NaN(Not a Number)
- undefined : 값이 없음 그 자체.
- NaN: 숫자 계산을 시도했는데, 실패한 결과
- 비교: format() -> undefined + "원" -> 문자열 있으니 연결 -> "undefined원"

### 6번 typeof x() -> "string"
- 함수를 호출하면 = 함수() 는 값이 된다. 값이 "홍길동" 이기에, typeof string.
- 만약 type of x 라면 function.

### 7번 b(1) -> b is not a function (여기서 프로그램 멈춤)
- 이 시점은 b는 var라 undefined (값)
- 하지만, b(1)은 undefined를 실행하려 했기에, is not a function(에러)
- console.log(b)였다면 undefined 출력

### 8번 calcTotal 
- price * qty -> Number(price) * Number(qty) (명시적 변환)


----- 01_basics -----

문제 1) falsy 값 6개
: 
0, "", null, false, NaN, undefined


문제 2) 결과 예측
```
console.log("7" + 1);
console.log("7" - 1);
console.log(Boolean("0"));  //해결완) 왜 틀렸는가: 단순히 0만 보고, falsy라 생각함. 하지만, string 0 이었음.
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
const r = show(5);  //***** 함수에 5를 넣은 값 실행 중, console.log(n * 2); 이 부분에서 콘솔에 출력되는 것. 하지만, return 값이 없어서 const r = undefined
console.log(r);   //undefined
```
:
(show(5)의 값 자체가 console.log라서, const r = console.log(10);)이라서
아무 값도 출력되지 않을 것 같은데. 그냥 상수 r에 저장/담은 거잖아
r is not function

완벽 이해 완료)
const r = show(5);
[1] 오른쪽부터 실행: show(5)
                  -> 함수로 진입
                  -> console.log(5 * 2) 실행 -> 콘솔에 10 (여기서 출력됨)
                  -> 함수에 return 없음. 따라서 반환값 undefined (함수에 return값이 없다면 무조건 undefined 반환.
[2] 왼쪽에 저장: r = undefined



문제 5) 결과 예측
```
function sum(a, b = 10) {
  return a + b;
}
console.log(sum(5));
console.log(sum(5, 1));
console.log(sum());   //NaN
```
:
15
6
NaN. (***** undefined + 10 => Not a Number.)


문제 6) 결과 예측 (먼저 x, y안에 무엇이 들었는지 적고 시작)
```
function getName() { return "홍길동"; }
const x = getName;
const y = getName();
console.log(x());
console.log(y);
console.log(typeof x());    //함수() = 값. x() = "홍길동". 따라서, type of x() = string
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
console.log(b(1));    // b의 값은 undefined. undefined인 변수에 ()를 붙여 '실행'하려 함 = undefined를 실행하려 했기에, b is not a function 에러 출력
function a(n) { return n + 1; }
var b = function(n) { return n + 1; };    
```
:
2
undefined


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
		return price * qty;   //명시적 변환하는 거 명심하기. return Number(price) * Number(qty);
	}
}
```