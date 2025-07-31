package interfacePkg.sec02;

public class RemoteControlMain {

	public static void main(String[] args) {
		// 인터페이스 활용 객체와 통신
		RemoteControl rc = null;
		
		// Television 객체 활용
		rc = new Television();
		rc.turnOn(); // 인터페이스 추상메서드 : 재정의
		rc.turnOff();
		rc.setVolume(5);
		rc.setMute(true); // 디폴트 메서드지만 재정의 되었음 (Television에서 재정의 된 메서드가 호출) - 객체 통해서 호출
		rc.setMute(false);
		
		System.out.print("-----------------------------");
		
		// Audio 객체 활용
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(50);
		rc.setMute(true); // 디폴트 메서드 재정의 하지 않았음 interface의 기본 메서드 호출(객체 통해서 호출)
		
		// 정적 메서드 사용
		RemoteControl.changeBattery(); 
		// rc.showRemote(); 인터페이스의 정적 메서드여도 인터페이스 참조변수를 통해서 접근은 불가
	}

}
