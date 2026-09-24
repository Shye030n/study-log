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