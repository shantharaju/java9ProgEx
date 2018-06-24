package coderust.array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSmallestCommonNumber {
	@Test 
	public void test1() {
		int[] arr1 = { 1, 5, 10, 20, 40, 80 };
		int[] arr2 = { 6, 7, 20, 80, 100 };
		int[] arr3 = { 3, 4, 15, 20, 30, 70, 80, 120 };
		int commNumber = new SmallestCommonNumber().findSmallestCommon(arr1, arr2, arr3);
		Assert.assertEquals(commNumber, 20);
	}
	@Test 
	public void test2() {
		int[] arr1 = { 1, 5, 10, 20, 40, 80 };
		int[] arr2 = { 6, 7, 21, 80, 100 };
		int[] arr3 = { 3, 4, 15, 20, 30, 70, 80, 120 };
		int commNumber = new SmallestCommonNumber().findSmallestCommon(arr1, arr2, arr3);
		Assert.assertEquals(commNumber, 80);
	}
	@Test 
	public void test3() {
		int[] arr1 = { 1, 5, 10, 20, 40, 80 };
		int[] arr2 = { 6, 7, 21, 81, 100 };
		int[] arr3 = { 3, 4, 15, 20, 30, 70, 80, 120 };
		int commNumber = new SmallestCommonNumber().findSmallestCommon(arr1, arr2, arr3);
		Assert.assertEquals(commNumber, -1);
	}
}
