package inter.phone;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Google phone
 * Given Integer iterator, build SumAscendingIterator such that, 
 * next() returns sum of consecutive ascending elements in original iterator
 * 
 * Ex: Input iterator = {7, 9, 1, 5, 2, 3, 4};
 *    Output Iterator = {16, 6, 9}
 *
 */
public class SumAscendingIterator implements Iterator<Integer> {
	private final Iterator<Integer> srcIter;
	private Integer lastElement;

	public SumAscendingIterator(Iterator<Integer> srcIter) {
		this.srcIter = srcIter;
	}

	@Override
	public boolean hasNext() {
		return (srcIter.hasNext() || (lastElement != null));
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		if (lastElement == null) {
			lastElement = srcIter.next();
		}
		Integer sum = new Integer(lastElement);

		if (!srcIter.hasNext()) {
			lastElement = null;
			return sum;
		}
		boolean usedLastElement = false;
		while (srcIter.hasNext()) {
			Integer next = srcIter.next();
			if (next >= lastElement) {
				lastElement = next;
				sum += lastElement;
				usedLastElement = true;
			} else {
				lastElement = next;
				usedLastElement = false;
				break;
			}
		}
		if (usedLastElement) {
			lastElement = null;
		}
		return sum;
	}

	public static void main(String[] args) {
		// int[] arr = {7, 9, 1, 5, 2, 3, 4};
		// int[] arr = {1, 2, 3, 4};
		int[] arr = { 5, 4, 3, 2, 1 };

		List<Integer> srcList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		SumAscendingIterator s = new SumAscendingIterator(srcList.iterator());
		while (s.hasNext()) {
			System.out.println(s.next());
		}
	}
}
