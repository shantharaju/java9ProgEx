package coderust.tree;

public class Node<T extends Comparable<T>> {
	T data;
	Node<T> right;
	Node<T> left;
	
	Node(T data) {
		this.data = data;
		right = null;
		left = null;
	}
}
