package coderust.misc;

import java.util.Arrays;

/**
 * Given an array a[1...n] and a number sum, find if there exist 3 elements a1,
 * a2, a3 such that a1+a2+a3=sum
 *
 */
public class SumOfThree {
	// sort the array
	// for every element from [1..n-2] find if there exists two elements a[j],
	// a[k] such that a[j]+a[k] = sum - a[i]
	public boolean sumThree(int[] arr, int sum) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			if (sumTwo(arr, i + 1, sum - arr[i])) {
				return true;
			}
		}
		return false;
	}

	// Given a sorted array and start position start, find if there are two
	// elements
	// a[i], a[j] such that a[i] + a[j] == sum
	public boolean sumTwo(int[] arr, int start, int sum) {
		int i = start;
		int j = arr.length - 1;
		while (i < j) {
			int tempSum = arr[i] + arr[j];
			if (tempSum < sum) {
				i++;
			} else if (tempSum > sum) {
				j--;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 8, 10 };
		SumOfThree s = new SumOfThree();
		// System.out.println(s.sumTwo(arr, 0, 7));
		// System.out.println(s.sumTwo(arr, 0, 13));
		//
		System.out.println(s.sumThree(arr, 21));

		int[] arr2 = { 3, 7, 1, 2, 8, 4, 5 };
		System.out.println(s.sumThree(arr2, 20));
		System.out.println(s.sumThree(arr2, 21));
	}
}