package coderust.array;

public class MatrixDiagonalTraverse {

	public static void main(String[] args) {
		int n = 5;
		for (int l = 0; l < n; l++) {
			for (int i = 0, j = l; i < n && j < n; i++, j++) {
				System.out.println("i=" + i + ", j=" + j);
			}
		}
	}

}
