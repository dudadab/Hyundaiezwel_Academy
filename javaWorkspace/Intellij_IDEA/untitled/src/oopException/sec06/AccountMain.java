package oopException.sec06;

public class AccountMain {

    public static void main(String[] args) {
        // 예외를 포함하고 있는 클래스 메서드 사용
        Account account = new Account();
        // 예금하기
        account.deposit(10000);
        System.out.println("예금액 : " + account.getBalance());

        // 출금하기
        try{
        account.widthdraw(30000); // 메서드 구현에 예외를 포함하고 있는 메서드 try ~ catch 진행 없으면 호출 불가능
        }catch(BalanceInsufficientException e){
            String message = e.getMessage(); // 예외 발생시킬때 생성자로 전달된 문자열이 super() 호출되면서 전달됨
            System.out.println(message);
            System.out.println();
            System.out.println("예외 추적 내용 출력");
            e.printStackTrace();
        }
    }
}
