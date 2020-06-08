/**
Time complexity : O(n*m) n= no of elements in coins m = amount
Space complexity : O(n) n = new dp array of n elements
Did it run on Leetcode : yes
 */


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length<1 || coins == null){
            return -1;
        }
        int dp[][] = new int [coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 9999-1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
       int result = dp[dp.length-1][dp[0].length-1]; 
        return result==9999-1?-1:result;
       
    }
}