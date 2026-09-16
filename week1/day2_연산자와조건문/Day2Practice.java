public class Day2Practice {
    public static void main(String[] args) {
        // 실습 문제
        int a = 10;
        int b = 3;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b)); //예상 3
        System.out.println("a % b = " + (a % b)); //예상 1

        double resultDouble = (double) a / b;
        System.out.println("(double) a / b = " + resultDouble);
        //위에걸 변수 없이 쓰고 싶다면,
        System.out.println("(double) a / b == " + (double) a / b );

        System.out.println("정수 나눗셈 : " + a / b );
        System.out.println("실수 나눗셈" + (double) a / b);
        System.out.println("잘못된 방식" + (double)(a / b)); //int(정수)로 먼저 계산한 걸, double(실수)타입으로 변환해서.


        boolean isGreater = a > b;
        System.out.println("a > b = " + isGreater);

        int score = 38;
        if (score >= 90) {
            System.out.println("학점: A");
        } else if (score >= 80) {
            System.out.println("학점: B");
        } else if (score >= 70) {
            System.out.println("학점: C");
        } else if (score >= 60) {
            System.out.println("학점: D");
        } else 
            System.out.println("학점: F");

        //연습 문제 1 : 두 수 비교해서 큰 수 출력
        int x = 15;
        int y = 15;
        if (x > y) {
            System.out.println("x(" + x + ")가 y(" + y + ")보다 큽니다.");
        } else if (x < y) {
            System.out.println("x(" + x + ")가 y(" + y + ")보다 작습니다.");
        }
         else System.out.println ("x 와 y 값이 동일합니다.");

        //연습 문제 2 : 학점 계산기 완성

        // ===== 논리 연산자 실습 =====
        int age = 26;
        boolean isStudent = true;

        boolean canDiscount = isStudent && age < 30; 
        boolean canEnter = age >= 18 || isStudent;
        boolean isNotStudent = !isStudent;

        System.out.println("학생 가능 : " + canDiscount);
        System.out.println("입장 가능 : " + canEnter);
        System.out.println("학생 아님 : " + isNotStudent);


    }
}
