package coderust.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMax {

	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
//		int k = 3;
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int k=4;
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1.compareTo(arg0);
			}});
		
		for(int i=0; i<k; i++) {
			pq.add(arr[i]);
		}
		System.out.println(pq.peek());
		for(int i=k, j=0; i < arr.length; i++, j++) {
			pq.remove(arr[j]);
			pq.add(arr[i]);
			System.out.println(pq.peek());
		}
	}

}
