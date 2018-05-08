package ch02;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBubbleSort {
	
	@Test
	public void testSort() {
		String[] names = {"asdk", "weiows", "xopwe", "opwed", "tyuix" };
		BubbleSort bs = new BubbleSort();
		bs.sort(names);
		System.out.println(Arrays.toString(names));
		String[] sortedNames = { "asdk", "opwed", "tyuix", "weiows", "xopwe" };
		Assert.assertEquals(names, sortedNames);
	}
}
