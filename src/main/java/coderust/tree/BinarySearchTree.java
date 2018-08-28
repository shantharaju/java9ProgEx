package coderust.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Reference: http://www.baeldung.com/java-binary-tree
 * 
 * @author Shantha
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	Node<T> root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(T data) {
		root = addRecursive(root, data);
	}

	private Node<T> addRecursive(Node<T> current, T data) {
		if (current == null) {
			return new Node<T>(data);
		}

		if (current.data.compareTo(data) > 0) {
			current.left = addRecursive(current.left, data);
		} else if (current.data.compareTo(data) < 0) {
			current.right = addRecursive(current.right, data);
		} else {
			// ignore already exist
		}
		return current;
	}

	public boolean contains(T data) {
		return containsRecursive(root, data);
	}

	private boolean containsRecursive(Node<T> current, T data) {
		if (current == null) {
			return false;
		}
		if (current.data.compareTo(data) == 0) {
			return true;
		} else if (current.data.compareTo(data) > 0) {
			return containsRecursive(current.left, data);
		} else {
			return containsRecursive(current.right, data);
		}
	}

	public void delete(T data) {
		root = deleteRecursive(root, data);
	}

	private Node<T> deleteRecursive(Node<T> current, T data) {
		if (current == null) {
			return current;
		}
		if (current.data.compareTo(data) == 0) {
			// case 1: current has no children
			// case 2: current has exactly 1 children
			// sole child becomes current
			// case 3: current has both children
			// a) find the smallest children in the right subtree
			// b) replace current node value with smallest children
			// c) delete smallest children from the right subtree
			if (current.left == null && current.right == null) {
				current = null;
			} else if (current.left == null) {
				current = current.right;
			} else if (current.right == null) {
				current = current.left;
			} else {
				T smallest = findSmallest(current.right);
				current.data = smallest;
				current.right = deleteRecursive(current.right, smallest);
			}
		} else if (current.data.compareTo(data) > 0) {
			current.left = deleteRecursive(current.left, data);
		} else {
			current.right = deleteRecursive(current.right, data);
		}
		return current;
	}

	private T findSmallest(Node<T> current) {
		if (current == null) {
			new RuntimeException("Invalid state");
		}
		if (current.left == null) {
			return current.data;
		} else {
			return findSmallest(current.left);
		}
	}

	public void printInOrder() {
		printInOrderRecursive(root);
		System.out.println();
	}

	private void printInOrderRecursive(Node<T> current) {
		if (current == null) {
			return;
		}
		printInOrderRecursive(current.left);
		System.out.print(current.data + ",");
		printInOrderRecursive(current.right);
	}

	public void printLevelOrder() {
		if (root == null) {
			return;
		}
		Queue<Node<T>> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node<T> n = q.remove();
			System.out.print(n.data + ",");
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
		System.out.println();
	}

	/**
	 * Java 9 Algorithms and Datastructures - Debashish Ray Chaudhari, Page 150
	 */
	public void printPreorderIterative() {
		if (root == null) {
			return;
		}
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node<T> node = stack.pop();
			System.out.print(node.data + ",");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		System.out.println();
	}

	private class StackFrame {
		Node<T> node;
		boolean childrenProcessingDone;

		StackFrame(Node<T> n, boolean p) {
			node = n;
			childrenProcessingDone = p;
		}
	}

	/**
	 * Java 9 Algorithms and Datastructures - Debashish Ray Chaudhari, Page 150
	 * Algo: Every node is pushed twice: Initially when pushing children to the
	 * stack. Second time to print the node after children are done with
	 * processing
	 */
	public void printInorderIterative() {
		if (root == null) {
			return;
		}
		Stack<StackFrame> stack = new Stack<>();
		stack.push(new StackFrame(root, false));
		while (!stack.isEmpty()) {
			StackFrame sf = stack.pop();
			if (sf.childrenProcessingDone) {
				System.out.print(sf.node.data + ",");
			} else {
				// push right node
				if (sf.node.right != null) {
					stack.push(new StackFrame(sf.node.right, false));
				}
				// push current node for printing
				stack.push(new StackFrame(sf.node, true));
				// push left node
				if (sf.node.left != null) {
					stack.push(new StackFrame(sf.node.left, false));
				}
			}
		}
		System.out.println();
	}

	public static <C extends Comparable<C>> boolean areIdentical(BinarySearchTree<C> t1, BinarySearchTree<C> t2) {
		return areIdentical(t1.root, t2.root);
	}

	private static <C extends Comparable<C>> boolean areIdentical(Node<C> n1, Node<C> n2) {
		if ((n1 == null && n2 == null)) {
			return true;
		}
		if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) {
			return false;
		}
		if (!n1.data.equals(n2.data)) {
			return false;
		}
		return areIdentical(n1.left, n2.left) && areIdentical(n1.right, n2.right);
	}

	/**
	 * Java 9 Algorithms and Datastructures - Debashish Ray Chaudhari, Page 151
	 */
	public void printPostorderIterative() {
		if (root == null) {
			return;
		}
		Stack<StackFrame> stack = new Stack<>();
		stack.push(new StackFrame(root, false));
		while (!stack.isEmpty()) {
			StackFrame sf = stack.pop();
			if (sf.childrenProcessingDone) {
				System.out.print(sf.node.data + ",");
			} else {
				stack.push(new StackFrame(sf.node, true));
				if (sf.node.right != null) {
					stack.push(new StackFrame(sf.node.right, false));
				}
				if (sf.node.left != null) {
					stack.push(new StackFrame(sf.node.left, false));
				}
			}
		}
	}

	/**
	 * https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
	 * Method 1: Have parent pointer to every node. Inordersuccessor is:
	 * 		a. If node has right child, smallest node in the right subtree
	 * 		b. If node does not have right child then traverse the tree upwards until you find a node
	 * 		   such that node is the left child of its parent. 
	 * 		c. null if both the conditions are not met.
	 * Method 2: Start from the root, iteratively go down the tree looking for the tree and 
	 * keep track of the possible successor. Method 1a still applies
	 * 
	 * @param data
	 * @return
	 */
	public T inorderSuccessor(T data) {
		if(root == null) {
			return null;
		}
		Node<T> node = findNode(root, data);
		if(node == null) {
			return null; // Node not found
		}
		if(node.right != null) {
			return findSmallest(node.right);
		}
		Node<T> parent = root;
		T successor = null;
		while(parent != null) {
			if(parent.data.compareTo(data) > 0) {
				successor = parent.data;
				parent = parent.left;
			}
			else if(parent.data.compareTo(data) < 0) {
				parent = parent.right;
			}
			else {
				break;
			}
		}
		return successor;
	}
	
	private Node<T> findNode(Node<T> current, T data) {
		if (current == null) {
			return null;
		}
		if (current.data.compareTo(data) == 0) {
			return current;
		} else if (current.data.compareTo(data) > 0) {
			return findNode(current.left, data);
		} else {
			return findNode(current.right, data);
		}
	}
	private class TreeInOrderIterator implements Iterator<T> {
		Stack<StackFrame> stack;

		TreeInOrderIterator() {
			stack = new Stack<>();
			if (root != null) {
				stack.push(new StackFrame(root, false));
			}
		}

		@Override
		public boolean hasNext() {
			if (root == null) {
				return false;
			}
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			while (!stack.isEmpty()) {
				StackFrame sf = stack.pop();
				if (sf.childrenProcessingDone) {
					return sf.node.data;
				} else {
					if (sf.node.right != null) {
						stack.push(new StackFrame(sf.node.right, false));
					}
					stack.push(new StackFrame(sf.node, true));
					if (sf.node.left != null) {
						stack.push(new StackFrame(sf.node.left, false));
					}
				}
			}
			throw new IllegalStateException("No elements to return");
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new TreeInOrderIterator();
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bt = new BinarySearchTree<>();
		bt.add(5);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		System.out.println(bt.contains(8));
		// bt.delete(5);
		bt.printInOrder();
		bt.printLevelOrder();
		bt.printPreorderIterative();
		bt.printInorderIterative();
		bt.printPostorderIterative();
	}

}