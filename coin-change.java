// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[coins.length+1][amount+1];
        //filling the first row
        dp[0][0]  = 0;
        for(int i = 1 ;i<= amount; i++){
            dp[0][i]  = 99999;
        }
        //iterating over the dp array and filling the minimum Number of coins to make up the amount at each and every instance.
        for(int i = 1 ;i<= n; i++){
            for(int j = 0 ; j <= amount; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j]; 
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
        }
        }
        //if the last element of the dp array is greater than 99999 that means we cannot make up the amount with the given coins
        if(dp[n][amount]>= 99999){
            return -1;
        }
        //returning the last element of the dp array as it contains the minimum number of coins to make up the amount
         return dp[n][amount];
}
}