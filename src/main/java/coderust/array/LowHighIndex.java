package coderust.array;

import java.util.Arrays;

public class LowHighIndex {

	public int[] findLowHighIndex(int[] arr, int element) {
		int[] ret = new int[2];
		ret[0] = findLowIndex(arr, 0, arr.length - 1, element);
		ret[1] = findHighIndex(arr, 0, arr.length - 1, element);
		return ret;
	}
	
	private int findHighIndex(int[] arr, int i, int j, int element) {
		if(i>j) {
			return -1;
		}
		int mid = i + (j-i)/2;
		if(arr[mid]==element) {
			if(mid == (arr.length - 1)) {
				return mid;
			}
			else if(arr[mid] < arr[mid + 1]) {
				return mid;
			}
			else {
				return findHighIndex(arr, mid + 1, j, element);
			}
		}
		else if(arr[mid] < element) {
			return findHighIndex(arr, mid+1, j, element);
		}
		else {
			return findHighIndex(arr, i, mid-1, element);
		}
	}

	private int findLowIndex(int[] arr, int i, int j, int element) {
		if(i > j) {
			return -1;
		}
		int mid = i + (j-i)/2;
		if(arr[mid] == element) {
			if(mid == 0) {
				return mid;
			}
			else if(arr[mid - 1] < arr[mid]) {
				return mid;
			}
			else {
				return findLowIndex(arr, i, mid-1, element);
			}
		}
		else if(arr[mid] > element) {
			return findLowIndex(arr, i, mid - 1, element);
		}
		else {
			return findLowIndex(arr, mid + 1, j, element);
		}
	}

	public static void main(String[] args) {
		int[] arr = {0,0,0,1,1,1,2,2,2,3,3,3,3,4};
		LowHighIndex lw = new LowHighIndex();
		System.out.println(Arrays.toString(lw.findLowHighIndex(arr, 0)));
	}
}
