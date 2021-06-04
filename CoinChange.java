// Time Complexity : O(S * n) //S is amount and n is coins length
// Space Complexity : O(S * n) //dp array size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * 1. Form a DP table with multi dimensional array.
 * 2. For every coin there will be 2 options choose or not to choose. 
 * 3. If not chosen coin will be removed and sum will be same.
 * 4. If chosen coin considered again and sum reduces by coin amount. 
 */

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		
		if(coins==null || coins.length<1) {
			return -1;
		}

		int[][] dp = new int[coins.length + 1][amount + 1];

		// first column in each row will be always zero.
		for (int row = 0; row < dp.length; row++) {
			dp[row][0] = 0;
		}

		// first row is always infinity or amount+1
		for (int col = 0; col < dp[0].length ; col++) {
			dp[0][col] = amount + 1;
		}
		
		for(int row = 1;row<dp.length;row++) {
			for(int col=1;col<dp[0].length;col++) {
				
				//zero case. coin not chosen
				if(col<coins[row-1]) {
					dp[row][col]=dp[row-1][col];
				}else {
				//non zero case. coin chosen
					dp[row][col]=Math.min(dp[row-1][col], 1+dp[row][col-coins[row-1]]);
				}
			}
		}
		
		int result = dp[dp.length-1][dp[0].length-1];
		if(result>amount) {
			return -1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] coins=new int[] {1,2,5};
		System.out.println(new CoinChange().coinChange(coins, 11));
	}
}
