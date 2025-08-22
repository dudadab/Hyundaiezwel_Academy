package alg.b_star;

import java.util.Scanner;

public class Butterfly {

    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        for(int i=0; i<input+1; i++){
            for(int j=0; j< i; j++){
                System.out.print("*");
            }
            for(int j=0; j<2*(input-i); j++){
                System.out.print(" ");
            }
            for(int j=0; j< i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=input-1; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            for(int j=1; j<=2*(input-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
