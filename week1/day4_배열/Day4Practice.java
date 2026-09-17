public class Day4Practice {
    public static void main(String[] args) {
        System.out.println("===== 선언/초기화 한 번에 =====");
        int[] scores = {90, 85, 77, 92, 60};
        //    값을 알고 있을 때 편하게
        System.out.println("첫 번째 값: " + scores[0]);
        System.out.println("두 번째 값: " + scores[1]);
        System.out.println("배열 길이/크기: " + scores.length);
        
        System.out.println("===== 선언/초기화 따로 =====");

        
        int[] scores2;
        scores2 = new int[3];
        //    크기는 정해졌지만, 값은 나중에 채워야 할 때, 예: 사용자입력/반복문 으로 채울 때
        System.out.println("첫 번째 값: " + scores2[0]);    //값 넣기 전에는 0
        scores2[0] = 90; 
        scores2[1] = 85; 
        scores2[2] = 77; 
        System.out.println("첫 번째 값: " + scores2[0]);
        System.out.println("두 번째 값: " + scores2[1]);
        System.out.println("배열 길이/크기: " + scores2.length);

        /*
        Array(배열)은, 크기가 고정  <-> ArrayList (가변 크기)
        크기가 정해진 경우              개수가 유동적인 경우 (실무에서 훨씬 흔함)
        */

        System.out.println("===== 연습 문제 1) 배열의 최대값 찾기 =====");
        int[] numbers = {23, 54, 67, 75, 34, 88};

        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("최대값은, " + max);

        System.out.println("===== 연습 문제 2) 배열 최소값 구하기 =====");
        int min = numbers[0];   //for 문에서 초기값을 1로 설정한 이유 !!!! 효율적이고 의도가 명확한 실무 디테일 ~        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("최소값은, " + min);
    }
}
