package expackage;
import java.util.Scanner;

public class ArrayInputEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[5]; 
		int max = nums[0];
		
		System.out.println("숫자 입력");
		for(int i=0; i<nums.length; i++) {
			System.out.printf("num[%d] : ", i);
			nums[i] = sc.nextInt();
			max = Math.max(max, nums[i]);
		}
		
		System.out.print("입력된 값 : ");
        for(int num : nums) { 
            System.out.print(num + " ");
        }
        
        System.out.println("");
        System.out.println("최대값 : " + max);
		
		sc.close();
	}

}
