public class Day11Practice {
    public static void main(String[] args) {
        VipMember m1 = new VipMember("qwer", 30, "qwer@qwer.com", 0.5);
        System.out.println(m1.name + " 고객님의 할인율은, " + m1.getDiscountRate());
    
        //동적바인딩은 클래스 상속에서만 적용되는 게 아니라, 인터페이스도 똑같이 적용된다.
        Discountable d = new VipMember("철수", 25, "cs@cs.com", 0.3);
        System.out.println(d.getDiscountRate()); //아무것도 안나올 것 같아.
        //d.printInfo();
    }
}

interface Discountable {
    public double getDiscountRate();
}

class VipMember extends Member implements Discountable {
    double discountRate;

    public VipMember(String name, int age, String email, double discountRate) {
        super(name, age, email);
        this.discountRate = discountRate;
    }

    @Override 
    public double getDiscountRate() {
        return discountRate;
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