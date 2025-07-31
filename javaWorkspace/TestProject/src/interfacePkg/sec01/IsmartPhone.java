package interfacePkg.sec01;

public interface IsmartPhone {
	//샹성자가 없는 interface이므로 선언할 때 초기화 해야 함 : 상수
	// 상수필드
	String name = "smartphone"; // inerface 내에 있는 필드므로 무조건 상수처리 됨 (컴파일될 때 자동으로 public static final)
	// 구현되는 클래스의 메소드 설계도 역할
	
	// 추상메서드 : body가 구현되지 않는 메서드{} 없음
	// 객체가 갖고 있을 메서드를 설명하는 부분 (접근제한, 반환타입, 메서드명, 매개변수)
	public void sendCall();
	public void receiveCall();
	public void sendSMS();
	public void receiveSMS();
	
}
