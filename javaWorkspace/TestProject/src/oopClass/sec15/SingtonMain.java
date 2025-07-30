package oopClass.sec15;

public class SingtonMain {

	public static void main(String[] args) {
		// 싱글톤 패턴 클래스 사용
		//SingleTon obj1 = new SingleTon(); // 컴파일 에러, 생성자 private로 접근제한 되어 있음
		
		// Singleton 객체가 필요할 경우 메서드 getInstance 활용
		SingleTon obj1 = SingleTon.getInstance();
		SingleTon obj2 = SingleTon.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 Singleton 객체 입니다.");
		}else {
			System.out.println("다른 Singleton 객체 입니다.");
		}
	}
}
