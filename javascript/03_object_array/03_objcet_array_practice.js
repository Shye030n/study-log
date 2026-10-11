//연습 문제
//문제 1) 결과 예측
console.log("===== 문제 1. 결과 예측 =====");
const member = { 
    name: "홍길동",
    grade: "VIP"
};
const key = "grade";
console.log(member.name);   //예측: "홍길동"
console.log(member.key);    //예측: undefined
console.log(member[key]);   //예측: "VIP"
console.log(member.age);    //예측: undefined


//문제 2) 결과 예측
console.log("===== 문제 2. 결과 예측 =====");
const a = { balance: 1000 };
const b = a;
b.balance = 0;
console.log(a.balance);     //예측: 0
console.log(a === b);       //예측: true


//문제 3) 함수 작성_아래 계좌 목록으로 두 함수를 만드세요.
const accountList = [
    { accountNo: "1001-01", name: "가나다", balance: 10000 },
    { accountNo: "1001-02", name: "라마바", balance: 20000 },
    { accountNo: "1001-03", name: "사아자", balance: 50000 }
];
console.log("===== 문제 3. 함수 작성 =====");
/*
- 잔액 합계를 반환하는 함수, getToTalBalance (SQL의 SUM(balance))
- 이름이 같은 계좌 객체를 반환, 없으면 null, findByName(list, name) (SQL의 WHERE name = ?)
- 테스트:
    getToTalBalance(accountList) 
    findByName(accountList, "가나다");
    findByName(accountList, "오호라")
*/
console.log(accountList);
const getToTalBalance = function() {
    let sum = 0;
    for (let i = 0; i < accountList.length; i++) {
        sum = sum + accountList[i].balance;
    }
    return sum;
}

const findByName = function(list, n) {
    for (const row of list) {
        if (row.name === n) {
            return row;
        }
    }
    return null;
}

console.log(getToTalBalance(accountList));
console.log(findByName(accountList, "가나다"));
console.log(findByName(accountList, "오호호"));
// ㅋㅋㅋㅋ 단단히 잘못되었어.




//문제 4) scwin 흉내 _ 아래 조건의 scwin 객체를 만드세요.
//- 속성 searchCount: 0
//- 메서드 btn_search_onclick: 호출될 때마다 this.searchCount를 1 증가 시키고, "조회 N회차" 출력
//- 두 번 호출해서 조회 1회차, 조회 2회차가 나오는지 확인
console.log("===== 문제 4. scwin 객체 만들기 =====");
const scwin = { 
    searchCount: 0,
    btn_search_onclick: function() {
        this.searchCount += 1;
        console.log(`조회 ${this.searchCount}회차`);
    }
};
scwin.btn_search_onclick();     //*** 메서드 사용할 때 객체.메서드()
scwin.btn_search_onclick();
scwin.btn_search_onclick();



