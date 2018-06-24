package coderust.array;

import java.util.Arrays;

public class RotateArray {
	public void rotateArray(int[] arr, int d) {
		int gcd = findGCD(arr.length, d);
		for(int i=0; i<gcd; i++) {
			int j=i;
			int k;
			int temp = arr[i];
			while(true) {
				k = (j+d) % arr.length;
				if(k == i) break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	private int findGCD(int a, int b) {
		if ((a <= 1) || (b <= 1) || (a == b)) {
			return Math.min(a, b);
		}
		if (a > b) {
			return findGCD(a - b, b);
		} else {
			return findGCD(a, b - a);
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		new RotateArray().rotateArray(arr1, 3);
		System.out.println(Arrays.toString(arr1));
	}
}
