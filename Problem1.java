// Time Complexity : O(M*N) - M: length of coins array, N : amount
// Space Complexity :O(M*N) - M: length of coins array, N : amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// 2D matrix approach - 
// for the current amount(e.g. 5) and number of coins(5):
// till 4 dp[i][j] is taken from top as we have already calculated the number of coins for that
//for dp[2][5] : take min from (immediate upper row(coin is not chosen) and [5 steps back of the current row +1(considering the coin is chosen)])
// finally take the last value of the array to get the answer

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        if(coins.length == 0 || coins == null){
            return -1;
        }
        for(int i=0;i<=coins.length;i++){
            dp[i][0] = 0;
        }
        
        for(int j=1;j<=amount;j++){
            dp[0][j] = 99999;
        }
        
        for(int i =1;i<=coins.length;i++){
            for(int j = 1;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        
        return dp[coins.length][amount] == 99999 ? -1 :dp[coins.length][amount];
        
    }
}