package coderust.linkedlist;

public class InsertionSortSingleLinkedList {

	public static void main(String[] args) {
		SingleLinkedList<Integer> sl = new SingleLinkedList<>();
		for (int i = 0; i < 10; i++) {
			sl.addLast((int)(Math.random() * 10));
		}
		System.out.println(sl);
		sl.insertionSort();
		System.out.println(sl);
	}
}
