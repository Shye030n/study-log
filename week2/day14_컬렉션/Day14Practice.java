import java.util.ArrayList;

public class Day14Practice {
    public static void main(String[] args) {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member("김서현", 26, "a@a.com"));
        list.add(new Member("김철수", 27, "b@b.com"));
        list.add(new Member("김영희", 28, "c@c.com"));

        System.out.println("동적 배열 총 크기 = " + list.size());
        list.get(0).printInfo();    //Member 클래스의 printInfo() 로 요소 출력
        list.get(1).printInfo();

        System.out.println("===== 요소 전부 꺼내기 =====");     //for-each로 요소 전부 출력
        int index = 0;
        for (Member m : list) {
            System.out.print("[" + index + "] => ");
            m.printInfo();
            index++;
        }

        list.remove(0);
        System.out.println("삭제 후 동적 배열 총 크기 = " + list.size());

        System.out.println("===== 요소 전부 꺼내기 =====");     //for-each로 요소 전부 출력
        index = 0;
        for (Member m : list) {
            System.out.print("[" + index + "] => ");
            m.printInfo();
            index++;
        }

    }
    
}

class Member {
    String name;
    int age;
    String email;

    public Member(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void printInfo() {
        System.out.println("이름:  " + name +", 나이:  " + age + ", 이메일: " + email);
    }
}
