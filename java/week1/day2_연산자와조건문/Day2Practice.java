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


        // ===== 증감 연산자 실습 =====
        int count = 5;
        count++;
        System.out.println("count++ 후 : " + count); //6
        
        count--; //count는 변수이기에, 변수는 매번 초기화되는 것이 아닌, 이전 연산 결과가 계속 이어진다. 누적된다.
        System.out.println("count-- 후 : " + count); //5 
        
        int x2 = 5;
        ++x2;
        System.out.println("++x2 : " + x2); //6
        
        int y2 = 5;
        System.out.println("y2++: " + y2++); //5
        System.out.println("y2 최종값 : " + y2); //6

        // ===== 증감 연산자 연습 및 정리 =====
        System.out.println("===== 증감연산자 정리 =====");
        //전위 연산 : 연산 후, 값 대입
        int q = 10;
        int w = ++q;    //w = 11, ++q = 11
        int z = --w;    //z = 10, --w = 10
        //후위 연산 : 값 대입 후, 연산
        int e = 10;
        int r = e++;    //r = 10 e++ = 11
        int v = r--;    //v = 10, r-- = 9
        System.out.println("w = " + w);
        System.out.println("++q = " + q);
        System.out.println("r = " + r);
        System.out.println("e++ = " + e++);
        System.out.println("e = " + e);
    

        System.out.println("===== switch 실습 =====");
        int month = 8;
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            default : System.out.println("잘못된 월");
        }
        
    }
}
