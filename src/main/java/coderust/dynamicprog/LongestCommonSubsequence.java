package coderust.dynamicprog;

import java.util.Stack;

/**
 * L[i][j] = { L[i-1][j-1] + 1 if (A[i] == B[j]). Otherwise,
 * 			   max(L[i][j-1], L[i-1][j]) if A[i] != B[j] 
 * 			 }
 * You can also maintain subsequence in L
 */

public class LongestCommonSubsequence {
	public String findLCS(String A, String B) {
		int n = A.length();
		int m = B.length();
		int[][] L = new int[n][m];

		L[0][0] = (A.charAt(0) == B.charAt(0)) ? 1 : 0;

		// Fill first row
		for (int j = 1; j < m; j++) {
			int match = (A.charAt(0) == B.charAt(j)) ? 1 : 0;
			L[0][j] = Math.max(match, L[0][j - 1]);
		}
		// Fill first column
		for (int i = 1; i < n; i++) {
			int match = (A.charAt(i) == B.charAt(0)) ? 1 : 0;
			if(match > 0) {
				L[i][0] = Math.max(match, L[i-1][0]);
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (A.charAt(i) == B.charAt(j)) {
					L[i][j] = L[i - 1][j - 1] + 1;
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}

		printL(L);
		
		Stack<Character> s = new Stack<>();
		n--;
		m--;
		while(n >= 0 && m >= 0) {
			if(n == 0) {
				if(L[n][m] > 0) {
					s.push(A.charAt(n));
				}
				break;
			}
			if(m == 0) {
				if(L[n][m] > 0) {
					s.push(B.charAt(m));
				}
				break;
			}
			if(A.charAt(n) == B.charAt(m)) {
				s.push(A.charAt(n));
				n--;
				m--;
			}
			else {
				if(L[n-1][m] > L[n][m-1]) {
					n--;
				}
				else {
					m--;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		return sb.toString();
	}

	public void printL(int[][] L) {
		for (int i = 0; i < L.length; i++) {
			for (int j = 0; j < L[0].length; j++) {
				System.out.print(L[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
//		String A = "abc";
//		String B = "bcd";
		
		String A = "CGATAATTGAGA";
		String B = "GTTCCTAATA";
		System.out.println(lcs.findLCS(A, B));
	}

}
