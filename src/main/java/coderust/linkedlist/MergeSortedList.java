package coderust.linkedlist;

public class MergeSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 3, 7, 9, 11 };
		int[] arr2 = { 2, 4, 6, 6, 8, 10 };
		SingleLinkedList<Integer> sl1 = new SingleLinkedList<>();
		for (int i = 0; i < arr1.length; i++) {
			sl1.addLast(arr1[i]);
		}

		SingleLinkedList<Integer> sl2 = new SingleLinkedList<>();
		for (int i = 0; i < arr2.length; i++) {
			sl2.addLast(arr2[i]);
		}
		SingleLinkedList<Integer> sl3 = SingleLinkedList.merge(sl1, sl2);
		System.out.println(sl3);
	}

}
