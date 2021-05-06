// Time Complexity : O(amount*coins)
// Space Complexity : O(amount*coins)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Idea here is to keep track of all the possible options that we come across in the recursive stack.
// we follow a binary approach to find the minimum change required for the given amount.
// Every time we have an option wether to choose the coin or not.
// We take minimum value that we get between the above two options. 
// We repeat this for each and every possible coin that we have up until the given amount.
// finally return the valid minimum change which we obtained.

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0) return 0;
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        // Filling the first row to infinity
        Arrays.fill(dp[0], amount+1);
        
        // Filling the first column to 0
        for(int i=0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(coins[i-1] > j){
                    dp[i][j] =dp[i-1][j];
                }else{
                    dp[i][j] = Math.min((1 + dp[i][j - coins[i-1]]), dp[i-1][j]);
                }
            }
        }
        
        int result = dp[dp.length-1][dp[0].length-1];
        if(result == amount+1) return -1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5,8}, 11));
        System.out.println(coinChange(new int[]{1,2,5,8}, 13));
        System.out.println(coinChange(new int[]{7,2,5,8}, 3));
    }
}