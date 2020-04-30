// Time Complexity : O(mn) where m is the denomination value and n is the number of coins 
// Space Complexity : O(mn) auxilary array to keep the intermediate results
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding the pattern here
/* Your code here along with comments explaining your approach: go for Tabulation. Store the first row with infinity. Calculate the
possibilities for all the coins, starting for ith coin and how that coin can reach denomination value. If the coin value is greater than the
denomination value then we store the previous row result else we store the minimum of previous row and the aggregation of the coin itself with the 
coins[i] steps backward, we get the value and store it. Display the last value as the result. */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1]; // starts with 0 hence add 1
        for(int i =  0; i< dp[0].length; i++){
            dp[0][i] = 9999;    // filling with infinity
        }
        for(int i  = 1 ; i< dp.length; i++){                    // Coins
            for(int j  = 1; j <dp[0].length; j++){              // Denominations
                if(j >= coins[i-1]){
                dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]); // Store the min of previous row value and the aggregation of previous row and ith steps backward value
            } else {
                dp[i][j] = dp[i-1][j];          // If denomination value is lesser than the coins value, only store the previouos row value
            }
        }
    }
    if(dp[dp.length-1][dp[0].length-1] >= 9999){        // If infinity retured as result, return -1
        return -1;
    } else {
        return dp[dp.length-1][dp[0].length-1];             // Return the last value thats the number of coins required.
    }
                                    }
                }