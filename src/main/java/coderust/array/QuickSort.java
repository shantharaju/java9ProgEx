package coderust.array;

import java.util.Arrays;

public class QuickSort {

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public int partition(int[] arr, int start, int end) {
		int i = start;
		int j = start - 1;
		int pivot = arr[end];
		for (; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, ++j, i);
			}
		}
		swap(arr, ++j, i);
		return j;
	}

	public void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot - 1);
		quickSort(arr, pivot + 1, end);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 3, 8 };
		// int[] arr = {1,2,3,4,5,6};
		// int[] arr = {7,6,5,4,3,2,1};

		QuickSort qs = new QuickSort();
		qs.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
