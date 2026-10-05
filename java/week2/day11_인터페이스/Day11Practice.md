## 동적 바인딩 Dynamic Binding
- '변수 타입'과 '실제 객체 타입'은 다를 수 있고, 메서드를 호출하면 실제 객체가 가진 버전이 실행된다.
- 클래스 상속 (extends)에서만 적용되는 게 아니라, 인터페이스(implements)에서도 적용된다.

### 10, 11 
상속, protected, super, @Override, 동적바인딩
- 동적(dynamic) 바인딩 vs 정적(static) 바인딩
인터페이스, implements, 
```
Member m1 = new VipMember("서현", 26, "shyeo_on@naver.com", 0,2);
m1.name

Discountable d = new VipMember("서현", 26, "shyeo_on@naver.com", 0.3);
```