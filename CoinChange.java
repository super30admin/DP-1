// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//time O(n)
//space O(n)

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return 0;
        }

        int [][] dp = new int[coins.length + 1][amount + 1];

        //first row 
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //if coin amount is less than current column amount
                if(coins[i - 1] > j){
                    //bring down value from above row
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //compare value from above row to the min from 1 coin denomination previous + 1
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j - coins[i - 1]] + 1);
                }
            }
        }


        if(dp[coins.length][amount] > amount){
            return -1;
        }

        return dp[coins.length][amount];
    }
}
