public class Day10Practice {
    public static void main(String[] args) {


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
        System.out.println("이름: " + name + " | 나이: " + age + " | 이메일:" + email);
    }
}
