package coderust.linkedlist;

public class IntersectOfTwoLinkedList {

	public static void main(String[] args) {
		int[] arr1 = { 8, 2, 4, 5, 6 };
		int[] arr2 = { 18, 12, 14, 15, 16, 17, 19 };
		int[] arr3 = { 21, 22, 23, 24 };

		SingleLinkedList<Integer> sl1 = new SingleLinkedList<>();
		for (int i = 0; i < arr1.length; i++) {
			sl1.addLast(arr1[i]);
		}

		SingleLinkedList<Integer> sl2 = new SingleLinkedList<>();
		for (int i = 0; i < arr2.length; i++) {
			sl2.addLast(arr2[i]);
		}

		SingleLinkedList<Integer> sl3 = new SingleLinkedList<>();
		for (int i = 0; i < arr3.length; i++) {
			sl3.addLast(arr3[i]);
		}
		sl1.addLast(sl3);
		sl2.addLast(sl3);

		System.out.println(sl1);
		System.out.println(sl2);
		System.out.println("sl1 length=" + sl1.length());
		System.out.println("sl2 length=" + sl2.length());
		
		SingleLinkedList<Integer> intersect = SingleLinkedList.findIntersection(sl1, sl2);
		System.out.println(intersect);
	}
}
