package expackage;
import java.util.Random;
import java.util.Arrays;

public class ArrayExer3 {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random rand = new Random();
		
		for(int i=0; i<6; i++) {
			lotto[i] = rand.nextInt(45)+1;
			for(int j = 0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("로또 당첨 번호: " + Arrays.toString(lotto));

	}

}
