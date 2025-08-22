package alg.a_ot;

public class Run {

    public static void main(String[] args) {
        // a에 담긴 값을 b에, b에 담긴 값을 a에 넣어주세요.
        // 단 대입연산자만 사용
        // 값을 직접 변수에 할당할 수는 없음.

        int a = 10;
        int b = 15;

        int num = a;
        a = b;
        b = num;

//        a = a ^ b;
//        b = a ^ b;
//        a = b ^ a;
//        (a ^ b) ^ b = a;
//        (a ^ b) ^ a = b;
//        a xor 0 은 언제나 a
//        a xor 1 은 언제나 not a

        System.out.println(a + " " + b);

    }


}
