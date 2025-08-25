package alg.g_divideandconcure;

import alg.util.SortUtil;

public class Quiz {
	
	public static void main(String[] args) {
		//cpuCacheHit();
		q1();
		
	}

	private static void q1() {
		// TODO Auto-generated method stub
		
	}

	private static void cpuCacheHit() {
		int size = 10240;
		int[][] dArr = new int[size][size]; 
		
		SortUtil.checkTime(() -> {
			for (int i = 0; i < dArr.length; i++) {
				for (int j = 0; j < dArr.length; j++) {
					dArr[i][j] = i;
				}
			}
		});
	}

}
