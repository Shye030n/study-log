public class Day1Practice {
    public static void main(String[] args) {
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
    }
}