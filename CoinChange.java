// Time Complexity : O(m * n) [m = amount, n = coins.length]
// Space Complexity : O(m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes, Not able to determine base case, had to watch video multiple no. of times


// Your code here along with comments explaining your approach

import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        // int result = helperRecursion(coins, amount);
  
        // int[] dp = new int [amount + 1];
        // Arrays.fill(dp, -1);
        // int result = helperMemoization(coins, amount, dp);

        int result = helperTabulation(coins, amount);


        return result == Integer.MAX_VALUE ? -1 : result; 
    }

    // private int helperMemoization(int[] coins, int amount, int [] dp) {
    //     if (amount == 0) {
    //         return 0;
    //     }

    //     if (amount < 0) {
    //         return Integer.MAX_VALUE;
    //     }

    //     if(dp[amount] != -1) {
    //         return dp[amount];
    //     }

    //     int mincoins = Integer.MAX_VALUE;

    //     for (int i = coins.length -1; i >= 0; i--) {
    //         int ans = helperMemoization(coins, amount - coins[i], dp);
    //         if (ans != Integer.MAX_VALUE) {
    //             mincoins = Math.min(mincoins, ans + 1);
    //         }
    //     }
       
    //     dp[amount] = mincoins;
    //     return mincoins;
    // }

    // private int helperRecursion(int[] coins, int amount) {
    //     if (amount == 0) {
    //         return 0;
    //     }

    //     if (amount < 0) {
    //         return Integer.MAX_VALUE;
    //     }

    //     int mincoins = Integer.MAX_VALUE;

    //     for (int i = coins.length -1; i >= 0; i--) {
    //         int ans = helperRecursion(coins, amount - coins[i]);
    //         if (ans != Integer.MAX_VALUE) {
    //             mincoins = Math.min(mincoins, ans + 1);
    //         }
    //     }
    //     return mincoins;
    // }

    private int helperTabulation(int[] coins, int amount) {
        //Initalize array dp with length of amount + 1, since need to figure out no. of coins for base case ZERO
         int[] dp = new int [amount + 1];
         //Initialized intially with Max value 
         Arrays.fill(dp, Integer.MAX_VALUE);

         //Base case
         dp[0] = 0;

         //Need to start from amount = 1 to amount = amount
         for (int i = 1; i <= amount; i++ ) {
            //Need to choose all possible ways to utilize the coin
             for(int j = 0; j < coins.length; j++ ) {
                //Added checks so amount is not less than ZERO and In dp[idx] value is not greater than MAX value (Integr Over Flow)
                 if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    //For every ith Idx amount in the dp the answer depends on amount ith idx - current coin selected and min value is considered
                     dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                 }
             }
         }

         return dp[amount];
    }
}