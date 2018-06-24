package coderust.array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRotateArray {
	@Test
	public void test1() {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int[] output = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3 };
		new RotateArray().rotateArray(arr1, 3);
		Assert.assertEquals(arr1, output);
	}

	@Test
	public void test2() {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int[] output = { 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		new RotateArray().rotateArray(arr1, 9);
		Assert.assertEquals(arr1, output);
	}
}
