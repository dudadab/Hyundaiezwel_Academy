package oopApi;

public class StringAPI {

    public static void main(String[] args) {
        String ssn = "010624-1230123";
        char sex = ssn.charAt(7);

        switch(sex){
            case '1','3'-> System.out.println("남자");
            case '2','4'-> System.out.println("여자");
        }
        String title = "자바 프로그래밍";
        System.out.println(title.indexOf("프로그래밍")); // 인덱스 위치 3부터 시작
        System.out.println(title.indexOf("java"));  // -1반환 : 해당 문자열은 존재하지 않음
        System.out.println(title.replace("자바","java")); // 문자열 찾아 대체 문자열로 변경된 새로운 문자열 반환
        System.out.println(title.substring(3)); // 3번 인덱스부터 끝까지 추출
        System.out.println(title.substring(3,5)); // 3번 인덱스부터 끝까지 추출
        System.out.println(String.valueOf(true)); // 문자열 true로 반환
        System.out.println(title.split(" ")); // 주어진 문자를 기준으로 문자열을 분리하고 배열로 반환

        String str = "홍길동&이몽룡,성춘향-고길동";
        String[] names = str.split("&|,|-");
        System.out.println(names[2]);
    }
}
