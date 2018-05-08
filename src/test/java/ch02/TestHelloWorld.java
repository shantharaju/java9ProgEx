package ch02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHelloWorld {
	
	@Test
	public void testHelloWorld() {
		HelloWorld h = new HelloWorld();
		Assert.assertEquals(h.hello("Rekha"), "Hello, Rekha");
	}
}
