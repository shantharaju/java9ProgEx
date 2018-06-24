package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AliceRanking {

	public static void main(String[] args) {
		int[] scores = {100, 100, 50, 40, 40, 20, 10};
		int[] alice = {5, 25, 50, 120};
		/* int[] distinctScores = IntStream.range(0,scores.length).map(i -> scores[i]).distinct().toArray();
		for(int distinctScore : distinctScores) {
			System.out.println(distinctScore);
		}
		*/
		List<Integer> scoresList = new ArrayList<Integer>();
		int prev = -1;
		for(int score: scores) {
			if(score==prev) continue;
			scoresList.add(score);
			prev = score;
		}
		for(int aliceScore : alice) {
			System.out.println(findRank(scoresList, aliceScore));
		}
		System.out.println(scoresList);
	}

	private static int findRank(List<Integer> scoresList, int aliceScore) {
		for(int i = scoresList.size() - 1; i>=0; i--) {
			if(aliceScore < scoresList.get(i)) {
				return i + 2;
				
			}
			if(aliceScore == scoresList.get(i)) {
				return i+ 1;
			}
		}
		return 1;
	}

}
