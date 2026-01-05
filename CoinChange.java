// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class CoinChange {

	// Time c omplexity O(m x n)
	// space complexity O(m x n)
	public int coinChange(int[] coins, int amount) {
		// edge case
		if (coins == null || coins.length == 0)
			return 0;
		int[][] dp = new int[coins.length + 1][amount + 1]; // because of 0
		for (int i = 1; i < dp[0].length; i++)
			dp[0][i] = 9999;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < coins[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
				}
			}
		}
		int result = dp[dp.length - 1][dp[0].length - 1];
		if (result >= 9999)
			return -1;
		return result;
	}
	
	/*
	 * 
	 // Time c omplexity O(m x n)
	// space complexity O(m x n)
	 * 
	 public int coinChange(int[] coins, int amount) {
        int m= coins.length, n=amount;
        int [][] dp= new int[m+1][n+1];

        dp[0][0]=0;
        
        // top row
        for (int j=1; j<=n;j++){
            dp[0][j]=Integer.MAX_VALUE-2;
        }

        for (int i=1; i<=m;i++){
            for (int j=1; j<=n;j++){
                if (j<coins[i-1]){
                    //not choose case
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int resp=dp[m][n];
        if (resp>=Integer.MAX_VALUE-2)
          return -1;
        return resp;
    }
    
	 */

}