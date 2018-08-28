package coderust.dynamicprog;

public class CoinInALine {
	public void printMoves(int[][] P, int[] arr) {
		boolean alice = true;
		int n = 0;
		int m = P[0].length -1;
		while (n <= m) {
			String who = alice ? "Alice " : "Bob ";
			if (n == m) {
				System.out.println(who + "Picks " + arr[n]);
				break;
			}
			if (m == n + 1) {
				int max;
				if (arr[n] > arr[m]) {
					max = arr[n];
					n++;
				} else {
					max = arr[m];
					m--;
				}
				System.out.println(who + "Picks " + max);
				alice = !alice;
				continue;
			}
			int P1 = arr[n] + Math.min(P[n+2][m], P[n+1][m-1]);
			int P2 = arr[m] + Math.min(P[n+1][m-1], P[n][m-2]);
			int max;
			if(P1 > P2) {
				max = arr[n];
				n++;
			} else {
				max = arr[m];
				m--;
			}
			System.out.println(who + "Picks " + max);
			alice = !alice;
		}
	}
	/**
	 * User recurrence formula:
	 * P1 = A[i] + min(P[i+2][j], P[i+1][j-1])
	 * P2 = A[j] + min(P[i+1][j-1], P[i][j-2])
	 * P[i][j] = max(P1, P2)
	 * 
	 */
	public int optimalValue(int[] arr) {
		int n = arr.length;
		int[][] P = new int[n][n];
		for(int i = 0; i < n; i++)  {
			P[i][i] = arr[i];
		}
		for(int i = 0; i < n-1; i++) {
			P[i][i+1] = Math.max(arr[i], arr[i+1]);
		}
		for(int i = 2; i < n; i++) {
			for(int j = i, k=0; j < n; j++, k++) {
				int P1 = arr[k] + Math.min(P[k+2][j], P[k+1][j-1]);
				int P2 = arr[j] + Math.min(P[k+1][j-1], P[k][j-2]);
				P[k][j] = Math.max(P1, P2);
			}
		}
//		for(int i=0; i < n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(P[i][j] + ", ");
//			}
//			System.out.println();
//		}
		printMoves(P, arr);
		return P[0][arr.length - 1];
	}
	
	public static void main(String[] args) {
		// int arr[] = {8, 15, 3, 7};
		// int arr[] = {2, 2, 2, 2};
		// int arr[] = {20, 30, 2, 2, 2, 10};
		int arr[] = {62, 43, 96, 23, 36, 27, 3, 82, 17, 29, 42, 6, 25, 56};
		System.out.println(new CoinInALine().optimalValue(arr));
	}
}
