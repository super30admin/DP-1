//Problem: Coin Change
// Time Complexity : Time limit exceede. O(2^(amount+coins))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Exhaustive Solution

class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = helper(coins, 0, amount);
        if(result >= Integer.MAX_VALUE -10)
            return -1;
        else{
            return result;
        }
    }

    private int helper(int[] coins, int idx, int amount){
        //base cases
        //leaf node having amount 0 -> this is valid path
        if(amount == 0)
            return 0;
        
        //leaf node having ammount negative -> this non valid path
        //no coins left then index goes out of bounce 
        if(amount < 0 || idx == coins.length)
            return Integer.MAX_VALUE -10;   // this is to avoid Integer overflow

        //logic
        //don't choose coin
        int case1 = helper(coins, idx+1, amount);
        
        //choose coin
        int case2 = 1 + helper(coins, idx, amount-coins[idx]);
        
        return Math.min(case1, case2);
    }
} 

//Problem: Coin Change
// Time Complexity : O(amount*coins)
// Space Complexity : O(amount*coins)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Using DP - 2D Matrix
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = amount;
        int n =coins.length;
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int j= 1; j <=m ; j++){
            dp[0][j] = Integer.MAX_VALUE - 10;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                //till amount < denom of curr coin
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[n][m] >= Integer.MAX_VALUE - 10)
            return -1;
        else{
            return dp[n][m];
        }
    }
}