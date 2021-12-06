//Time Complexity : O(amount * coins.length)
//Space Complexity : O(amount * coins.length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0; // if coins is null or coins length is zero return
        int[][] dp = new int[coins.length + 1][amount + 1]; // initialize a dp array to store store values
        //the array length would be the amout + 1 as we zero also into consideration and rows woudl be the number of coins + 1 as we take zero also into consideration
        for(int i = 1; i <= amount ; i++)
            dp[0][i] = amount + 1;
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }
        if(dp[coins.length][amount] > amount)
            return -1;
        else
            return dp[coins.length][amount];
    }
}
