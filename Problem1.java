/*
 * Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(amount * coins)
* 
* Space Complexity: O(amount) + O(coins) == O(amount)
                    
 */

 class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0], n+1);
        dp[0][0] = 0;
        for(int i = 1; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                //till amount is lesser than denominators
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        int re = dp[m][n];
        if(re >=  n+1 ) return -1;
        return re;
    }
}