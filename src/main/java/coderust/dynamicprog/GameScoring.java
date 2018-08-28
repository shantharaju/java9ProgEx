package coderust.dynamicprog;

/*
 * Given score types 1, 2 and 4 find possible ways to reach score 'n'
 */
public class GameScoring {

	public int findPossibleWaysToReachScore(int n) {
		int[] sb = new int[n+1];
		
		sb[0] = 1;
		for(int i = 1; i <=n; i++) {
			sb[i] += sb[i - 1];
		}
		for(int i = 2; i <=n; i++) {
			sb[i] += sb[i - 2];
		}
		for(int i = 4; i <=n; i++) {
			sb[i] += sb[i - 4];
		}
		return sb[n];
	}
	public static void main(String[] args) {
		System.out.println(new GameScoring().findPossibleWaysToReachScore(5));
	}
}
