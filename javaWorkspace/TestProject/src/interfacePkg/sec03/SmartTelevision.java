package interfacePkg.sec03;

public class SmartTelevision implements RemoteControl, ISearchable {

    private int volume; //인스턴스 멤버필드

    @Override
    public void search(String url) {
        System.out.println("인터넷에서 " + url + "을(를) 검색합니다.");
    }
    @Override
    public void turnOn() {
        System.out.println("SmartTelevision을 켭니다.");
    }
    @Override
    public void turnOff() {
        System.out.println("SmartTelevision을 끕니다.");
    }
    @Override
    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if (volume < RemoteControl.MIN_VOLUME) {
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 Television 볼륨 : " + this.volume);
    }
}
