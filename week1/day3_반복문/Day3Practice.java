public class Day3Practice {
    public static void main(String[] args) {
        System.out.println("===== for 문 기본 =====");
        // for(초기값; 조건식; 증감식)
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }
        /*
        i = 0 인 이유,
        Array(배열), ArrayList(리스트) 같은 자료구조는,
        인덱스가 0부터 시작하기에,
        배열의 모든 요소를 순회하는 코드를 짤 때는,
        for (int i = 0; i < 배열.length(); i++) 가 자연스러움
        */ 

        System.out.println("===== while 문 기본 =====");
        int j = 0; //초기값
        while (j < 5) { //조건식
            System.out.println("j = " + j);
            j++; //증감식
            /*
            증감식이 빠지면 무한 루프가 콘솔에서 무한 루프가 발생하는데,
            이때 Ctrl + C 를 누르면 무한루프에서 빠져나올 수 있다.
            Ctrl + C : 터미널에서 지금 실행 중인 프로그램을 강제 중단하는 단축키
            (터미널 자체 단축키이기에, 어느 tool에서 사용하던 똑같음)
            */
        }

        System.out.println("===== 연습문제 1) 1~100 합 구하기 =====");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i; //자꾸 i를 1로 쓰는 실수를 하네.
        }
        /*
        i = 0 인 경우, (하지만, 1부터 100까지 라는 문제 그대로 옮겼을 때, 실수도 줄고 코드 읽기도 쉽다.) 
        for (int i = 0; i < 100; i++) {
            sum += i + 1;   //sum = sum + 1; 과 동일
        }
        */
        System.out.println("1 ~ 100까지 합은 " + sum);

        System.out.println("===== 연습 문제 2) 구구단 =====");
        for (int dan = 1; dan <= 9; dan++){
            System.out.println("[ " + dan + " 단 ]");
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + " x " + i + " = " + dan * i);
            }
            
        }

        System.out.println("===== 연습 문제 3-1) 정삼각형 별 찍기 =====");
        for (int a = 1; a <= 5; a++) {
            for (int b = 1; b <= a; b++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("===== 연습 문제 3-2) 역삼각형 =====");
        for (int a = 5; a >= 1; a--) {
            for (int b = 1; b <= a; b++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("===== break 실습 =====");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;  //반복문 자체를 아예 빠져나감.
            }
            System.out.println("i = " + i);
        }

        System.out.println("===== countinue 실습 =====");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;   //건너뛸 대상. 
            }
            System.out.println("i = " + i);
        }
        // continue를 만나면 continue 밑에 코드는 실행하지 않고, 다음 반복으로 넘어간다.

        /*
        for 문 = 변수가 어떤 목표 지점에 도달할 때까지 반복한다. 
        조건이 거짓이 되는 순간 반복을 멈춘다.
        조건이 참인 경우에만 반복한다.
        for (초기값; 조건식; 증감식)
        for (어디부터; 어디까지; 얼마씩)
        for (5에서; 1까지 -1씩)
        for (int a = 5; a >= 1; a--)
        증가하면서 반복하고 싶을 때 <= || < 랑 ++ : 변수가 비교값보다 작을 때까지 증가시킨다
        감소하면서 반복하고 싶을 때 >= || > 랑 -- : 변수가 비교값보다 커질 때까지 감소시킨다.
        */


        System.out.println("===== 테스트 1 =====");
        for (int a = 10; a >= 1; a--) {
            System.out.print("* ");
            for (int b = 1; b < 10; b++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("===== 테스트 2 =====");
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 5; b++) {
                System.out.print(" ");
            }
            for (int c = 0; c < a; c++) {
                System.out.print("*");

            }
            System.out.println();
        }

  

    }
}