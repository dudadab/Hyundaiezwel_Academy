package genericCollection.sec01;

public class Box {
    // 필드 1개와 getter/setter가 필요한 클래스
    // 어던 타입의 필드인지는 결정하지 않고 모든 타입의 필드를 사용할 수 있도록 클래스 구성
    // 모든 타입을 포함하는 클래스가 object
    private Object object;

    public void set(Object object) {
        this.object = object;
    }

    // 필드에 저장된 값을 반환하는 Getter 메소드
    public Object get() {
        return this.object;
    }
}

