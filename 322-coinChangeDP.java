// Time Complexity : 
// Space Complexity : O(N^2)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. I forgot to do +1 to the 1-case while taking min of 1-case and 0-case.

// Your code here along with comments explaining your approach
/**
 *Algo:
 1. First we create the 2d array dp with lengths incremented by +1 (To add 0th column and row)
 2. Then we keep infinity in 0th row from col 1
 3. Iterating over each cell:
        if(amount<denomination):
            take the 0-case i.e value from the above cell
        else:
            take MIN(0-case, 1-case)    //1-case: go denomination number of steps back and add 1 to it

 */
package DP;

public class coinChangeDP {

    public static int coinChange(int[] coins, int amount){

        //edge case
        if(coins == null || coins.length == 0) return -1;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;   //infinity value: we can take 9999, MAXINTEGER-1 etc..the values in the table cannot exceed amount i.e we can keep that also
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){ //amount < denomination
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }

            }

        }
        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result >= 9999) return -1;
        return result ;
    }
    public static void main(String args[]){

        int[] coins = new int[]{2,5};
        int amount = 6;
        System.out.println("Minimum number of coins needed: "+ coinChange(coins, amount));
    }
}
