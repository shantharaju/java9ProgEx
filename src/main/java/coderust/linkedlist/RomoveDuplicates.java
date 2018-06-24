package coderust.linkedlist;

public class RomoveDuplicates {

	public static void main(String[] args) {
		SingleLinkedList<Integer> sl = new SingleLinkedList<>();
		for (int i = 0; i < 10; i++) {
			sl.addLast(i);
			if (i % 2 == 0) {
				sl.addLast(i);
			}
			if (i % 3 == 0) {
				sl.addLast(i);
			}
		}
		for (int i = 0; i < 10; i += 2) {
			sl.addLast(i);
		}
		System.out.println(sl);
		sl.removeDuplicates();
		System.out.println(sl);
	}
}
