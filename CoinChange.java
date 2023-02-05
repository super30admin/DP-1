import java.util.Arrays;

// Time complexity - O(m*n),  m is (coins+1) and n is (amount+1)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

// DP approach. create a 2d array with amount+1 columns and coins.length+1 rows.
// add first row as infinite or amount +1 
// we don't have to calculate first row as it always be zero and default value for int array for java is 0
// use nested for loop to get the value as below
// for sum < coin case copy value from above
// else add minimum value of one step above and coin steps back 

// array for [1,2,5] and amount 11
//[0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] 
//[0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6]
//[0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {

		int m = coins.length;
		int n = amount;

		int[][] dp = new int[m + 1][n + 1];

		dp[0][0] = 0;

		for (int j = 1; j < dp[0].length; j++) {
			// we are considering amount+1 as infinite as it will integer out of bound
			// exception when we are try to add for Integer.Max
			dp[0][j] = amount + 1;
		}

		// we already made i=0 row, dp[0][0] as 0 and remaining as infinite
		for (int i = 1; i < dp.length; i++) {
			// as j = 0 column is zero we are not prefilling it
			for (int j = 1; j < dp[0].length; j++) {
				if (j < coins[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				}
			}
		}

		int result = dp[m][n];

		if (result > amount) {
			return -1;
		}
		System.out.println("dp array" + Arrays.deepToString(dp));

		return result;

	}

	public static void main(String args[]) {
		int[] coins = { 1, 2, 5 };
		coinChange(coins, 11);
	}

//	coinChange Exponential TC - O(2^(m+n)) where m is number of coins and n is amount 

	public int coinChangeExponential(int[] coins, int amount) {
		if (coins == null || coins.length == 0)
			return 0;
		return helper(coins, amount, 0, 0);
	}

	private int helper(int[] coins, int amount, int i, int min) {
		// base
		if (amount == 0)
			return min;
		if (i == coins.length || amount < 0)
			return -1;
		// logic
		// case1 choose
		int case1 = helper(coins, amount - coins[i], i, min + 1);
		int case0 = helper(coins, amount, i + 1, min);

		if (case1 == -1)
			return case0;
		if (case0 == -1)
			return case1;

		return Math.min(case1, case0);
	}

}
