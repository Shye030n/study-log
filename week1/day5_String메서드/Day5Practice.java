public class Day5Practice {
    public static void main(String[] args) {
        System.out.println("===== String Immutable(불변성) 확인 =====");
        String name = "shyeo_on";
        name.toUpperCase();
        System.out.println("새로운 변수에 저장 X: " + name);
        String upperName = name.toUpperCase();
        System.out.println("새로운 변수에 저장 O: " + upperName);
        
        


    }
}
