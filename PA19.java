// Where m is no of coins and n is the amount
// Space O(m*n) ===O(n^2)
//Time O(m*n) ===O(n^2) 


class Solution {
    public int coinChange(int[] coins, int amount) {
        
          if(coins==null || coins.length ==0){
              return -1;
          }
        
        int dp[][]= new int[coins.length+1][amount+1];
      
        
        for(int i =0 ;i<=amount; i++){
            dp[0][i]= 9999;                
        }
        for(int i =1 ;i<dp.length; i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                     dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }                
            }         
        }
        if(dp[coins.length][amount]==9999){
            return -1;
        }
        return dp[coins.length][amount];
    }
}