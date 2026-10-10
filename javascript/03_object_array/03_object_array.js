// A. 객체{} 만들기와 꺼내기
console.log("===== A. 객체 기본 =====");
const member ={
    name: "김서현",
    grade: "VIP",
    balance: 50000
};
console.log(member);

console.log(member.name);       //예측: "김서현"
console.log(member["grade"]);   //예측: "VIP"
console.log(member.age);        //예측: undefined
console.log(typeof member);     //예측: object

const col = "balance";          
console.log(member[col]);       //예측: "balance" | 땡 => 50000
console.log(member.col);        //예측: "balance" | 땡 => undefined
// 아 혹시 [] 이거는 상수/변수로 접근하는 거고, . 은 객체에 직접 접근 하는거야?
// 그래서 member[col] => member["balance"] => member의 key 'balance'의 value 고,
// member.col 은 member 객체에 col 이라는 key가 없어서. undefined (값)이 출력 되는거야?
// + 추가 '객체.키'로 바로 접근 / '객체["괄호안을계산해서키로쓰겠다"]'

// B. 객체에 속성 추가/수정/삭제
console.log("===== B. 객체 속성 추가/수정/삭제 =====");
member.phone = "010-1234-5678";     //없던 속성 추가
member.grade = "GOLD";              //있던 속성 수정
delete member.balance;              //    속성 삭제
console.log(member);
console.log(member.balance);


// C. 배열[] 기본
console.log("===== C. 배열 기본 =====");
const banks = ["농협", "국민", "신한"];
console.log(banks);             //배열 요소 전부 보기
console.log(banks[0]);          //예측: "농협"  
console.log(banks.length);      //예측: 3
console.log(banks[3]);          //예측: undefined

banks.push("우리");              //끝에 추가
console.log(banks);             //예측: ["농협", "국민", "신한", "우리"]
console.log(banks.length);      //예측: 4

const last = banks.pop();       //끝에서 꺼내기 (꺼낸 값을 반환)
console.log(last);              //예측: "우리"
console.log(banks);             //*** 예측: ["농협", "국민", "신한", "우리"] | 땡... 왜? 값 누적 아냐...?

const mixed = [1, "둘", true, {no: 4}];     //여러 타입을 하나의 배열에 넣기
console.log(mixed[3].no);                   //예측: 4


// D. 배열 반복
console.log("===== D. 배열 반복 =====");
for (let i = 0; i < banks.length; i++) {
    //** console.log( , ); // 콤마로 여러 값을 넘기면, 공백으로 이어서 출력된다.
    console.log(i, banks[i]);   //예측: 0 농협 (줄바꿈) 1 국민 ... (3-4줄 아직 banks가 왜 3개로 줄었는지 이해 못해서.)
}
for (const bank of banks) {
    console.log(bank);          //예측: 농협 (줄바꿈) 국민 ...
}


// E. 객체 배열 = SQL 조회 결과
console.log("===== E. 객체 배열 =====");
const accountList = [
    {accountNo: "100-01", name: "김서현", balance: 50000},
    {accountNo: "100-02", name: "송미심", balance: 1200000000},
    {accountNo: "100-03", name: "신동국", balance: 0}
];
console.log(accountList.length);            //예측: 3
console.log(accountList[1].name);           //예측: "송미심"
console.log(accountList[2]["balance"]);     //예측: 0

for (const row of accountList) {
    if (row.balance == 0) {
        console.log(`잔액 없음: ${row.name}님`) //예측: 잔액 없음: 신동국님
    }
}

// F. 메서드와 this
console.log("===== F. 메서드와 this =====");
const account = {
    owner: "김서현",
    balance: 50000,
    deposit: function(amount) {     //일반 함수 메서드 (함수 선언식?)
        this.balance = this.balance + amount;
        return this.balance;
    },
    showArrow: () => {      //화살표 함수 메서드. 잉? 처음봐. showArrow = () => {} 이거 아냐? 왜 :가 있지?
        return this.owner;      //this가 account를 가리킬까? 
    }
};

console.log(account.deposit(10000));    //예측: 60000
console.log(account.balance);           //예측: 60000 (원본도 바꼈을 거 같은뎅)
console.log(account.showArrow());       //예측: 김서현 (아마도 틀렸겠지) | 땡 => undefined. 그럼 화살표 함수의 this는 누구를 가리키는거지?
console.log(typeof account.deposit);    //function

// G. 참조 복사와 최다 에러
console.log("===== G. 참조와 에러 =====");
const origin = { status: "정상" };
const copy = origin;
copy.status = "해지"
console.log(copy.status);       //예측: 해지
console.log(origin.status);     //예측: 해지 | 이유: 복사가 아니라, 같은 값/주소를 참조해서

const list = [{ name: "홍길동" }];
console.log(list[5]);       //예측: undeifined 
try {
    console.log(list[5].name);
} catch (e) {
    console.log(`에러: `, e.message);       //예측: Cannot read properties undefined (reading 'name')
}