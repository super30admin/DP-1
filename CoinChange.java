/* Time Complexity : O(m*n) - Matrix
 * 	m - length of the input array - coins
 *  n - amount*/
/* Space Complexity : O(m*n)
 * 	m - length of the input array - coins
 *  n - amount */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DP solution
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        //initializing dummy row to infinity or max value
        for(int j = 1;  j<= n; j++){
            dp[0][j] = Integer.MAX_VALUE - 2;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <=n; j ++){
                if(j < coins[i -1]){ // amount is less than the coin denomination
                	//previous row
                	dp[i][j] = dp[i-1][j];
                }
                else{
                	//Min of (previous row (same column) , (same row) curr. amt - denomination of the coin)
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[m][n] >= Integer.MAX_VALUE - 2) return -1;
        return dp[m][n];
    }
}


/*
 
 /* Time Complexity : O(2^(m+n))
 * 	m - length of the input array - coins
 *  n - amount*/
/* Space Complexity : O(m*n)
 
 
 //Exhaustive Solution
 
 class Solution {
    public int coinChange(int[] coins, int amount) {
        int noOfCoins = helper(coins, 0, amount, 0);
        if(noOfCoins == Integer.MAX_VALUE) return -1;
        return noOfCoins;

    }

    private int helper(int[] coins, int index, int amount, int coinsUsed){
        
        //base case
        if(amount == 0) return coinsUsed;
        if(amount < 0 || index >= coins.length) return Integer.MAX_VALUE;

        //When we choose the coin
        int case1 = helper(coins, index, amount - coins[index], coinsUsed + 1);
        //When we do not choose the coin
        int case2 = helper(coins, index + 1, amount, coinsUsed);

        return Math.min(case1, case2);

    }
}*/
