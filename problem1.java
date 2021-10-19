// 322 Coin Change
// solved on leetcode
// Time complexity - O(n*2)
// Space complexity - O(n*m)
class Solution {
    public int coinChange(int[] coins, int amount) {
     
        
        int dp[][] = new int [coins.length+1][amount+1];
        
        for(int i=1;i<amount+1;i++){
            dp[0][i]=amount+1;
        }
        for(int i=0;i<coins.length+1;i++){
            dp[i][0]=0;
        }
        
        for(int row=1;row<=coins.length;row++){
            for(int col=1;col<=amount;col++){
                if(coins[row-1]>col){
                    dp[row][col]=dp[row-1][col];
                }else{
                    dp[row][col]=Math.min(dp[row-1][col],dp[row][col-coins[row-1]]+1);
                }
            }
        }
        
        if(dp[coins.length][amount] == amount+1){
            return -1;
        }
        return dp[coins.length][amount];
 
    }
 
     
}
