package coderust.dynamicprog;
/**
 * Given an array, find the contiguous subarray with the largest sum.
 * Kadane's algorithm: https://en.wikipedia.org/wiki/Maximum_subarray_problem 
 *
 */
public class LargestSumSubArray {

	public long largestSumSubArray(int[] arr) {
		long max_so_far = arr[0];
		long max_ending_here = arr[0];
		int start = 0, end = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[i]+ max_ending_here) {
				start = i;
			}
			max_ending_here = Math.max(arr[i], arr[i] + max_ending_here);
			if(max_so_far < max_ending_here) {
				end = i;
			}
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		System.out.printf("start=%d, end=%d\n", start, end);
		return max_so_far;
	}

	public static void main(String[] args) {
		// int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] arr = { 1, 2, 3, 4, 5};
		// int[] arr = { -2, 1, -3, 4};
		long largestSum = new LargestSumSubArray().largestSumSubArray(arr);
		System.out.println(largestSum);
	}
}