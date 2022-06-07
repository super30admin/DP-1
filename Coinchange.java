// Time Complexity : O(mxn) where m is the different denominations of coins and n is the amount
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[m][n] >= amount + 1) return -1;
        return dp[m][n];
        
    }
}
    

/* Recursive method
class Solution {
    public int coinChange(int[] coins, int amount) {
        //null
        return helper(coins, 0, amount, 0);
    }
    private int helper(int[] coins, int i, int amount, int minCoins){
        if (amount == 0) return minCoins;
        if (amount < 0 || i == coins.length) return -1; 
        //min no of coins if I choose Ith coin at this point
        int case1 = helper(coins, i, amount-coins[i], minCoins + 1);
        // No choose case
        int case2 = helper(coins, i+1, amount,minCoins);
        // case1 or case2 are negative
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
    }
}*/
