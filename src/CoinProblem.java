// Time Complexity:     O(amount/minimum_denomination)
// Space Complexity:    O(2^(amount/minimum_denomination))
// where n is length of given array
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

package src;

import java.util.Arrays;

public class CoinProblem {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        CoinSolution cs = new CoinSolution();
        System.out.println(cs.coinChange(coins, amount));
    }
}

class CoinSolution
{
    int[][] dp;
    public int coinChange(int[] coins, int amount)
    {
// ****************************** Another Approach ******************************
//        long[] dp = new long[amount+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for(int i=0; i<coins.length; i++)
//        {
//            int coin=coins[i];
//            for(int j=coin; j<=amount; j++)
//            {
//                dp[j] = Math.min(dp[j],dp[j-coin]+1);
//            }
//        }
//
//        return dp[amount]==Integer.MAX_VALUE ? -1 : (int)dp[amount];

        dp = new int[coins.length][amount+1];
        int ans = coinChange(coins, 0, amount);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    private int coinChange(int[] coins, int i, int amount)
    {
        if(amount == 0)                                                             // if amount is made out of this way
            return 0;
        else if(amount < 0 || i == coins.length)                                    // if amount can't be made out of this way
            return Integer.MAX_VALUE;

        if(dp[i][amount] > 0)
            return dp[i][amount];

        int notChoose = coinChange(coins, i+1, amount);                           // not considering current coin

        int choose = coinChange(coins, i, amount-coins[i]);                  // considering current coin

        if(choose != Integer.MAX_VALUE)                                             // if this path gives you coin to be included
            choose++;

        return dp[i][amount]=Math.min(notChoose,choose);                            // keep minimum value out of two paths
    }
}