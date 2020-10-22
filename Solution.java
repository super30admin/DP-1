// Time Complexity : if amount = m and no of coins=n the time complexity O(m*n) double looping
// Space Complexity : O(m) but still not sure about this
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no problems so far


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {

        if(coins==null||coins.length==0)
            return 0;

        int[][] dp=new int[coins.length+1][amount+1];
        //row as amount and coins as coloumns 1 extra for 0 column and inifity row

        for(int j=1;j<dp[0].length;j++)
            dp[0][j]=9999;//Amount+1 as inifity so that it never reaches the max value

        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }

        int result = dp[dp.length-1][dp[0].length-1];

        if(result>=9999)
            return -1;

        return result;
    }
}