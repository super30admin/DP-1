// TC - O(m*n)
//SC - O(m*n)

public class CoinChange_DP {
	public static int coinChange(int[] coins, int amount) {
		int row = coins.length + 1;
		int column = amount + 1;
		int max = 99999;
		int[][] dp = new int[row][column];
		for (int i = 1; i < column; i++)
			dp[0][i] = max;

		for (int r = 1; r < row; r++) {
			for (int c = 1; c < column; c++) {
				if (c < coins[r - 1])
					dp[r][c] = dp[r - 1][c];
				else {
					int first = dp[r - 1][c];
					int second = dp[r][c - coins[r - 1]];
					System.out.println(first);
					System.out.println(second);
					dp[r][c] = Math.min(first, second + 1);
				}

			}
		}
		return (dp[row - 1][column - 1] >= max) ? -1 : dp[row - 1][column - 1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 5 };
		int amount = 6;
		int output = coinChange(nums, amount);
		System.out.println(output);
	}

}
