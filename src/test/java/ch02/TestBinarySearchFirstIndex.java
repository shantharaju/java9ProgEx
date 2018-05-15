package ch02;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestBinarySearchFirstIndex {

	@DataProvider(name = "target")
	public Object[][] createTarget() {
		return new Object[][] {
			{new Integer(2), new Integer(0)},
			{new Integer(4), new Integer(1)},
			{new Integer(5), new Integer(2)},
			{new Integer(6), new Integer(5)},
			{new Integer(9), new Integer(7)},
			{new Integer(1), new Integer(-1)},
			{new Integer(3), new Integer(-1)},
			{new Integer(7), new Integer(-1)},
			{new Integer(10), new Integer(-1)}
		};
	}
	@Test(dataProvider = "target")
	public void testBinarySearchFirstIndex(int target, int index) {
		int[] arr = {2, 4, 5, 5, 5, 6, 6, 9};
		BinarySearchFirstIndex bsfi = new BinarySearchFirstIndex();
		Assert.assertEquals(bsfi.first(arr, 0, arr.length - 1, target), index);
	}
}
