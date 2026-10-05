public class Day10Practice {
    public static void main(String[] args) {
        System.out.println("===== Member =====");
        Member m1 = new Member("김서현", 26, "shyeo_on@naver.com");
        m1.printInfo();     //이름: 김서현 | 나이: 26 | 이메일: shyeo_on@naver.com

        System.out.println("===== VipMember =====");
        VipMember m2 = new VipMember("김철수", 30, "lee@naver.com", 0.1);
        m2.printInfo();     //[VIP] 이름: 김철수 | 나이: 30 | 이메일: lee@naver.com | 할인율: 0.1
        System.out.println(m2.calculateDiscount(1000));

        System.out.println("===== 반환타입이 Member지만, 실제 객체는 Vipmember =====");
        // Member타입의 m3에 = 새로운 VipMember객체를 생성하겠다(값을 넣겠다) 
        // [실제객체는VipMember] => 동적바인딩(dynamic binding), 런타임 다형성 : 어떤 메서드가 실행될지 런타임에 결정됨. (컴파일타임 X)
        Member m3 = new VipMember("김철수", 30, "lee@naver.com", 0.2);
        m3.printInfo();     //[VIP] 이름: 김철수 | 나이: 30 | 이메일: lee@naver.com | 할인율: 0.1


        System.out.println("===== 반환타입이 Member[]이고, 크기가 2인 배열 members 생성 =====");  //day11: interface에서 다룰 내용
        Member[] members = new Member[2];   //1차원배열, 객체 하나 = 값 하나
        members[0] = new Member("일반회원", 20, "a@a.com");
        members[1] = new VipMember("vip회원", 30, "b@b.com", 0.3);
        
        
        for (Member m : members) {
            m.printInfo();      //각자 자기 버전으로 출력
        }
    }
}

class Member {
    protected String name;
    protected int age;
    protected String email;
    

    public Member(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void printInfo() {
        System.out.println("이름: " + name + " | 나이: " + age + " | 이메일: " + email);
    }
}

class VipMember extends Member {
    private double discountRate;

    public VipMember(String name, int age, String email, double discountRate) {
        super(name, age, email);
        this.discountRate = discountRate;
    }

    @Override 
    public void printInfo() {
        System.out.println("[VIP] 이름: " + name + " | 나이: " + age + " | 이메일: " + email + " | 할인율: " + discountRate);
    }

    public double calculateDiscount(int price) {
        return discountRate * price;
    }
}
