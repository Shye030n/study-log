## javac
- javac 은 클래스 단위로 컴파일(실행 가능한 형태)하기 때문에,
- javac Day8Practice.java
- Day8Practice.class 와 Member.class
- 2개의 클래스 파일이 생성된다.

## m1 은,
1. 본인 고유의 필드값과
2. Member 클래스에 정의된 메서드를 실행할 자격을
가지고 있는 인스턴스/객체 이다.

## 동작 흐름
1. main 메서드가 실행 시작점 (프로그램의 진입점)
2. new Member(...)를 만나면 -> 생성자 호출
3. 생성자 안에서 매개변수 값을 필드에 복사해서 저장 (this.필드 = 매개변수)
4. 완성된 객체가 m1 변수에담김
5. m1.메서드() 호출 시, m1의 필드값을 사용해서 그 메서드가 실행됨.
```
public class Day8Practice {
    public static void main(String[] args) {    // 1)
        Member m1 = new Member()                // 2)  4)
    }
}

class Member {
    // 필드

    public Member(){ }//생성자                     // 3)
    
    // 메서드
}
```