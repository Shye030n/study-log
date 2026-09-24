/*
만들어야 할 것
1. Member를 추상클래스로 바꾸기
class Member → abstract class Member로 변경
필드(name, age, email)는 그대로 유지
생성자도 그대로 유지
기존에 있던 printInfo()를 추상 메서드로 바꾸기 (몸통 없이, public abstract void printInfo();)
2. VipMember가 추상 메서드를 구현하기
VipMember extends Member는 그대로 유지
printInfo()를 반드시 구현해야 함 (안 하면 컴파일 에러 날 거예요 — 한번 일부러 안 하고 에러 메시지도 확인해보면 좋아요)
3. 새로운 자식 클래스 하나 더 추가하기 (연습용)
예를 들어 GeneralMember extends Member 같은 걸 하나 더 만들어서, printInfo()를 VipMember랑 다르게 구현
(이렇게 해야 "왜 추상클래스가 필요한지" — 여러 자식이 각자 다른 방식으로 구현하는 상황 — 를 제대로 체감할 수 있어요)
4. main에서 확인해볼 것
new Member(...)를 시도해보고 컴파일 에러 나는지 확인 (추상클래스는 직접 객체 생성 불가라는 걸 눈으로 확인)
Member 타입 배열이나 변수에 VipMember, GeneralMember를 담아서 동적바인딩도 다시 한번 확인
힌트 하나만 더: 이전에 있던 printInfo()의 일반 로직(이름/나이/이메일 출력)은 이제 어디로 가야 할까요? 추상 메서드는 몸통이 없으니, 그 로직 자체가 사라지는 게 아니라 각 자식 클래스 안으로 들어가야 해요. 아니면 공통 부분만 남기고 싶다면 별도의 일반 메서드(printBasicInfo())로 분리하는 방법도 있어요 — 이건 직접 설계해보시면서 결정해보세요.
*/

public class Day12Practice {
    public static void main(String[] args) {


    }
}

abstract class Member {
    private String name;
    protected int age;
    protected String email;

    public Member(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //기본 메서드 1
    public String getName() {   //이름 반환 메서드
        return name;
    }

    //추상 메서드 1
    public void printInfo(){};
}

class VipMember extends Member {
    double discountRate;    //할인율

    public VipMember(String name, int age, String email, double discountRate) {
        super(name, age, email);
        this.discountRate = discountRate;
    }

    @Override 
    public void printInfo() {
        System.out.println(" | 나이: " + age + " | 이메일: " + email + " | 할인율: " + discountRate);
    }

}

class GeneralMember extends Member {
    int birthYear;

    public GeneralMember(String name, int age, String email, int birthYear) {
        super(name, age, email);
        this.birthYear = birthYear;
    }

    @Override 
    public void printInfo() {
        System.out.println(" | 나이: " + age + " | 이메일: " + email + " | 출생연도: " + birthYear);
    }

}

//이거는 내가 추가해보고 싶어서 추가.
interface Discoutable {

}