package coderust.dynamicprog;

public class MaxSubSequenceNonAdjucent {

	public long maxSubseqNonAdj(int[] arr) {
		long max_incl_prev = arr[0];
		long max_excl_prev = 0;
		long max_incl_curr = 0;
		long max_excl_curr = 0;
		for(int i = 1; i < arr.length; i++) {
			max_incl_curr = Math.max(arr[i], arr[i] + max_excl_prev);
			max_excl_curr = Math.max(max_excl_prev, max_incl_prev);

			max_incl_prev = max_incl_curr;
			max_excl_prev = max_excl_curr;
		}
		return Math.max(max_incl_curr, max_excl_curr);
	}
	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// int[] arr = { 1, 2, 3, 4, 5};
		// int[] arr = { -2, 1, -3, 4};
		System.out.println(new MaxSubSequenceNonAdjucent().maxSubseqNonAdj(arr));
	}
}