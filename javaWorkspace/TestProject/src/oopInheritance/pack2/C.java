package oopInheritance.pack2;

// 패키지가 다른 클래스의 객체 인스턴스 구성 : import 해야 함
import oopInheritance.pack1.B; //public 클래스 
import oopInheritance.pack1.A; // import 불가능(패키지가 다른 default 클래스)

public class C {
	B b; // 패키지가 달라도 import 했고 public 클래스이므로 접근 가능
	A a; // default 클래스이고 패키지가 다르기 때문에 접근 불가
} 
