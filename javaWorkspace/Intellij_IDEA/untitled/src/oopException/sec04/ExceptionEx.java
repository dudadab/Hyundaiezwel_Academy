package oopException.sec04;
import java.security.cert.Extension;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("나눗셈 계산기");
        int num1 = 0, num2 = 0;
        double result = 0;
        try {
            System.out.print("정수1 입력 : ");
            num1 = scan.nextInt();
            System.out.print("정수2 입력 : ");
            num2 = scan.nextInt();
            result = num1/num2;
            System.out.println("나누기 결과 : " + result);
        }catch(InputMismatchException  e){
            System.out.println("정수가 아닙니다.");
        }catch(ArithmeticException e){
            System.out.println(num2 + "으로 나눌 수 없습니다.");
        }catch(Exception e){
            System.out.println("오류 발생");
        }
    }
}
