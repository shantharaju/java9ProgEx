package coderust.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
	Node<T> root;

	public BinaryTree() {
		root = null;
	}

	public void add(T data) {
		root = addRecursive(root, data);
	}

	private Node<T> addRecursive(Node<T> current, T data) {
		if (current == null) {
			return new Node<T>(data);
		}
		
		if(current.data.compareTo(data) > 0) {
			current.left = addRecursive(current.left, data);
		}
		else if (current.data.compareTo(data) < 0) {
			current.right = addRecursive(current.right, data);
		}
		else {
			// ignore already exist
		}
		return current;
	}

	public boolean contains(T data) {
		return containsRecursive(root, data);
	}

	private boolean containsRecursive(Node<T> current, T data) {
		if(current == null) {
			return false;
		}
		if(current.data.compareTo(data) == 0) {
			return true;
		}
		else if(current.data.compareTo(data) > 0) {
			return containsRecursive(current.left, data);
		}
		else {
			return containsRecursive(current.right, data);
		}
	}

	public void delete(T data) {
		root = deleteRecursive(root, data);
	}
	
	private Node<T> deleteRecursive(Node<T> current, T data) {
		if(current == null) {
			return current;
		}
		if(current.data.compareTo(data) == 0) {
			// case 1: current has no children
			// case 2: current has exactly 1 children
			// 		   sole child becomes current
			// case 3: current has both children
			// 		   a) find the smallest children in the right right subtree
			//		   b) replace current node value with smallest children
			//		   c) delete smallest children from the right subtree
			if(current.left == null && current.right == null) {
				current = null;
			}
			else if(current.left == null) {
				current = current.right;
			}
			else if(current.right == null) {
				current = current.left;
			}
			else {
				T smallest = findSmallest(current.right);
				current.data = smallest;
				current.right = deleteRecursive(current.right, smallest);
			}
		}
		else if(current.data.compareTo(data) > 0) {
			current.left = deleteRecursive(current.left, data);
		}
		else {
			current.right = deleteRecursive(current.right, data);
		}
		return current;
	}

	private T findSmallest(Node<T> current) {
		if(current == null) {
			new RuntimeException("Invalid state");
		}
		if(current.left == null) {
			return current.data;
		}
		else {
			return findSmallest(current.left);
		}
	}

	public void printInOrder() {
		printInOrderRecursive(root);
		System.out.println();
	}
	private void printInOrderRecursive(Node<T> current) {
		if(current == null) {
			return;
		}
		printInOrderRecursive(current.left);
		System.out.print(current.data + ",");
		printInOrderRecursive(current.right);
	}
	public void printLevelOrder() {
		if(root == null) {
			return;
		}
		Queue<Node<T>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node<T> n = q.remove();
			System.out.print(n.data + ",");
			if(n.left != null) {
				q.add(n.left);
			}
			if(n.right != null) {
				q.add(n.right);
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();
		bt.add(5);
		bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    System.out.println(bt.contains(8));
	    bt.delete(5);
	    bt.printInOrder();
	    bt.printLevelOrder();
	}
}