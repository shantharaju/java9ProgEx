package ch02;

public class BinarySearchFirstIndex {

	public int first(int[] arr, int low, int high, int target) {
		if(low > high) {
			return -1;
		}

		int mid = low + (high - low)/2;
		if(((mid == 0) || (arr[mid] > arr[mid - 1])) && (arr[mid] == target)) {
			return mid;
		}
		else if(arr[mid] >= target) {
			return first(arr, low, mid-1, target);
		}
		else {
			return first(arr, mid+1, high, target);
		}		
	} 
}
