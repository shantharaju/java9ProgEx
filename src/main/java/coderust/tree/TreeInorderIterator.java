package coderust.tree;

public class TreeInorderIterator {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bt = new BinarySearchTree<>();
		bt.add(5);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		bt.printInorderIterative();
		
		for(Integer i : bt) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
}
