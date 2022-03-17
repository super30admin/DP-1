// Time Complexity : O(nxm)
// Space Complexity : O(nxm)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int coinChange(int[] coins, int amount) {

        //explaination in March 9 class, we use dp matrix because there are 2 constraints -
        //amount and denominations

        //calculate dimension of dp matrix
        int rows = coins.length;
        int cols = amount;

        //we keep a dummy row for denomination 0 and dummy col for amount 0
        int[][] dp = new int[rows+1][cols+1];

        //fill the first row
        for(int j=1; j<dp[0].length; j++)
            dp[0][j] = amount+1;
        //choose this instead of max integer value to avoid overflow, we might end up doing infinty+1, can also use big value like 999

        //no need to fill first col, already set to 0 by default

        //start filling dp matrix

        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                //current denomination row being filled right now
                int cd = coins[i-1];
                //i-1 becuase we start matrix with 0 but actual array has a valid denomination

                //we fill using top cell till cd is greater than col value (i.e., amount)
                if(cd>j)
                    dp[i][j] = dp[i-1][j];

                //then we take min of value above and value cd cols back + 1
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-cd]);
            }
        }

        int result = dp[dp.length-1][dp[0].length-1];

        if(result>amount) //infinity
            return -1;
        else
            return result;
    }
}
