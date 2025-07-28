package arrayType;

public class ArraySystemcopy {

	public static void main(String[] args) {
		// System.arrayCopy(원본, 시작인덱스, 대상, 시작인덱스, 복사할 개수)
		int[] a = {1,2,3,4};
		int[] b = new int[a.length];
		//System.arraycopy(a, 0, b, 1, 3);
		System.arraycopy(a, 0, b, 1, a.length); // b 배열 크기가 4인데 1번 인덱스부터 4개를 붙여 넣어라 => 배열 크기 초과 -> 오류
		// 목적지 배열의 크기(idx값) 확인을 잘 해야함 (out of bounds)
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}

}
