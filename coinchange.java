// Time Complexity : O(A*n) wher A is amount and n is coins count
// Space Complexity : O(A*n) where A is amount and n is coins count
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        
        //first row
        for(int i =0; i< dp[0].length; i++)
            dp[0][i] = amount+1;
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }
        
        int result = dp[dp.length -1][dp[0].length-1];
        if(result >= amount +1)
            return -1;
        return result;
    }
}

/*
Brute Force solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;
        return helper(coins, amount, 0, 0);
    }
    
    public int helper(int[] coins, int amount, int index, int min){
        // base case
        if(amount == 0)
            return min;
        if(amount < 0 || index == coins.length)
            return -1;
        //logic
        // choose the coin
        int case1 = helper(coins, amount-coins[index], index, min + 1);
        // dont choose the coin
        int case2 = helper(coins, amount, index+1, min);
        if(case1 == -1)
            return case2;
        if(case2 == -1)
            return case1;
        return Math.min(case1, case2);
    }
}
*/