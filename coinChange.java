// Time Complexity : O(mn) n = amount , m = no of coins
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
APPROACH 1: Brute force exhaustive solution by checking for all the possible solutions resulted due to choosing or not choosing a coin.
APPROACH 2: using the DP array with size of (kinds of coins + 1)x(amount + 1)
dp[i][j] = dp[i-1][j] // not choosing the coin + dp[i][j - coins[i-1]] // choosing the coin
APPROACH 3:
initialise an array of length amount + 1 and fill it with a maximum amount ie amount + 1
Now find the best minimum value for the number of coins for all the amounts starting from 0.
At every step we check, if the usage of this coin makes it smaller for total no of coins or the existing value does.
return the last value in the dp array.
 */

import java.util.Arrays;

public class coinChange {
    public static int coinChange(int[] coins, int amount) {
        //APPROACH 1: Brute force: exhaustive
//         int index = 0;
//         int noOfCoins = 0;

//         return helper(coins, amount, index, noOfCoins);
//     }

//     public int helper(int[] coins, int amount, int index, int noOfCoins){
//         // base case
//         if(amount == 0) return noOfCoins;
//         if(amount < 0 || index == coins.length) return -1;

//         //choose the coin
//         int result1 = helper(coins, amount - coins[index], index, noOfCoins+1);

//         //not choosing the coin
//         int result2 = helper(coins, amount, index+1, noOfCoins);

//         if(result1 == -1) return result2;
//         if(result2 == -1) return result1;

//         return Math.min(result1, result2);
//         }

        //APPROACH 2: Using DP matrix
        int[][] dp = new int[coins.length + 1][amount + 1];

        for(int i = 1; i<dp[0].length; i++){
            dp[0][i] = amount + 1; //setting to infinity
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result > amount) return -1;
        return result;

        // APPROACH 3: Using DP array
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount+1);
//         dp[0] = 0;

//         for(int i = 0; i<=amount; i++){
//             for(int j = 0; j< coins.length; j++){
//                 if(coins[j] <= i){ // can only use a coin once
//                 dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
//                 }
//             }
//         }
//         return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount)); //3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(coinChange(coins2, amount2)); // -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(coinChange(coins3, amount3)); //0
    }
}
