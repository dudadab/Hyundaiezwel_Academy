package genericCollection.sec05;

public class Util {
    // 두개의 Pair 객체가 동일 객체인지 확인하는 메서드 : 제네릭 타입 메서드
    public static <K, V> boolean compare(Pair<K,V> p1, Pair<K,V> p2){ // 매개변수가 Pair 객체 2개가 전달됨
        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valueCompare = p1.getValue().equals(p2.getValue());
        return keyCompare && valueCompare;
    }
}
