package coderust.dynamicprog;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given coin denominations and the total amount, find out the number of wayt to make change
 * It generalizes the GameScoring program
 *
 */
public class CoinChange {

	int numWaysToMakeChange(int[] coins, int sum) {
		int[] sb = new int[sum+1];
		sb[0] = 1;
		List<Integer> coinsList = Arrays.stream(coins).boxed().collect(Collectors.toList());
		Collections.sort(coinsList);
		for(Integer coin : coinsList) {
			for(int i = coin; i <= sum; i++) {
				sb[i] += sb[i-coin];
			}
		}
		return sb[sum];
	}
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] coins = {1, 2, 4};
		int sum = 9;
		System.out.println(cc.numWaysToMakeChange(coins, sum));
	}

}
