package oopException.sec03;

public class CatchOrderEx {

    public static void main(String[] args) {
        // 다중 catch 구문 있을 시 catch 순서
        // 모든 예외처리 클래스는 Exception 클래스를 상속받아서 구현되어 있음
        // 상위 클래스인 Exception은 모든 예외 처리
        try{
            String data = "a3";
            int arr[] = {1,2,3};
            int var2 = arr[5];
            int var1 = Integer.parseInt(data);
            System.out.println(var1+10);
        }catch(Exception e){ // 모든 예외 처리하는 catch 구문 이므로 아래 표현된 catch는 필요 없음 - 문법 오류
            // 특정 오류 외의 모든 오류 처리하게 하려고 하면 현재 catch 구문은 순서를 가장 아래로 내려야 함
            System.out.println("오류발생: 상위 클래스");
//        }catch(NumberFormatException e){
//            System.out.println("오류발생 : 변환오류");
        }finally{

        }
    }
}
