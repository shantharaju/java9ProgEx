package hackerrank;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int n = -1;
			if (scan.hasNextInt()) {
				n = scan.nextInt();
			}
			int[][] matrix = new int[n][n];
			scan.nextLine();

			for (int i = 0; i < n; i++) {
				String[] rowStr = scan.nextLine().split(" ");
				for (int j = 0; j < rowStr.length; j++) {
					matrix[i][j] = Integer.parseInt(rowStr[j].trim());
				}
			}
			int difference = calcDiagDifference(matrix);
			System.out.println(difference);
		}
	}

	/*
	 * 00 01 02 03 04
	 * 10 11 12 13 14
	 * 20 21 22 23 24
	 * 30 31 32 33 34
	 * 40 41 42 43 44
	 * 
	 */
	private static int calcDiagDifference(int[][] matrix) {
		int primarySum = 0;
		for(int i=0; i<matrix.length; i++) {
			primarySum += matrix[i][i];
		}
		int secSum = 0;
		for(int i=0, j=matrix.length -1; i < matrix.length && j >= 0; i++,j--) {
			secSum += matrix[i][j];
		}
		return Math.abs(primarySum - secSum);
	}
}
