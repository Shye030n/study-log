/*
ArrayList에 Member타입의 객체 3개를 넣고, 총 크기를 출력하고, 삭제하여, 인덱스가 변하는 것을 확인하자.
*/

import java.util.ArrayList;

public class Day14Practice {
    public static void main(String[] args) {

        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member("김서현", 26, "a@a.com"));
        list.add(new Member("신동국", 27, "b@b.com"));
        list.add(new Member("송미심", 28, "c@c.com"));

        System.out.println("- 총 크기: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println("인덱스: " + i +" )");
            list.get(i).printInfo();
        }
        
        list.remove(0);

        System.out.println("삭제 후 크기: " + list.size());
        System.out.println("----- 삭제 후 전체 요소 출력 -----");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("인덱스: " + i + " )");
            list.get(i).printInfo();
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
        System.out.println("이름: " + name + ", 나이: " + age + ", 이메일: " + email);
    }
}