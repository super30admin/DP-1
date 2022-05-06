// Time Complexity : O(M*N)
// Space Complexity :  O(M*N)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        //a matrix for coins and amount 
        int [][] dp = new int[coins.length+1][amount+1];
        //dummy array with 0 and amount + 1 because it can never be more than amount
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount+1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //if amount < coins
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        //result is stored in last row and last column element
        int result = dp[dp.length -1][dp[0].length-1];
        if(result==amount+1) return -1;
        return result;
    }
}