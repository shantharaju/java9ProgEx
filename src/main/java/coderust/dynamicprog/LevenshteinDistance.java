package coderust.dynamicprog;

/**
 * Find the Levenshtein distance (edit distance) between two strings
 *
 * Formula:
 * 
 * L[i,j] =  max(i,j) 	if min(i,j) == 0
 * 			 min( 	L[i-1, j] + 1, 
 * 					L[i, j-1] + 1, 
 * 					L[i-1][j-1] + IdF(i,j)
 * 			 )
 * 			 IdF(i,j) = 0 if a[i]==b[j], 1 otherwise
 */
public class LevenshteinDistance {
	int editDistance(String a, String b) {
		// if one of the string is null or empty 
		// edit distance is length of the other string
		int lena = (a == null) ? 0 : a.length();
		int lenb = (b == null) ? 0 : b.length();
		if(Math.min(lena, lenb) == 0) {
			return Math.max(lena, lenb);
		}
		int[][] sb = new int[a.length()][b.length()];
		for(int i=0; i < a.length(); i++) {
			for(int j=0; j<b.length(); j++) {
				int idf = a.charAt(i)==b.charAt(j) ? 0 : 1;
				int l1 = valueAt(sb, i-1, j-1) + idf;
				int l2 = valueAt(sb, i, j-1) + 1;
				int l3 = valueAt(sb, i-1, j) + 1;
				int min1 = Math.min(l1, l2);
				sb[i][j] = Math.min(min1, l3);
			}
		}
		return sb[a.length()-1][b.length()-1];
	}
	private int valueAt(int[][] sb, int i, int j) {
		if(Math.min(i, j) < 0) {
			return Math.max(i, j) + 1;
		}
		return sb[i][j];
	}

	public static void main(String[] args) {
		LevenshteinDistance ld = new LevenshteinDistance();
		System.out.println(ld.editDistance("abcde", "abd"));
	}
}
