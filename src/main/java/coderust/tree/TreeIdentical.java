package coderust.tree;

public class TreeIdentical {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bt1 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bt2 = new BinarySearchTree<>();

		bt1.add(5);
		bt1.add(4);
		bt1.add(8);
		bt1.add(3);
		bt1.add(5);
		bt1.add(7);
		bt1.add(9);

		bt2.add(5);
		bt2.add(4);
		bt2.add(8);
		bt2.add(3);
		bt2.add(5);
		bt2.add(7);
		bt2.add(9);
		bt1.printLevelOrder();
		bt2.printLevelOrder();

		System.out.println(BinarySearchTree.areIdentical(bt1, bt2));
	}
}
