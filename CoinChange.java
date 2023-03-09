// Time Complexity: O(MxN); where M is the number of denominations and N is the amount
// Space Complexity: O(MxN); where M is the number of denominations and N is the amount


public class CoinChange {
	    public int coinChange(int[] coins, int amount) {
	        int m = coins.length;
	        int n = amount;
	        int [][] dp = new int[m+1][n+1];
	       // if(amount == 0){ return 0;}
	        dp[0][0] = 0;
	        int count = 999999;
	        for (int i = 1; i <= n; i++){
	            dp[0][i] = count;
	        }
	        for(int i = 1; i <= m; i++){ //coins
	            for(int j = 1; j <= n; j++){ //amount
	                if(coins[i-1] > j){
	                    dp[i][j] = dp[i-1][j];
	                }
	                else{
	                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i] [j - coins[i-1]]);
	                }
	            }
	        }
	        if(dp[m][n] >= count){
	            return -1;
	        }
	        else
	            return dp[m][n];
	    }
}
