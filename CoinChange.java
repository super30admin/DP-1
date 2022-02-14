/*
             SC                                   TC
Rec    O(amount/min denomination)      2^ (amount/min denomination)

Top down   O(a*no. of denomination)                      O(a*no. of denomination)
*/

class Solution {

    private int[][] dp = new int[12][10001];

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        int ans = coinChange(coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int coinChange(int[] coins , int index , int amount)
    {
        //base
        if (amount == 0)
        {
            return 0;
        }
        if (amount < 0 || index==coins.length )
        {
            return Integer.MAX_VALUE;
        }

        if(dp[index][amount] > 0)
        {
            return dp[index][amount];
        } // not seeing for the first time


        //recurse
        //not choose
        int nChooseAns = coinChange(coins, index+1, amount);
        //choose
        int chooseAns = coinChange(coins, index , amount-coins[index]);

        if(chooseAns != Integer.MAX_VALUE)
        {
            chooseAns += 1;
        }

        dp[index][amount] = Math.min(chooseAns , nChooseAns);

        return dp[index][amount];
    }
}