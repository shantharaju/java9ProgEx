package coderust.array;

public class searchRotatedArray {
	
	static int binarySearch(int[] arr, int k) {
		int pivot = findPivot(arr, 0, arr.length - 1);
		
		if(pivot == -1) {
			return binarySearchInternal(arr, 0, arr.length -1, k);
		}
		
		int index = binarySearchInternal(arr, 0, pivot, k);
		if(index == -1) {
			index = binarySearchInternal(arr, pivot+1, arr.length - 1, k);
		}
		return index;
	}
	
	private static int findPivot(int[] arr, int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			return -1;
		}
		
		int mid = startIndex + (endIndex - startIndex)/2;
		if(arr[mid] > arr[mid+1]) {
			return mid;
		}
		if((mid > 0) && (arr[mid -1] > arr[mid])) {
			return mid -1;
		}
		if(arr[startIndex] > arr[mid]) {
			return findPivot(arr, startIndex, mid - 1);
		}
		return findPivot(arr, mid + 1, endIndex);
	}

	private static int binarySearchInternal(int[] arr, int startIndex, int endIndex, int k) {
		if(startIndex > endIndex) {
			return -1;
		}
		int mid = startIndex + (endIndex - startIndex)/2;
		if(k == arr[mid]) {
			return mid;
		}
		if(arr[mid] < k) {
			return binarySearchInternal(arr, mid + 1, endIndex, k);
		}
		else {
			return binarySearchInternal(arr, startIndex, mid - 1, k);
		}
	}
	public static void main(String[] args) {
//		int[] arr = { 2 ,3, 4, 5, 6, 7, 1};
//		int target = 7;
//		
		int[] arr = {1,3};
		int target = 0;
		
		int pivot = findPivot(arr, 0, arr.length - 1);
		System.out.println(pivot);
		int index = binarySearch(arr, target);
		System.out.println(index);
	}

}
