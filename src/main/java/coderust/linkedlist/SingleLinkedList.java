package coderust.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<T> implements Iterable<T> {
	private Node<T> head;

	public SingleLinkedList() {
		head = null;
	}

	public void addLast(T d) {
		Node<T> newNode = new Node<>(d);
		if (head == null) {
			head = newNode;
			return;
		}
		Node<T> last = head;
		for (; last.next != null; last = last.next)
			;
		last.next = newNode;
	}

	public void addLast(Node<T> newNode) {
		if (head == null) {
			head = newNode;
		}
		Node<T> last = head;
		for (; last.next != null; last = last.next)
			;
		last.next = newNode;
	}

	public void reverse() {
		if (head == null || head.next == null) {
			return;
		}
		// Node<T> hp = null;
		// Node<T> hn = head.next;
		// while (hn != null) {
		// head.next = hp;
		// hp = head;
		// head = hn;
		// hn = hn.next;
		// }
		// head.next = hp;
		Node<T> reversedList = head;
		Node<T> yetToConvertList = head.next;
		reversedList.next = null;
		while (yetToConvertList != null) {
			Node<T> temp = yetToConvertList;
			yetToConvertList = yetToConvertList.next;
			temp.next = reversedList;
			reversedList = temp;
		}
		head = reversedList;
	}

	/**
	 * Remove duplicates by running two loops
	 */
	public void removeDuplicates() {
		if (head == null || head.next == null) {
			return;
		}
		// Node<T> current = head; // element against which duplicates are
		// compared
		// Node<T> prev = head; // previous node to currently being scanned
		// Node<T> toScan = head.next;
		//
		for (Node<T> current = head; current != null; current = current.next) {
			Node<T> prev = current;
			for (Node<T> toCheck = current.next; toCheck != null;) {
				if (toCheck.data.equals(current.data)) {
					prev.next = toCheck.next;
					toCheck = toCheck.next;
				} else {
					prev = prev.next;
					toCheck = toCheck.next;
				}
			}
		}
	}

	// delete all nodes with matching key
	public void delete(T key) {
		while (head != null) {
			if (head.data.equals(key)) {
				head = head.next;
			} else {
				break;
			}
		}
		if (head == null) {
			return;
		}
		for (Node<T> curr = head.next, prev = head; curr != null; curr = curr.next) {
			if (curr.data.equals(key)) {
				prev.next = curr.next;
			} else {
				prev = prev.next;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (Node<T> n = head; n != null; n = n.next) {
			if (n != head) {
				sb.append(",");
			}
			sb.append(n.data);
		}
		// for(T d : this) {
		// sb.append(",").append(d);
		// }
		sb.append("]");
		return sb.toString();
	}

	// Node class
	private static class Node<T> {
		private T data;
		private Node<T> next;

		Node(T d) {
			data = d;
			next = null;
		}
	}

	// Iterator implementation
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T> {
		private Node<T> nextNode;

		LinkedListIterator() {
			nextNode = head;
		}

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T d = nextNode.data;
			nextNode = nextNode.next;
			return d;
		}
	}
}
