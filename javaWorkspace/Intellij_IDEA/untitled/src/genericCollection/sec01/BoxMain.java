package genericCollection.sec01;

public class BoxMain {

    public static void main(String[] args) {
        // Box 클래스 활용 : Object 타입 활용 사용할 때 형변환 발생(강제타입 변환 발생) ->
        Box box = new Box();
        box.set("홍길동"); // set method의 매개변수 타입 Object 인수는 String : 자동타입변환 String -> Object
        // box 클래스의 object 필드는 object 타입이고 문자열이 저장되어 있느 ㄴ상태
        String name = (String)box.get(); // get 진행하면 반환되는 data가 object 타입 -> String에 대입할 수 없음(강제 형변환)
        System.out.println(name);

        Box box2 = new Box();
        box2.set(7); // 기본타입 integer -> object 자동형변환
        int no = (Integer)box2.get(); // Object 타입을 int 타입에 저장 불가(타입불일치 오류) - 강제 형변환
        // box2.get() 반환값이 Object 타입이지만 그전에 int 에서 변환된 Object 여야 함
        System.out.println(no);
    }
}
