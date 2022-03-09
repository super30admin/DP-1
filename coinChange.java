// Time Complexity : O(mn) n = amount , m = no of coins
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
initialise an array of length amount + 1 and fill it with a maximum amount ie amount + 1
Now find the best minimum value for the number of coins for all the amounts starting from 0.
At every step we check, if the usage of this coin makes it smaller for total no of coins or the existing value does.
return the last value in the dp array.
 */

import java.util.Arrays;

public class coinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 0; i<=amount; i++){
            for(int j = 0; j< coins.length; j++){
                if(coins[j] <= i){ // can only use a coin once
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
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
