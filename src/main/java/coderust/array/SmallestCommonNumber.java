package coderust.array;

public class SmallestCommonNumber {

	public int findSmallestCommon(int[] arr1, int[] arr2, int[] arr3) {
		int i = 0, j=0, k=0;
		while(i < arr1.length && j < arr2.length && k < arr3.length) {
			if((arr1[i] == arr2[j]) && (arr2[j] == arr3[k])) {
				return arr1[i];
			}
			int max = findMax(arr1[i], arr2[j], arr3[k]);
			while((i < arr1.length) && (arr1[i] < max) ) {
				++i;
			}
			while((j < arr2.length) && (arr2[j] < max)) {
				++j;
			}
			while((k < arr3.length) && (arr3[k] < max)) {
				++k;
			}
		}
		return -1;
	}
	private int findMax(int i, int j, int k) {
		return Math.max(Math.max(i, j), k);
	}

//	public static void main(String[] args) {
//		int[] arr1 = { 1, 5, 10, 20, 40, 80 };
//		int[] arr2 = { 6, 7, 20, 80, 100 };
//		int[] arr3 = { 3, 4, 15, 20, 30, 70, 80, 120 };
//		int commNumber = new SmallestCommonNumber().findSmallestCommon(arr1, arr2, arr3);
//		System.out.println(commNumber);
//	}
}
