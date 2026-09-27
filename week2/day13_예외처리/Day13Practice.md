# 예외처리
예외객체.getMessage()   //에러메세지 문자열을 꺼내오는 메서드

### 예외 처리는 왜 할까?
: 문제는 문제대로 처리하고, 프로그램은 계속 살아있게

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