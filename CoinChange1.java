// Time Complexity : O(n^2) + O(nlog(n)) ~ O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class CoinChange1 {
    public static int coinChange(int[] coins, int amount) {
        // Sorting the coins array
        Arrays.sort(coins);

        // Initializing an DP array to store min coins required for that amount
        int[] dp = new int[amount+1];

        // Filling DP array with out of the limit value
        Arrays.fill(dp, amount+1);

        // Initializing the first element
        dp[0] = 0;

        // for i cents till equals to amount cents
        for(int i=1; i <= amount; i++){

            // From coin number 0 to coin number max
            for(int j = 0; j < coins.length; j++){

                // If count at location j is greater than amount i,  break
                // Else calculate minimum between (if this coin is taken, add 1 to the minimum number coins required for
                // the mount i - weight of the count just taken
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                } else {
                    break;
                }
            }
        }

        // If the final value in amount has not been changed, then lowest is not possible, return -1, else return dp[amount]
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String args[]){
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

    }
}
