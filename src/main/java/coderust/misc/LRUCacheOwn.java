package coderust.misc;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCacheOwn {

	private List<String> list;
	private Map<String, String> map;
	private final int size;
	
	public LRUCacheOwn(int s) {
		size = s;
		list = new LinkedList<>();
		map = new HashMap<String, String>();
	}
	
	public String put(String key, String value) {
		if(list.contains(key)) {
			list.remove(key);
		}
		else if(list.size()==size) {
			list.remove(0);
		}
		map.put(key, value);
		list.add(key);
		return value;
	}
	
	public String get(String key) {
		if(list.contains(key)) {
			list.remove(key);
			list.add(key);
			return map.get(key);
		}
		return null;
	}
	
	public List<String> keys() {
		return Collections.unmodifiableList(list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCacheOwn l = new LRUCacheOwn(3);
		l.put("1", "One");
		l.put("2", "Two");
		l.put("3", "Three");
		l.keys().forEach(x -> System.out.println(x));
		System.out.println("********************");
		l.put("4", "Four");
		l.put("5", "Five");
		l.keys().forEach(x -> System.out.println(x));
		System.out.println("********************");
		l.get("3");
		l.keys().forEach(x -> System.out.println(x));
		l.put("6", "Six");
		System.out.println("********************");
		l.keys().forEach(x -> System.out.println(x));
	}
}