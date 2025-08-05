package oopApi.sec06;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {

    public static void main(String[] args) {
        // 날짜 시간 관련 클래스
        // 날짜 정보를 객체간에 주고 받을 때 주로 사용
        Date now = new Date(); // 객체 생성
        System.out.println(now.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String strNow2 = sdf.format(now); // 문자열 반환
        System.out.println(strNow2);
    }
}
