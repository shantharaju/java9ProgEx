package coderust.array;

import java.util.Arrays;

public class MoveZerosToLeft {

	private void moveZerosToLeft(int[] arr) {
		int i = arr.length - 1;
		int count = arr.length - 1;
		while (i >= 0) {
			if (arr[i] != 0) {
				arr[count] = arr[i];
				count--;
			}
			i--;
		}
		for (i = count; i >= 0; i--) {
			arr[i] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZerosToLeft mv = new MoveZerosToLeft();
		int[] arr = { 0, 1, 2, 3, 0, 4, 0, 6, 0, 8, 9, 0 };
		mv.moveZerosToLeft(arr);
		System.out.println(Arrays.toString(arr));
	}

}
