  
// Time Complexity : O(n) where n is the length of the coins array
// Space complexity : O(n*m) where n is the lenght of coins array and m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
            dp[i][0] = 0;
        for(int i=0;i<=amount;i++)
            dp[0][i] = 10001;
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);                
            }
        }
        return dp[coins.length][amount] != 10001 ? dp[coins.length][amount] : -1;
    }
}

// Approach 2 -  Using 1D array instead of 2D array, saves space complexity from O(n*m) to O(n)
/* 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }
} 
*/
