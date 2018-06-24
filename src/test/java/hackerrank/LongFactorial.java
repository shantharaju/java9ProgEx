package hackerrank;

import java.math.BigInteger;

public class LongFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 40;
		BigInteger b = BigInteger.ONE;
		for(int i=1; i <=n; i++) {
			b = b.multiply(BigInteger.valueOf(i));
		}
		System.out.println(b.toString());
	}
}