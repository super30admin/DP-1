// Time Complexity : O(m*n) m=amount , n=no. of coins
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes0
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0){
            return -1;
        }
        int dp[][] = new int[coins.length+1][amount+1];
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = amount+1;//initialise array with infinity for 0
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){//check both decisions
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[dp.length-1][dp[0].length-1];
        return result = result>=amount+1?-1:result;
    }
}