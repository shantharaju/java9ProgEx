package hackerrank;
// https://www.hackerrank.com/challenges/non-divisible-subset/problem

public class NonDivSubSet {

	public static int nonDivisibleSubset(int[] arr, int k) {
		int[] remSet = new int[k];
		
		for(int element : arr) {
			remSet[element%k]++;
		}
		int count = 0;
		if(remSet[0] > 0) {
			count++;
		}
		for(int i=1; i<=k/2; i++) {
			if(i != k-i) {
				count += Math.max(remSet[i], remSet[k-i]);
			}
		}
		if(k%2 == 0) {
			if(remSet[k/2] > 0) count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int k = 3;
		int[] arr = {1, 2, 4, 7};
		System.out.println(nonDivisibleSubset(arr, k));
	}

}
