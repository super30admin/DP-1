// Time Complexity : O(nXm) we loop through all numbers in nums and amount
// Space Complexity : O(nXm) size of dp array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null) return -1;

        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i <= amount; i++){
            dp[0][i] = amount+1;
        }

        for(int i = 1; i < coins.length+1; i++){
            for(int j = 1; j < amount+1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        return dp[coins.length][amount] < amount + 1 ? dp[coins.length][amount] : -1;

    }
}
