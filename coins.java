// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class coinChangeSolution {
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        //initialize first row 
        for (int i = 1; i <=amount; i++) {
            dp[0][i] = amount + 1; // amount+1 is infinity value 
        }
        
        //initialize first column
        for (int i = 0; i <=coins.length ; i++) {
            dp[i][0] = 0;
        }
        
        for (int row = 1; row <= coins.length; row++) {
            for (int column = 1; column <= amount; column++) {
            //check sum > denomination, if yes then copy previous value
                if (coins[row-1] > column) {
                    dp[row][column] = dp[row-1][column];
                }
                else {
                    dp[row][column] = Math.min(dp[row-1][column], dp[row][column - coins[row-1]] + 1);
                }
            }
        }
        
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount]; 
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5};
        int amount = 7; 
        int result ;
        result = coinChange(coins, amount);
        System.out.println(result);
    }
}
