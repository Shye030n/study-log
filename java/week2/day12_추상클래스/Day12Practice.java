public class Day12Practice {
    public static void main(String[] args) {
        /* Day12Practice.java:22: error: Member is abstract; cannot be instantiated */
        //Member m = new Member("test", 20, "test@test.com");  //추상클래스는 new로 객체 생성 불가

        System.out.println("===== VipMember 객체 =====");
        VipMember vMember = new VipMember("qwer", 20, "qwer@qwer.com", 0.5);
        System.out.println(vMember.getName());
        vMember.printInfo();
        System.out.println("- 할인처리 된 최종 금액: " + vMember.discountResult(3000));

        System.out.println("===== GeneralMember 객체 =====");
        Member gMember = new GeneralMember("asdf", 99, "asdf@asdf.com", 2001);
        System.out.println(gMember.getName());
        gMember.printInfo();

        /* 동적 바인딩 */
        System.out.println("===== Member 타입의 배열에 객체로 저장 =====");
        Member[] mArray = new Member[2];
        mArray[0] = new VipMember("zxc", 22, "zxc@zxc.com", 0.3);
        mArray[1] = new GeneralMember("fff", 87, "fff@fff.com", 2002);

        for (Member mA: mArray) {
            System.out.println(mA); //객체의 주소로 출력
            System.out.println(mA.getName());
            mA.printInfo(); 
        }

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
    public abstract void printInfo();   //<--- 여기서 실수함!!!! --- 접근제한자 abstract 반환타입 메서드명();
}

class VipMember extends Member implements Discoutable {
    double discountRate;    //할인율
    int price;

    public VipMember(String name, int age, String email, double discountRate) {
        super(name, age, email);
        this.discountRate = discountRate;
    }

    @Override 
    public void printInfo() {
        System.out.println(" | 나이: " + age + " | 이메일: " + email + " | 할인율: " + discountRate);
    }

    @Override 
    public double discountResult(int price) {
        return discountRate * price;
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
    double discountResult(int price);

}