package alg.c_math;

public class MathQuiz {

    public static void main(String[] args) {

        System.out.printf("소수입니까? : %s \n", isPrime(11));
        System.out.printf("12, 18의 최대공약수 : %d\n", gcd(12,18));
        System.out.printf("12, 18의 최소공배수 : %d\n", lcm(12,18));
        System.out.printf("5! : %d\n", factorial(5));
        System.out.printf("5! : %d\n", factorialTail(5,1));
    }

    private static boolean isPrime(int num){
        if(num == 2) return true;
        if(num%2 == 0) return false;

        for(int i=3; i<num; i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    // 약수
    // n % m = 0
    // 약수의 특징 : 약수는 곱해서 피제수(나누어지는 수)가 되게끔 하는 쌍이 반드시 존재
    // eX) 16 => 1, 2, 4, 8, 16
    private static boolean isPrime2(int num){
        if(num == 2) return true;
        if(num%2 == 0) return false;

        for(int i=3; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    private static int gcd(int a, int b){
        int min = Math.min(a,b);

        for(int i = min; i>0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // 유클리드 호제법을 이용한 최대공약수 구하기
    // a > b
    // a와 b가 최대공약수 G를 가질 때, a를 b로 나눈 나머지는 G의 배수이다.

    // a = MG
    // b = NG
    // a = bq +r (q:몫, r:나머지)
    // Mg = NGq + r
    // r = MG - NGq
    // r = G(M-Nq)

    // b : NG
    // r : PG
    // b : rq + r2
    // NG = PGq + r2
    // r2 = G(Pq-N)

    private static int gcd2(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수
    // G * (a/G) * (b/G)
    // a * b/G
    private static  int lcm(int a, int b){
        return a * b / gcd(a,b);
    }

    // factorial, 재귀함수
    private static int factorial(int i){
        if(i<0) throw new IllegalArgumentException("음수 팩토리얼은 존재하지 않습니다."); // 예외처리
        if(i<=1) return 1;

        // 5 * factorial(i-1) => 5 * 4 * 3 * 2 * 1
        //      4 * factorial(3) => 4 * 3 * 2 * 1
        //          3 * factorial(2) => 3 * 2 * 1
        //              2 * factorial(1) => 2 * 1
        return i * factorial(i-1);
    }
    // 자바는 꼬리재귀함수가 안됨
    // 꼬리재귀함수 : 반환부에 연산이 없는 재귀함수
    // 컴파일러가 내부적으로 반복문으로 최적화 / 자바 X
    private static int factorialTail(int i, int res) {
        if (i < 0) throw new IllegalArgumentException("음수 팩토리얼은 존재하지 않습니다."); // 예외처리
        if (i <= 1) return res;

        res = i * res;
        return i * factorialTail(--i, res);
    }
}
