public class Day8Practice {
    public static void main(String[] args) { //프로그램의 실행점
        Member m1 = new Member("김서현", 26, "shyeo_on@naver.com"); // 1 (여기서 생성자 호출) //3. 완성된 객체를 m1 변수에 담음
        m1.printInfo(); 
        /*
        m1 은,
        - 본인 고유의 필드 값과
        - Member 클래스에 정의된 메서드를 실행할 자격을
        가지고 있는 '객체/인스턴스' 이다.
        */

    }   
} //Day8Practice는 여기까지.
    
class Member {
    String name;
    int age;
    String email;

    public Member(String name, int age, String email) { //2 (파라미터로 받은 값을 클래스 필드에 복사해서 저장)
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void printInfo() { //객체 생성 시 복사 X, 모든 객체가 공유.
        System.out.println("이름: " + name + " | 나이: " + age + " | 이메일: " + email);
    }
    
}

