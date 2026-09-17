public class Day5Practice {
    public static void main(String[] args) {

        System.out.println("===== String Immutable(불변성) 확인 =====");
        String name = "shyeo_on";
        name.toUpperCase();
        System.out.println("새로운 변수에 저장 X: " + name);
        String upperName = name.toUpperCase();
        System.out.println("새로운 변수에 저장 O: " + upperName);
        /*
        그냥 메서드만 사용하고, 새로운 변수에 저장하지 않으면 
        String은 불변성의 특성을 가지기에, 아무 일도 일어나지 않는다.
        String 타입의 문자열을 바꾸고 싶을 때는, 
        메서드 사용 시 꼭 새로운 변수에 값을 넣어줘야 한다.
        */
        
        


    }
}
