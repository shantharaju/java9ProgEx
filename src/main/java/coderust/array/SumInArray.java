package coderust.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumInArray {

	boolean findSumByHashMap(int[] arr, int val) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int element : arr) {
			int count = 0;
			if (map.get(element) != null) {
				count = map.get(element);
			}
			map.put(element, ++count);
		}

		for (int element : arr) {
			if (map.containsKey(val - element)) {
				int counter = map.get(val - element);
				if ((counter == 1) && (element + element == val)) {
					continue;
				}
				return true;
			}
		}
		return false;
	}

	boolean findSum(int[] arr, int val) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum < val) {
				left++;
			} else if (sum > val) {
				right--;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 4, 45, 6, 10, -8 };
		int val = 5;
		System.out.println(new SumInArray().findSum(arr, val));
	}
}