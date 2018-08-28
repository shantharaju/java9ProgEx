package coderust.misc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/**
 * LRU Cache implementation using LinkedHashMap
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {
	private final int size;
	private class MyLinkedHashMap<C,D> extends LinkedHashMap<C,D> {
		private static final long serialVersionUID = 4538571571191867753L;
		@Override
		protected boolean removeEldestEntry(Map.Entry<C, D> e) {
			return size() > size;
		}
		public MyLinkedHashMap(int s, float lf, boolean accessOrder) {
			super(s, lf, accessOrder);
		}
	}
	private MyLinkedHashMap<K,V> map;
	
	public LRUCache(int s) {
		size = s;
		map = new MyLinkedHashMap<K,V>(size, 0.75f, true);
	}

	public V put(K k, V v) {
		return map.put(k, v);
	}
	
	public V get(K k) {
		return map.get(k);
	}

	public Set<K> keys() {
		return map.keySet();
	}

	public static void main(String[] args) {
		LRUCache<String, String> l = new LRUCache<String, String>(3);
		l.put("1", "One");
		l.put("2", "Two");
		l.put("3", "Three");
		// l.keys().forEach(x -> System.out.println(x));
		l.put("4", "Four");
		l.put("5", "Five");
		// l.keys().forEach(x -> System.out.println(x));
		l.get("3");
		l.keys().forEach(x -> System.out.println(x));
		l.put("6", "Six");
		System.out.println("********************");
		l.keys().forEach(x -> System.out.println(x));
	}
}
