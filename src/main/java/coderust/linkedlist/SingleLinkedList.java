package coderust.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<T extends Comparable<T>> implements Iterable<T> {
	private Node<T> head;

	public SingleLinkedList() {
		head = null;
	}

	public SingleLinkedList(Node<T> node) {
		head = node;
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
			return;
		}
		Node<T> last = head;
		for (; last.next != null; last = last.next)
			;
		last.next = newNode;
	}

	public void addLast(SingleLinkedList<T> list) {
		addLast(list.head);
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

	public void insertionSort() {
		if (head == null || head.next == null) {
			return;
		}
		Node<T> sortedList = null;
		do {
			Node<T> current = head;
			head = head.next;
			current.next = null;
			sortedList = sortedInsert(sortedList, current);
		} while (head != null);
		head = sortedList;
	}

	private Node<T> sortedInsert(Node<T> sortedList, Node<T> toInsert) {
		if (sortedList == null) {
			sortedList = toInsert;
			return sortedList;
		}
		// node being inserted is less than head
		if (sortedList.data.compareTo(toInsert.data) >= 0) {
			toInsert.next = sortedList;
			sortedList = toInsert;
			return sortedList;
		}

		Node<T> current = sortedList;
		for (; current.next != null; current = current.next) {
			if (current.next.data.compareTo(toInsert.data) > 0) {
				break;
			}
		}
		toInsert.next = current.next;
		current.next = toInsert;
		return sortedList;
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

	public int length() {
		Node<T> curr = head;
		int length = 0;
		for (curr = head; curr != null; curr = curr.next, length++)
			;
		return length;
	}

	public T findNthFromEnd(int n) {
		if (head == null) {
			return null;
		}
		Node<T> startPtr = head;
		Node<T> endPtr = head;
		while (endPtr != null && n > 0) {
			endPtr = endPtr.next;
			n--;
		}
		if (endPtr == null && n > 0) {
			return null;
		}
		while (endPtr != null) {
			startPtr = startPtr.next;
			endPtr = endPtr.next;
		}
		return startPtr.data;
	}

	public void swapNthNodeWithHead(int n) {
		if (head == null || head.next == null || n <= 1) {
			return;
		}
		Node<T> prev = head;
		for (int i = 1; i < n - 1 && (prev != null); i++) {
			prev = prev.next;
		}
		if (prev == null || prev.next == null) {
			return;
		}
		Node<T> nth = prev.next; // this will become head

		prev.next = head;

		// swap pointers
		Node<T> temp = nth.next;
		nth.next = head.next;
		head.next = temp;

		// point head to nth node
		head = nth;
	}

	// scope keyword GenericType returnType functionName(InputParams...)
	public static <C extends Comparable<C>> SingleLinkedList<C> findIntersection(SingleLinkedList<C> sl1,
			SingleLinkedList<C> sl2) {
		int length1 = sl1.length();
		int length2 = sl2.length();
		Node<C> start1 = sl1.head;
		Node<C> start2 = sl2.head;

		if (length1 < length2) {
			for (int i = 0; i < length2 - length1; i++) {
				start2 = start2.next;
			}
		} else if (length1 > length2) {
			for (int i = 0; i < length1 - length2; i++) {
				start1 = start1.next;
			}
		}
		while ((start1 != start2) && (start1 != null) && (start2 != null)) {
			start1 = start1.next;
			start2 = start2.next;
		}
		if (start1 == null || start2 == null) {
			return new SingleLinkedList<>(null);
		} else {
			return new SingleLinkedList<>(start1);
		}
	}

	public void mergeSort() {
		head = mergeHelper(head);
	}

	private Node<T> mergeHelper(Node<T> h) {
		if (h == null || h.next == null) {
			return h;
		}
		Node<T> middle = findMiddle(h);
		Node<T> secondHead = middle.next;
		middle.next = null;

		Node<T> h1 = mergeHelper(h);
		Node<T> h2 = mergeHelper(secondHead);
		Node<T> h3 = sortedMerged(h1, h2);
		return h3;
	}

	private Node<T> sortedMerged(Node<T> h1, Node<T> h2) {
		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		SingleLinkedList<T> sl = new SingleLinkedList<>();

		while (h1 != null && h2 != null) {
			if (h1.data.compareTo(h2.data) > 0) {
				Node<T> temp = h2;
				h2 = h2.next;
				temp.next = null;
				sl.addLast(temp);
			} else if (h1.data.compareTo(h2.data) < 0) {
				Node<T> temp = h1;
				h1 = h1.next;
				temp.next = null;
				sl.addLast(temp);
			} else {
				Node<T> t1 = h1;
				Node<T> t2 = h2;
				h1 = h1.next;
				h2 = h2.next;
				t1.next = null;
				t2.next = null;
				sl.addLast(t1);
				sl.addLast(t2);
			}
		}
		while (h1 != null) {
			Node<T> temp = h1;
			h1 = h1.next;
			temp.next = null;
			sl.addLast(temp);
		}
		while (h2 != null) {
			Node<T> temp = h2;
			h2 = h2.next;
			temp.next = null;
			sl.addLast(temp);
		}
		return sl.head;
	}

	private Node<T> findMiddle(Node<T> h) {
		if (h == null || h.next == null) {
			return h;
		}
		Node<T> fastPtr = h.next;
		Node<T> slowPtr = h;

		while (fastPtr != null) {
			fastPtr = fastPtr.next;

			if (fastPtr != null) {
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
		}
		return slowPtr;
	}

	public static <C extends Comparable<C>> SingleLinkedList<C> merge(SingleLinkedList<C> sl1,
			SingleLinkedList<C> sl2) {
		// TODO: Instead returning list, do a deep copy and return
		if (sl1.head == null) {
			return sl2;
		} else if (sl2.head == null) {
			return sl1;
		}
		SingleLinkedList<C> sl3 = new SingleLinkedList<C>();
		Node<C> sl1Curr = sl1.head;
		Node<C> sl2Curr = sl2.head;
		while (sl1Curr != null && sl2Curr != null) {
			if (sl1Curr.data.compareTo(sl2Curr.data) > 0) {
				Node<C> temp = sl2Curr;
				sl2Curr = sl2Curr.next;
				temp.next = null;
				sl3.addLast(temp);
			} else if (sl1Curr.data.compareTo(sl2Curr.data) < 0) {
				Node<C> temp = sl1Curr;
				sl1Curr = sl1Curr.next;
				temp.next = null;
				sl3.addLast(temp);
			} else {
				Node<C> t1 = sl1Curr;
				Node<C> t2 = sl2Curr;
				sl1Curr = sl1Curr.next;
				sl2Curr = sl2Curr.next;
				t1.next = null;
				t2.next = null;
				sl3.addLast(t1);
				sl3.addLast(t2);
			}
		}
		while (sl1Curr != null) {
			Node<C> temp = sl1Curr;
			sl1Curr = sl1Curr.next;
			temp = temp.next;
			sl3.addLast(temp);
		}
		while (sl2Curr != null) {
			Node<C> temp = sl2Curr;
			sl2Curr = sl2Curr.next;
			temp = temp.next;
			sl3.addLast(temp);
		}
		return sl3;
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
