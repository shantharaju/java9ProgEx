package coderust.dynamicprog;

import java.util.ArrayList;
import java.util.List;

public class MatrixChainMultiplication {
	private int findOptimum(int[] d) {
		return findOptimumRecursive(d, 1, d.length - 1);
	}

	private int findOptimumRecursive(int[] d, int i, int j) {
//		System.out.println("i=" + i + " j=" + j);
		if (i == j) {
			return 0;
		}
		int sum = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int tempSum = findOptimumRecursive(d, i, k) + findOptimumRecursive(d, k + 1, j) + d[i - 1] * d[k] * d[j];
			if (tempSum < sum) {
				sum = tempSum;
			}
		}
		return sum;
	}

	private int findOptimumDP(int[] d) {
		int n = d.length;
		int[][] N = new int[n][n];
		for(int i=0; i<n; i++) {
			N[i][i] = 0;
		}
		List<String> matrixChain = new ArrayList<>();
		for(int i =1; i <= n; i++) {
			matrixChain.add(Integer.toString(i));
		}

		for(int l = 1; l < n; l++) {
			for(int i = 1, j = l+1; i < n && j < n; i++,j++) {
				int sum = Integer.MAX_VALUE;
				for(int k = i; k < j; k++) {
					int tempSum = N[i][k] + N[k+1][j] + d[i-1]*d[k]*d[j];
					if(tempSum < sum) {
						sum = tempSum;
					}	
				}
				N[i][j] = sum;
			}
		}
		return N[1][n-1];
	}
	public static void main(String[] args) {
		MatrixChainMultiplication mcs = new MatrixChainMultiplication();
		// A1=2x3, A2=3x4, A3=4x5, A4=5x6
		// int[] d = { 2, 3, 4, 5};

		// // A1=2x3, A2=3x4, A3=4x5, A4=5x6
		// int[] d = { 2, 3, 4, 5};
		
		int[] d = { 2, 3, 4, 5, 6, 7};
		System.out.println(mcs.findOptimum(d));
		System.out.println(mcs.findOptimumDP(d));
	}
}
