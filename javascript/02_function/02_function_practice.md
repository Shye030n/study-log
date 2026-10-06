# 02_function 연습문제 — 틀린 패턴 정리

## 문제 4. 참조 vs 호출 (a()와 b()를 반대로 예측함)
​```javascript
function getToday() { return "2026-10-06"; }
const a = getToday;     // 괄호 없음 → 함수 자체를 담음
const b = getToday();   // 괄호 있음 → 실행 결과를 담음

console.log(a());  // "2026-10-06"
console.log(b());  // 에러: b is not a function
​```

| 변수 | 대입한 것 | 변수 안에 든 것 | () 붙이면 |
|---|---|---|---|
| a | getToday (괄호 X) | 함수 자체 (자판기) | 실행 → "2026-10-06" |
| b | getToday() (괄호 O) | 실행 결과 "2026-10-06" (음료) | 문자열 실행 시도 → b is not a function |

- typeof는 맞힘(a: function, b: string) → 알고 있었는데 ()에서 그 지식을 안 씀
- 오른쪽에 보이는 이름 getToday만 보고 판단한 게 원인

## 자주 틀리는 패턴 2개

### ① 변수 안에 뭐가 들었는지 확인 안 하고, 코드에 보이는 이름으로 판단함
- 해당 문제: 문제 4, 실습 D(typeof value), 실습 E(exprVar(2))
- 습관: () 만나면 멈추고 "이 변수에 지금 함수가 들었나, 값이 들었나?" 먼저 적어야 함
  - 함수 → 실행됨
  - 값 → is not a function

### ② 출력(console.log)을 반환(return)으로 착각함
- 해당 문제: 문제 1(calc), 문제 3(undefined 출력), 실습 A(greet)
- 습관: 함수 읽을 때 return 있는 줄부터 찾아야 함
  - return 없음 → 결과는 undefined
  - 화면에 뭔가 찍히는 것과 반환값은 무관함

## 메모
- 두 패턴 모두 자바에서는 컴파일러가 막아주던 부분 → JS에서는 직접 확인해야 함
- 원리 잡은 곳(문제 2 호이스팅)은 정확히 맞힘
- 피곤하면 "멈추고 확인하기"가 제일 먼저 무너짐 → 늦은 시간엔 무리하지 말 것