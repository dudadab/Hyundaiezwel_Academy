package oopInheritance.sec12;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class CastMain {

	public static void main(String[] args) {
		// 강제 타입 변환
		Animal ap = null;
		
		ap = new Dog(); //자동 타입 변환
		ap.show(); // Dog 클래스에서 재정의 해 놓은 메서드가 호출된 상태
		ap.sound();
		
		ap.animalMethod(); // Animal 클래스의 메서드가 호출 - Dog 클래스에서 재정의 하지 않음
		// ap.dogMethod(); // 자식 클래스의 메서드는 사용 불가
		
		// Dog 클래스 참조변수 선언
		// ap는 타입은 animal 임, 참조 객체는 Dog 타입의 객체를 참조 중(자동타입변환)
		// 아래와 같이 대입하면 타입 불일치 에러 발생 -> 단, ap는 Dog 객체를 참조 중 이고 Dog -> Animal로 자동형변화이 적용된 상태
		// 일시적으로 강제형변환 가능
		Dog d = (Dog)ap;
		d.dogMethod();
		
		// instansof : 객체가 참조하고 있는 인스턴스의 타입 검사를 진행하는 연산자
		// 객체 instansof type -> 참조타입이면 true 반환
		// 부모타입 객체가 모두 자식타입으로 강제 형변환이 가능한 건 아님 -> 자식타입에 근거 한 객체여야 함
		Animal aa = new Animal(); // aa참조 변수는 참조객체의 타입이 Animal임
		//Dog dd = (Dog)aa; // 런타임에 형변환 발생 -> 실행 시에 예외 발생 cannot be cast to class
		if(aa instanceof Dog) {
			Dog dd = (Dog)aa;
			System.out.println("Dot 타입으로 변환 성공");
		}else {
			System.out.println("Dog 타입으로 변환 불가");
		}
	
	}

}
