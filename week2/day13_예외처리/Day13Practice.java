public class Day13Practice {
    public static void main(String[] args) {
        int[] arr = new int[3];

        try{
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("에러 발생!: " + e.getMessage());
        } 

        System.out.println("프로그램 끝!");

        System.out.println("===== throw 나이가 음수면 예외 던지기 ====");
        Member m = new Member(-1);
        try {
            if (m.age < 0) m.checkAge(m.age);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
        System.out.println("끝");
    }   
}

class Member {
    int age;

    public Member(int age) {
        if(age < 0) {
            checkAge(age);
        } else this.age = age;
    }

    public void checkAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("나이는 음수일 수 없습니다");
        }
    }
}


