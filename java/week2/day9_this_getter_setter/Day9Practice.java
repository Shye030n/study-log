public class Day9Practice {
    public static void main(String[] args) {
        Member m1 = new Member("김서현", 26, "shyeo_on@naver.com");
        System.out.println("이름 조회: " + m1.getName());
        
        m1.setName("서현이");
        System.out.println("이름 변경 후: " + m1.getName());

        m1.printThis();

        Member m2 = new Member("신동국", 11, "qwer@naver.com");
        m2.printThis();
    }
}

class Member{
    private String name;
    private int age;
    private String email;

    public Member(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //getter
    public String getName() {
        return name;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    //this 객체 확인
    public void printThis() {
        System.out.println(this);   //서로 다른 주소를 확인
        System.out.println("this로 접근한 이름: " + this.name);
    }
}