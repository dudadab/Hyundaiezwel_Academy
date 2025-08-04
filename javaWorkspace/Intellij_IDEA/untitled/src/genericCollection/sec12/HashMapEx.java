package genericCollection.sec12;

import java.util.*;
import java.util.Map.Entry;

public class HashMapEx {

    public static void main(String[] args) {
        // HashMap 사용 예제
        // HashMap : key의 중복 불가능, value는 중복 가능
        // (key, value) : 타입의 데이터를 다루기 위한 콜렉션
        // key를 통해서 data를 구분함 : key의 중복을 허용하지 않기 때문에 중복을 체크할 수 있는 String 타입을 주로 key 사용

        // 아래 map을 통해 학생 이름별 점수를 map collection에 저장
        Map<String,Integer> map = new HashMap<String, Integer>();

        // 저장 : put(key, value)
        map.put("홍길동",90);
        map.put("이몽룡",80);
        map.put("성춘향",85);
        map.put("홍길동",95); // key 중복, 새로 추가되지 않음, value만 update

        System.out.println("총 객체 수 : " + map.size());

        // key에 해당되는 value 반환 : get(key)
        System.out.println(map.get("홍길동"));

        // 전체객체 순회 1
        // map은 순서를 보장하지 않음 - 출력되는 결과는 다를 수 있다
        System.out.println("-------------------------------------");
        for(String k : map.keySet()){
            System.out.println(k + ":" + map.get(k));
        }

        // keySet 변수 저장
        Set<String> keyset = map.keySet(); // 반환하는 타입 Set : 타입을 구체화 현재 key는 String 이므로

        // 전체 객체 순회 2 : forEach의 콜백함수에 key, value 인수로 전달함
        System.out.println("-------------------------------------");
        map.forEach((key, value) ->{
            System.out.println(key + ":" + value);
        });

        // 전체 객체 순회 3 : entrySet() 메서드 활용 -> key=value entry를 Set 타입으로 반환 메서드
        System.out.println("-------------------------------------");
        for(Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-------------------------------------");
        System.out.println(map.entrySet());
    }
}
