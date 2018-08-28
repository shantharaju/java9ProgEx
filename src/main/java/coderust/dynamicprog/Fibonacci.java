package coderust.dynamicprog;

/**
 * FIB(0) = 0 FIB(1) = 1 FIB(N) = FIB(N-1) + FIB(N-2)
 *
 */
public class Fibonacci {
	private long findNthFib(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Invalid n=" + n);
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		long fibn_2 = 0;
		long fibn_1 = 1;
		long fibn = 1;
		for (int i = 2; i <= n; i++) {
			fibn = fibn_2 + fibn_1;
			fibn_2 = fibn_1;
			fibn_1 = fibn;
		}
		return fibn;
	}

	public static void main(String[] args) {
		int n = 13;
		long nthFib = new Fibonacci().findNthFib(n);
		System.out.println(nthFib);
	}

}
