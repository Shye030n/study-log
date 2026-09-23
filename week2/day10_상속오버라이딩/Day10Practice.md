## new 객체생성
```
변수타입 변수명 = new 객체생성자의타입(...);
```


## extends
- 기존 클래스의 필드와 메서드를, 새로운 클래스에서 재사용하기 위해 상속한다.
- 큰 틀은 같은데, 일부만 다른 여러 종류의 데이터를 다룰 때 상속을 사용한다.(ex: 일반사용자/관리자, 일반게시글/공지글)
- 공통 로직은 부모 클래스에 한 번만 작성하여 코드의 중복을 줄여 가독성을 높인다.

- 자식 클래스가 부모 클래스의 필드를 상속받으려면, 필드는 protected로 해야 한다
    - protected : 상속받은 자식클래스라면 패키지/클래스 상관없이 사용 가능
    - private : 현재 클래스 내에서만 사용 가능
- super는 부모 클래스를 가리킨다. (주로 생성자에서 부모 필드를 초기화할 때 사용한다.) <-> this(자기자신)
```
public VipMember(String name, int age, String email, double discountRate) {    
    super(name, age, email);
    this.discountRate = discountRate;
}
```
   

## @Override
- 부모 클래스의 메서드를 재사용할 때 사용한다.
- 부모 메서드를 재사용할 때, 컴파일 시 오타/실수를 찾아준다.
- 비슷한 이름으로, Overload는 같은 메서드명으로 "파라미터의 타입과 개수"가 다른 경우에 사용한다.
- 부모 자식 클래스간 메서드명은 같으나, 로직(동작)이 다른 것을 => 다형성(polymorphism) 이라고 한다. (형태가 다양하다: 폴리몰피즘)



## 터미널 && 
터미널에서 
javac Day10Practice.java && java Day10Practice 
= 앞의 명령을 실행 성공하면 다음 명령도 실행해라.