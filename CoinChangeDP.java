// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int coinChange(int[] coins, int amount) {
        //null case
        if(coins.length == 0 || amount == 0)
            return 0;
        int dp[][] = new int[coins.length + 1][amount + 1];
        //first column
        for(int i = 0;i < dp.length;i++)
            dp[i][0] = 0;
        //first row
        for(int j = 1;j < dp[0].length;j++)
            dp[0][j] = amount + 1;
        for(int i = 1;i < dp.length;i++)
            for(int j = 1;j < dp[0].length;j++){
                //zero case
                if(j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                //Min of zero case and one case
                else
                    dp[i][j] = Math.min(dp[i - 1][j],1 + dp[i][j - coins[i - 1]]);
            }
        //if result greater than amount, result not possible
        return dp[dp.length - 1][dp[0].length - 1] <= amount?dp[dp.length - 1][dp[0].length - 1]:-1;
    }
}