package oopException.sec05;

public class Throws {

    public static void main(String[] args) {
        // 메서드에서 호출한 곳으로 예외 떠넘기기(Throws 구문)
        // findClass(); // 메서드에 throws 구문이 있는 경우 try ~ catch 구문을 반드시 사용 해야 함(단독 호출 에러 발생)
        try{
           findClass();
        }catch(ClassNotFoundException e){
            System.out.println("메서드에서 throws로 떠넘긴 예외는 메서드 호출 시 반드시 처리해야 함");
        }
    }

    public static void findClass() throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.String2");
    }
}
