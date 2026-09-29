/*
ArrayList에 Member타입의 객체 3개를 넣고, 총 크기를 출력하고, 삭제하여, 인덱스가 변하는 것을 확인하자.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Day14Practice {
    public static void main(String[] args) {
        System.out.println("===== HashMap<K,V> =====");
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("유재석", 1);
        hm.put("유노윤호", 2);
        hm.put("전소민", 3);

        System.out.println("유재석의 value는, " + hm.get("유재석"));
        System.out.println(hm.containsKey("유재석"));   //true
        System.out.println(hm.containsKey("유재"));     //false
        /* containsKey() 는 HashMap 클래스의 메서드임. 그래서, hm.containsKey() */

        hm.put("유재석", 4);    //값 덮어쓰기 확인

        System.out.println("hm 객체 출력: " + hm);     //k,v 전체 출력     //HashMap<K, V> toString()
        System.out.println("----- 출력 -----");
        for (String m : hm.keySet()) {
            System.out.println(m +" : "+hm.get(m));
        }   // 넣은 순서대로 HashMap을 꺼내고 싶다면 => LinkedHashMap<K, V>


        System.out.println("===== ArrayList<> =====");
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member("김서현", 26, "a@a.com"));
        list.add(new Member("신동국", 27, "b@b.com"));
        list.add(new Member("송미심", 28, "c@c.com"));

        System.out.println("- 총 크기: " + list.size());

        System.out.println("* list 객체 출력: " + list);       //참조 주소 출력    //ArrayList toString()

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