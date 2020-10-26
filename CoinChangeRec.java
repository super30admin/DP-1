//Coin change using Recursion
public class CoinChangeRec {
	public int coinChange(int[] coins, int amount) {

		if (coins == null || coins.length == 0 || amount == 0) {
			return -1;
		}
		return helper(coins, amount, 0, 0);

	}

	int helper(int[] coins, int amount, int index, int resultCoins) {
		// base
		if (amount == 0)
			return resultCoins;

		if (amount < 0 || index == coins.length)
			return -1;

		// logic
		int case1 = helper(coins, amount - coins[index], index, resultCoins + 1); // when that particular denomination
																					// is selected.
		int case2 = helper(coins, amount, index + 1, resultCoins); // when that denomination is not selected.
		if (case1 == -1)
			return case2;
		if (case2 == -1)
			return case1;
		return Math.min(case1, case2);

	}

}
