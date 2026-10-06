// 연습문제 풀어보기
// 문제 1 )결과 예측
console.log("===== 1 =====");
function calc(a, b) {
    const sum = a + b;
};
console.log(calc(1, 2));   //예측: sum? | 땡 => undefiend

function format(price, unit = "원") {
    return price + unit;
}
console.log(format(1000));          //예측: 1000원
console.log(format(1000, "달러"));   //예측: 1000달러
console.log(format());              //***** 예측: undefiend | 땡 => undefined원


console.log("===== 2 =====");
// 문제 2 ) 어디서 에러가 나고, 메세지는 무엇일까?
console.log(double(3));     //예측: 6
try {
    console.log(triple(3));     //예측: Cannot access 'triple' before initialization.
} catch (e) {
    console.log("에러: ", e.message);
}
function double(x) { return x * 2};
const triple = (x) => x * 3;


console.log("===== 3 =====");
// 문제 3 ) 함수 작성 
// : 화면에서 넘어온 단가와 수량(둘 다 문자열)로 합계를 구하는 calcTotal(price, qty) 만들기
const calcTotal = (price, qty) => {
    if(qty === "" || qty === "0" ) {   
        console.log("수량을 입력하세요.");   //return이 없으면 출력하고, undefined 반환함.
        return 0;   //***** 막는 경우에 return 0으로 먼저 끝내버리면 else가 필요 없어요. 실무에서 많이 쓰는 "조기 반환" 패턴.
    } else {
        return Number(price) * Number(qty);
    }
} 
console.log(calcTotal("1000", "3"));
console.log(calcTotal("1000", "0"));
console.log(calcTotal("1000", ""));


console.log("===== 4 =====");
// 문제 4 ) 참조 vs 호출 : 결과 예측
function getToday() { return "2026-10-06"; }
const a = getToday;
const b = getToday();
console.log(typeof a);     //예측: function
console.log(typeof b);     //예측: string
console.log(a());          //***** 예측: getToday is not Function | 땡 두 개 답이 엇갈림. 
try { 
    console.log(b());          //***** 예측: 2026-10-06 (string)      | 떙 이거 왜 자꾸 헷갈리는지 원인 파악 및 복습 필요. (이미 호출한 함수는 값이기에 다시 함수로 호출할 수 없다.)
} catch (e) {
    console.log("에러: ", e.message);
}
