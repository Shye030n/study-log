public class Day6Practice {
    public static void main(String[] args) {
        /*
        1) 숫자 뒤집기
        - 문제 : 정수 하나를 받아서, 자릿수를 거꾸로 뒤집은 값 출력하기
        - ex) 12345 -> 54321
        - Hint 
            1. / % 연산
            2. 뽑아낸 자릿수를 순서대로 이어 붙여서 새로운 숫자를 만들어야 한다.
                ( reversed = reversed * 10 + 뽑아낸숫자)
        */
        System.out.println("===== 1) 숫자 뒤집기 =====");
        int number = 12345;

        int i = 0;
        // int quotient = number / 10;       //몫 1234
        // System.out.println("- 반복 전 몫 : " + quotient);
        // int remainder = number % 10;      //나머지 5
        // System.out.println("- 반복 전 나머지 : " + remainder);

        while (number / 10 > 0) {
            int quotient = number / 10;       //1234   4 어디감? 
            System.out.println("- 몫) quotient : " + quotient);
            int remainder = quotient % 10;     //4
            System.out.println("- 나머지)remainder : " + remainder);
            i++;

            //현 상황 무한 루프
            
            // 방법 1. 문자열로 변환하여 이어붙이기
            // 방법 2. int 로 반환하여, 5*10000 + 4*1000 + 3*100 + 2*10 + 1*1

        }

        // 한글로 먼저 쓰고, 그걸 코드를 작성해보자.
        /* 
        연산을 이어갈 몫 변수 = quotient
        뒤집은 숫자를 저장해갈 변수 = remainder 
        나 자꾸 언제까지(조건식)을 못작성하는 거 같은데
        ---
        (입력된 변수를 10으로 나누어, 나머지는 출력하기 위해 변수에 저장하고, 몫은 다음 연산을 위해 변수에 저장한다.) 이게 반복문
        연산변수 / 10 == 0 이면, 그때는 다르게, 해야되네.
        입력 변수를,
        / 연산으로 몫을 저장해서, 연산을 위한 변수로 저장해서 연산을 이어가고
        % 연산으로 나머지를 저장해서, 출력하기 위해 변수로 저장한다.
        나 뭔가 알거같아
        */

        

    }
}