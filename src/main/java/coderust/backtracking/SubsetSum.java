package coderust.backtracking;

public class SubsetSum {
	public boolean isSubsetSumDP(int[] arr, int sum) {
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
		return subSum[arr.length - 1][sum];
	}

	private boolean lookup(boolean[][] subsum, int i, int j) {
		if(i < 0 || j < 0) {
			return false;
		}
		return subsum[i][j];
	}
	// Recursive implementation
	public boolean isSubsetSum(int[] arr, int sum) {
		return isSubsetSumRecursive(arr, 0, sum);
	}

	private boolean isSubsetSumRecursive(int[] arr, int i, int sum) {
//		System.out.println("i:" + i + " sum=" + sum);
		if(sum==0) {
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
		return isSubsetSumRecursive(arr, i+1, sum - arr[i]) || isSubsetSumRecursive(arr, i+1, sum);
	}

	public static void main(String[] args) {
		int[] arr = {3, 34, 4, 12, 5, 2};
		int sum = 7;
		SubsetSum ss = new SubsetSum();
		boolean isSum = ss.isSubsetSum(arr, sum);
		System.out.println(isSum);
		System.out.println(ss.isSubsetSumDP(arr, sum));
	}
}
