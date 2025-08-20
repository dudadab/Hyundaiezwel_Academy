package alg.star;

import java.util.Scanner;
public class Diamond {

    public static void main(String[] args) {

        int input = new Scanner(System.in).nextInt();

        for(int i=0; i<input; i++){
            for(int k=0; k<input-i; k++){
                System.out.print(" ");
            }
            for(int j=0; j<=i*2; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=input-1; i>=0; i--){
            for(int k=0; k<input-i; k++){
                System.out.print(" ");
            }
            for(int j=0; j<=i*2; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
