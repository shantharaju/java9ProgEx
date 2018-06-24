package coderust.linkedlist;

public class ReverseSingleLinkedList {

	public static void main(String[] args) {
		SingleLinkedList<Integer> sl = new SingleLinkedList<>();
		for (int i = 0; i < 10; i++) {
			sl.addLast(i);
		}
		System.out.println(sl);
		sl.reverse();
		System.out.println(sl);
	}
}
