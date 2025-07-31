package interfacePkg.sec02;

public class Audio implements RemoteControl {
	// 멤버필드
	private int volume;
	private boolean mute;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다..");
	}
	
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.Max_VOLUME) {
			this.volume = RemoteControl.Max_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		
		System.out.println("현재 Audio 볼륨 : " + this.volume);
	}
}
