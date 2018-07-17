package coderust.linkedlist;

public class SwapNthNodeWithHead {

	public static void main(String[] args) {
		int[] arr2 = { 18, 12, 14, 15, 16, 17, 19 };
		SingleLinkedList<Integer> sl2 = new SingleLinkedList<>();
		for (int i = 0; i < arr2.length; i++) {
			sl2.addLast(arr2[i]);
		}
		System.out.println(sl2);
		sl2.swapNthNodeWithHead(8);
		System.out.println(sl2);
	}

}
