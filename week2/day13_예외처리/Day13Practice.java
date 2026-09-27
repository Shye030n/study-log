public class Day13Practice {
    /*
    연습 문제
    - Member 클래스는 age를 필드로 갖는다.

    방법 1) 생성자에서 음수 체크 후 throw 설계
    방법 2) 메서드 checkAge로 분리
    1, 2 중에 어느 설계가 나을 지 판단해보기

    main에서 예외가 실제로 발생하는 코드를 정확히 try{}로 감싸기
    
    정상인 나이 값과, 비정상인 값 둘 다 테스트해보기.
    */
    public static void main(String[] args) {
        int[] arr = new int[3];

        try{
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("에러 발생!: " + e.getMessage());
        } 
        System.out.println("프로그램 끝!");

        System.out.println("===== throw 나이가 음수면 예외 던지기 ====");
        try {
            Member m = new Member(-1);
        }
         catch (IllegalArgumentException e) {
            System.out.println("잘못된 값: " + e.getMessage());
        } 
        System.out.println("예외 처리 후 코드");
    }   
}

class Member {
    int age;

    public Member(int age) {
        //1. 생성자에서 예외 throw
        if(age < 0) {
            throw new IllegalArgumentException("나이는 음수일 수 없습니다.");
        } else 
            this.age = age;
    }

    //2. 메서드로 예외 throw
    // public void checkAge(int age) {
    //     if (age < 0) {
    //         throw new IllegalArgumentException("음수는 나이 안돼용");
    //     }
    // }
}


