package coderust.linkedlist;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr2 = { 10, 6, 5, 7, 8, 3, 9 };
		SingleLinkedList<Integer> sl2 = new SingleLinkedList<>();
		for (int i = 0; i < arr2.length; i++) {
			sl2.addLast(arr2[i]);
		}
		System.out.println(sl2);
		sl2.mergeSort();
		System.out.println(sl2);
	}
}
