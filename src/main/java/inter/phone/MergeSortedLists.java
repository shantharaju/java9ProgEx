package inter.phone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Twitter telephonic interview question:
 * Given a list of sorted lists write a function to flatten this list of list into a single sorted list.
 * Ex: [[1,3,5], [2,4,6], [1,7,8,9]]
 * Output: [1,1,2,3,4,5,6,7,8,9]
 */
public class MergeSortedLists {
	private class HeapFrame {
		int arrayNumber;
		int value;
		HeapFrame(int a, int v) {
			arrayNumber = a;
			value = v;
		}
	}
	private ArrayList<Integer> mergeArrays(int[][] list, int k) {
		ArrayList<Integer> output = new ArrayList<>();
		PriorityQueue<HeapFrame> heap = new PriorityQueue<>(k, new Comparator<HeapFrame>() {
			@Override
			public int compare(HeapFrame o1, HeapFrame o2) {
				return Integer.compare(o1.value, o2.value);
			}
		});
		int[] arrayIndex = new int[k];

		for (int i = 0; i < k; i++) {
			if (list[i].length > 0) {
				arrayIndex[i]++;
				heap.offer(new HeapFrame(i, list[i][0]));
			}
		}
		while (!heap.isEmpty()) {
			HeapFrame element = heap.poll();
			output.add(element.value);
			int currentPointer = arrayIndex[element.arrayNumber];
			if (currentPointer < list[element.arrayNumber].length) {
				heap.offer(new HeapFrame(element.arrayNumber, list[element.arrayNumber][currentPointer]));
				arrayIndex[element.arrayNumber]++;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int[][] list = new int[][] { 
			{ 1, 4, 10, 15 }, 
			{ 2, 5, 7 }, 
			{ 3, 6, 7, 11, 16, 21 },
			{ } // empty array
		};
		ArrayList<Integer> outputList = new MergeSortedLists().mergeArrays(list, 3);
		System.out.println(outputList);
	}

}

// import java.io.*;
// import java.util.*;
// import java.text.*;
// import java.math.*;
// import java.util.regex.*;
//
//// [[1,3,5], [2,4,6], [1,7,8,9]]
//
//// Array sise = O(n)
//// K such arrays
//// O(nlogK)
//
// public class Solution {
// private class HeapFrame {
//
// }
//
// public ArrayList<Integer> merge(List<List<Integer>> inputLists) {
// ArrayList<Integer> output = new ArrayList<>();
// PriorityQueue<Integer> heap = new PriorityQueue<>();
// int[] pointerList = new int[inputLists.size()];
// boolean complete = false;
// for(int i =0; i < inputLists.size(); i++) {
// List<Integer> inputList = inputLists.get(i);
// heap.offer(inputList.get(0));
// pointerList[i]++;
// }
//
// while(!heap.isEmpty()) {
// output.add(heap.poll());
//
// }
//
//
// }
// public static void main(String args[] ) throws Exception {
// /* Enter your code here. Read input from STDIN. Print output to STDOUT */
// }
// }