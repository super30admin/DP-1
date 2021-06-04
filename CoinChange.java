// Time Complexity : O(m * n) where m is the length of the coins array and n is the amount.
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// 1. Recursive Approach (Exhaustive approach)

class Solution {
    public int coinChange(int[] coins, int amount) {
        // recursive approach
        return helper(coins, amount, 0, 0);
    }
    
    private int helper(int[] coins, int amount, int index, int coin_count) {
        // base case
        
        // if the amount becomes negative --> it is an invalid path
        // we return -1
        
        if(amount < 0 || index == coins.length)  {
            return -1;
        }
        
        // when the amount becomes 0 --> it is a valid path
        // we return the coins
        if(amount == 0) {
            return coin_count;
        }
        
        // logic
        
        // don't choose a coin
        int case1 = helper(coins, amount, index+1, coin_count);
        
        // choose a coin
        int case2 = helper(coins, amount - coins[index], index, coin_count + 1);
        
        if (case1 == -1) return case2;
        if (case2 == -1) return case1;
        
        return Math.min(case1, case2);
    } 
}

// 2. Dynamic Programming approach

/**
 * For Every coin, we either take a decision of choosing the coin or not choosing the coin
 * we construct the dp matrix to store the results of minimum number of coins.
 * if coin denomination is more than the amount, we take the 0 case
 * otherwise, we take the minimum of 0 case and 1 + (1 case).
 */


class Solution1 {
    public int coinChange(int[] coins, int amount) {
            
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // Fill first column to 0;
        for (int i=0;i<dp.length;i++) {
            dp[i][0] = 0;
        }
        
        // First first row to infinity of maximum number possible
        // In this case the maximum coins can be maximum value;
        for (int j=1;j<dp[0].length;j++) {
            dp[0][j] = amount + 1;
        }
        
        // Logic
        for(int i=1;i<dp.length;i++) {
            for (int j=1;j<dp[0].length;j++) {
                // Here i is the index starting from 1 but coins has still index from 0;
                // j represents the amount
                if (coins[i-1] > j) {
                    // coin has denomination higher than the amount
                    // we just consider the 0 case or not chooosing case
                    dp[i][j] = dp[i-1][j];
                } else {
                    // coin denomination is less than the amount
                    // we take the minimum of the 0 case and the 1 case
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        
        int result =  dp[dp.length - 1][dp[0].length - 1];
        
        if (result > amount) {
            // invalid cases
            return -1;
        }
        
        return result;
    }
}
