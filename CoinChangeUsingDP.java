//Coin change using DP
public class CoinChangeUsingDP {
	public int coinChange(int[] coins, int amount) {

		if (coins == null || coins.length == 0 || amount == 0) {
			return 0;
		}
		int[][] dp = new int[coins.length + 1][amount + 1];
		int row = dp.length;
		int col = dp[0].length;

		for (int i = 0; i < col; i++) {
			dp[0][i] = 9999;// intializing first row to amount +1 instead of integer max value bcoz to avoid
							// overflow exception.
		}
		for (int j = 1; j < row; j++) {
			for (int k = 1; k < col; k++) {
				if (k < coins[j - 1]) {
					dp[j][k] = dp[j - 1][k];
				} else {
					dp[j][k] = Math.min(dp[j - 1][k], 1 + dp[j][k - coins[j - 1]]);
				}
			}
		}
		if (dp[row - 1][col - 1] == 9999)
			return -1;

		return dp[row - 1][col - 1];

	}
}
