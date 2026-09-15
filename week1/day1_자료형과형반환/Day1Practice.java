public class Day1Practice {
    public static void main(String[] args) {
        //실습 문제
        int age = 26;
        double price = 4500.5;
        char grade = 'A';
        boolean isStudent = true;

        System.out.println("나이 : " + age);
        System.out.println("가격 : " + price);

        double ageAsDouble = age;
        int priceAsInt = (int) price;

        System.out.println("ageAsDouble : " + ageAsDouble);
        System.out.println("priceAsInt : " + priceAsInt);

        //연습 문제
        int score = 87;
        String name = "김서현";

        double scoreAsDouble = score;

        System.out.println("이름: " + name + ", 점수 : " + score);

    }
}