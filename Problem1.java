//Time complexity - O(n^2)
//Space complexity - O(n)
//All test cases passed
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0)
            return -1;

        int[][] dp = new int[coins.length+1][amount+1];

        for(int j=0; j<dp[0].length; j++)
            dp[0][j] = amount+1;

        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                if(coins[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
            }
        }

        int result = dp[dp.length-1][dp[0].length-1] > amount ? -1 : dp[dp.length-1][dp[0].length-1];

        return result;
    }


}