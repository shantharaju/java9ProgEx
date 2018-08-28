package coderust.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PerfectSubsetSum {
	public boolean findSubsetSumDP(int[] arr, int sum) {
		boolean[][] subSum = new boolean[arr.length][sum+1];
		// sum = 0 can be formed by empty set
		for(int i = 0; i < arr.length; i++) {
			subSum[i][0] = true;
		}
		// initial case when subset is only one element
		if(arr[0] <= sum) {
			subSum[0][arr[0]] = true;
		}
		// populate rest of the matrix
		for(int i=1; i < arr.length; i++) {
			for(int j=1; j <= sum; j++) {
				subSum[i][j] = lookup(subSum, i-1, j) || lookup(subSum, i-1, j - arr[i]); 
			}
		}
		for(int i =0; i < arr.length; i++) {
			for(int j = 0; j <= sum; j++) {
				System.out.print(subSum[i][j] ? 1 : 0); System.out.print(",");
			}
			System.out.println();
		}
		if(subSum[arr.length - 1][sum]) {
			
			printSubsetSumDP(arr, subSum, arr.length-1, sum, new ArrayList<Integer>());
		}
		return subSum[arr.length - 1][sum];
	}

	private void printSubsetSumDP(int[] arr, boolean[][] subSum, int i, int sum, List<Integer> list) {
		if(i==0) {
			if(sum == 0) {
				System.out.println(list);
				return;
			}
			if(subSum[i][sum]) {
				List<Integer> incl = new ArrayList<>();
				incl.addAll(list);
				incl.add(arr[i]);
				System.out.println(incl);
				return;
			}
		}
		if (subSum[i][sum]) {
//			System.out.printf("before i=%d, sum=%d\n",i, sum);
			if (subSum[i - 1][sum]) {
				printSubsetSumDP(arr, subSum, i - 1, sum, list);
			}

//			System.out.printf("i=%d, sum=%d\n",i, sum);
			if(((sum - arr[i]) >=0) && subSum[i-1][sum - arr[i]]) {
				List<Integer> incl = new ArrayList<>();
				incl.addAll(list);
				incl.add(arr[i]);
				printSubsetSumDP(arr, subSum, i-1, sum - arr[i], incl);
			}
		}
	}

	private boolean lookup(boolean[][] subsum, int i, int j) {
		if(i < 0 || j < 0) {
			return false;
		}
		return subsum[i][j];
	}
	// Recursive implementation
	public boolean printSubsetSum(int[] arr, int sum) {
		return printSubsetSumRecursive(arr, 0, sum, new ArrayList<Integer>());
	}

	private boolean printSubsetSumRecursive(int[] arr, int i, int sum, ArrayList<Integer> list) {
		if(sum==0) {
			if(!list.isEmpty()) {
				System.out.println(list);
			}
			return true;
		}

		if(i >= arr.length) {
			return false;
		}
		while(i < arr.length && arr[i] > sum) {
			i++;
		}

		if(i >= arr.length) {
			return false;
		}
		ArrayList<Integer> thisElementInc = new ArrayList<Integer>();
		thisElementInc.addAll(list);
		thisElementInc.add(arr[i]);
		boolean inc = printSubsetSumRecursive(arr, i+1, sum - arr[i], thisElementInc);
		boolean excl = printSubsetSumRecursive(arr, i+1, sum, list);
		return  inc || excl;
	}

	public static void main(String[] args) {
		// int[] arr = {3, 34, 4, 12, 5, 2};
		int[] arr = {2, 3, 5, 6, 8, 10};
		int sum = 10;
		PerfectSubsetSum ss = new PerfectSubsetSum();
//		boolean isSum = ss.printSubsetSum(arr, sum);
//		System.out.println(isSum);
		System.out.println(ss.findSubsetSumDP(arr, sum));
	}
}
