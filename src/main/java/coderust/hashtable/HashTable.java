package coderust.hashtable;

import java.util.LinkedList;

/**
 * HashTable to store arbitrary data type in an array of linkedList.
 * @author Shantha
 *
 * @param <T>
 */
public class HashTable<T> {
	LinkedList<T>[] buckets;
	double loadFactor;
	int size;
	
	HashTable(double loadFactor, int initialSize) {
		this.loadFactor = loadFactor;
		buckets = (LinkedList<T>[]) new LinkedList<?>[initialSize];
	}
	private void rehash() {
		LinkedList<T>[] newbuckets = (LinkedList<T>[]) new LinkedList<?>[buckets.length * 2];
		for(LinkedList<T> b : buckets) {
			b.forEach(x -> {
				int index = x.hashCode() % newbuckets.length;
				if(newbuckets[index] == null) {
					newbuckets[index] = new LinkedList<>();
				}
				newbuckets[index].add(x);
			});
		}
	}
	public boolean insert(T element) {
		int index = element.hashCode() % buckets.length;
		if(((size*1.0)/buckets.length) > loadFactor) {
			rehash();
		}
		if(buckets[index] == null) {
			LinkedList<T> bucket = new LinkedList<>();
			buckets[index] = bucket;
		}
		if(!buckets[index].contains(element)) {
			buckets[index].add(element);
			++size;
			return true;
		}
		return false;
	}

	public T search(T element) {
		int index = element.hashCode() % buckets.length;
		if(buckets[index] == null) {
			return null;
		}
		if(buckets[index].contains(element)) {
			return element;
		}
		return null;
	}
	
	public int size() {
		return this.size;
	}
	public static void main(String[] args) {
		HashTable<String> sht = new HashTable<>(1.25, 4);
		System.out.println(sht.insert("This is string1"));
		System.out.println(sht.insert("This is string2"));
		System.out.println(sht.insert("This is string2"));
		System.out.println(sht.insert("This is string3"));
		System.out.println(sht.insert("This is string4"));
		System.out.println(sht.insert("This is string5"));
		System.out.println(sht.insert("This is string6"));
		System.out.println(sht.insert("This is string7"));
		System.out.println(sht.insert("This is string8"));
		System.out.println(sht.insert("This is string9"));
		
		System.out.println(sht.search("This is string4"));
		System.out.println(sht.search("This is string2"));
		System.out.println(sht.search("This is string1"));
		System.out.println(sht.size());
	}
}
