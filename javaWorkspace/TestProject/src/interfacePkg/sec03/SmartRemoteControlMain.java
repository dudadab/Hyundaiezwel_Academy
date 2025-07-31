package interfacePkg.sec03;

public class SmartRemoteControlMain {
    public static void main(String[] args) {

        //2개 인터페이스의 기능 구현한 클래스 통해서 기능 확인
        SmartTelevision stv = new SmartTelevision();
        stv.turnOn();
        stv.setVolume(4);
        stv.search("www.naver.com");

        //inerface 활용
        RemoteControl rc = new SmartTelevision();
        ISearchable se = new SmartTelevision();
        se.search("www.daum.com");
    }
}
