# 예외처리

## 예외 Exception
- 프로그램 실행 중 정상적으로 작동할 수 없는 상황
- 문법은 완전히 정상(자바 문법 오류 X)이기에 컴파일도 문제없지만,
- 프로그램이 실제로 돌아가는 런타임에 발생하는 에러
1. 자바가 자동으로 예외 처리
2. 개발자가 직접 예외 객체 생성/발생 (throw)

## 예외 처리를 안하면 ?
- 예외 발생 시 자바는 예외 객체를 하나 생성해서 던진다.(throw)
- -> 이 예외를 받는 코드(catch)가 없으면,
- 프로그램은 즉시 실행을 멈추고 죽는다. 이후 코드는 실행되지 않는다.

- ex) "사용자 입력 값 검증, DB 연결 실패, 파일 없음, 외부 API 응답 실패"처럼 
- 통제할 수 없는 상황이 발생하지만, 
- 예외 처리를 하지 않으면, 하나의 사용자로 인해 서비스 전체가 멈춰버린다. 

## try-catch 로 예외 받기
- try 블럭 안에 예외가 발생할 수 있는 코드를 넣어야만, catch가, 잡을 수 있다.
- 예외가 try 블럭 밖에서 발생하면, catch가 잡지 못하고 프로그램이 죽는다.
- try 블럭 안에서 예외가 발생하면, 자바는 즉시 그 시점에서 try 블럭을 빠져나와 catch 블럭으로 점프. (try블럭 안에서 예외 발생 이후 코드는 실행 X)
- 나중, SpringBoot의 예외 처리 전략 @ExceptionHandler 등의 기초

## throw로 직접 예외 객체 생성하기
throw new로 직접 새로운 예외 객체 생성.
1. throw 발생 시점 (= 지금 여기서 예외가 발생했다 고 선언하는 것.)
2. 에러가 try 안에서 발생했는가
    - Y : catch 블럭으로 점프 + 처리 후 코드 진행
    - N : 프로그램 즉시 종료

## finally {}
- 예외 발생 여부에 관계없이 무조건 실행하는 코드
- 무슨 일이 있어도 꼭 해야하는 작업
- ex: 파일 닫기, DB 연결 끊기 등



# 예외처리 메서드()
예외객체.getMessage()   //에러메세지 문자열을 꺼내오는 메서드

# 생성자 검증 vs 메서드 검증
- 언제 값을 검증해야 하는가에 따라 나뉨
- 생성자 검증 : 객체 생성 도중 검증 -> 실패하면 객체가 만들어지지 않음
- 메서드 검증 : 객체 생성 이후 

## 방법 1) "생성자 검증" 생성자에서 에러 객체 발생시키기 throw
- 생성자에서 객체가 생성되는 도중에 예외 처리를 하기 때문에, 잘못된 객체가 생성되지 않음.
- 처음부터 설계를 잘못된 값으로 객체를 생성하지 않도록 생성자 초기화할 때 예외처리를 하는 것이 안전한 설계.
```
main {
    try {
        Member m = new Member(-1); //객체 생성 -> 생성자 
                                  //에러 발생. -> catch 블럭으로 즉시 이동
    } catch (IllegalArgumentException e) {
        sysout("잘못된 인자값: " + e.getMessage());    //에러 처리
    }
    sysout("프로그램 정상 작동");
} 

Member {
    int age;

    public Member(int age) {
        //파라미터를 필드에 넣을 때 값 확인해서 잘못된 값인 경우 
            if (age < 0) {
            throw new IllegalArgumentException("나이는 음수일 수 없음."); //예외 객체로 throw (무슨 에러 발생했는지. 예외 상세 메세지 남기기)
            } this.age = age;   //어차피 throw 발생하면, throw 이후 코드 실행 X
    }
}
```

## 방법 2) "메서드 검증" 메서드로 에러 객체 발생시키기 throw
- 이미 만들어진 객체를 나중에 바꾸려는 상황 (ex: setter)이라면 메서드 검증이 좋음.
- try는 트랜잭션이 아니다. "예외가 나면 catch로 점프하는 규칙"일 뿐이라,
  예외가 나기 직전까지 실행된 결과(객체 생성 등)는 되돌려지지 않는다.

### 변수 유효범위 주의
- 객체 생성을 try 블럭 안에 넣으면,
- try 안에서 선언한 변수(Member m)는 try 밖(catch 포함)에서 쓸 수 없다.
- 그래서 try 안에서 만든 객체는 catch에서 접근할 방법이 없어지고,
  나중에 자바가 알아서 정리한다(가비지 컬렉션).
- try 밖에서 미리 선언(Member m = null;)하면 catch 이후에도 그 객체를 쓸 수 있다.

```
public void checkAge() {
    if (age < 0) {
       throw new IllegalArgumentException("나이는 음수일 수 없습니다")
    }    
}

main {
    Member m = new Member(-1);
    try {
        m.checkAge();
    } catch (IllegalArgumentException e){
        sysout("에러 발생" + e.getMessage());
    }
}
```
    
### 콘솔로 에러 읽기
Exception in thread "main" 
= main 쓰레드에서 예외가 발생했다.
java.lang.ArrayIndexOutOfBoundsException
= 예외 종류 클래스명
: Index 5 out of bounds for length 3
= 예외 구체 설명 ===> !!!! .getMessage()
at Day13Practice.main(Day13Practice.java:4)
= 예외 발생 위치

* 런타임 예외(Runtime Exception) : 컴파일은 멀쩡히 통과했지만, 실행하다 터진 경우.
=> 컴파일은 성공 (Day13Practice.class 파일이 생성되었기 때문에)
    런타임 실패. (프로그램이 돌아가면서, arr[5]를 실행하려는 순간 문제가 발생한 것임.)
그렇다면, 컴파일일러는 왜 에러를 미리 잡지 못했을까? )
```
int[] arr = new arr[3];
sysout(arr[5]);
```
    : 컴파일러 입장에서는 문법적으로 정상이기에, 즉 배열에 인덱스로 접근하는 문법은 맞으니,
    실제로 배열 크기가 몇인지는 프로그램이 실제로 돌아가봐야 아는 것임. (런타임에)