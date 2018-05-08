package ch02;

/**
 * Bubble sort a list of strings
 * @author Shantha
 *
 */
public class BubbleSort {
	public void sort(String[] names) {
		for(int i = 0; i < names.length; ++i) {
			for(int j = 0; j < names.length - i -1; ++j) {
				if(names[j].compareTo(names[j+1]) > 0) {
					swap(names, j, j+1);
				}
			}
		}
	}
	private void swap(String[] names, int i, int j) {
		final String temp = names[i];
		names[i] = names[j];
		names[j] = temp;		
	}
}