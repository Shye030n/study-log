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

        //String 메서드() 실습
        System.out.println("===== .substring() =====");
        String fullName = "김서현입니다";
        String sub1 = fullName.substring(0,3);
        System.out.println(sub1);

        String sub2 = fullName.substring(4);
        System.out.println(sub2);
        System.out.println("sub3 : " + fullName.substring(3));

        System.out.println("===== .split() =====");
        String csv = "사과,바나나,포도";

        String[] furits = csv.split(",");
        System.out.println("split로 생성한 배열 총 길이" + furits.length);
        for (String fruit : furits) {
            System.out.println(fruit);
        }


        System.out.println("===== .trim() =====");
        String withSpace = "  안 녕 하 세    요 ";
        System.out.println("trim 후 : [" + withSpace.trim() + "]");
        System.out.println("trim 전 : [" + withSpace + "]");
        
        System.out.println("----- 전체 공백을 없애려면 ----- replace 사용! ");
        System.out.println("===== .replace() =====");
        String noSpaceAll = withSpace.replace(" ", "");
        System.out.println("replace로 문자열 전체 공백 제거: [" + noSpaceAll + "]");
        System.out.println("존댓말 변경 : [" + noSpaceAll.replace("세요", "십니까") +"]");
        
        System.out.println("===== .equals() vs ==    =====");
        String a = new String("hello");
        String b = new String("hello");
        String c = "hello";
        String d = "hello";

        System.out.println("a == b : " + (a == b));     //false
        System.out.println("a.equals(b): " + a.equals(b));     //true

        System.out.println("c == d : " + (c == d));      //false

        //연습 문제 
        System.out.println("===== 연습 문제 1) 이름에서 성/이름 분리하기 =====");
        String myName = "김서현";

        String firstName = myName.substring(0,1);
        String lastName = myName.substring(1);

        System.out.println("성 : " + firstName);
        System.out.println("이름 : " + lastName);


        System.out.println("===== 연습 문제 2) 회문 판별 =====");
        //회문(palindrome) 이란, 앞으로 뒤로 읽어도 똑같은 문자열 - ex)level, 기러기 ...
        String word = "level";
        boolean isPalindrome = true;

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(word + "는 회문인가? " + isPalindrome);

        
        //일단 작성해. 아 배고파 샤갈
        
        
        


    }
}
