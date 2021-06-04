//runtime complexity O(mn) ---> n is size of coins, m is size of amount
//space complexity O(mn) --->  n is size of coins, m is size of amount
class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<dp.length; i++){
                dp[i][0] = 0;
            }
        for(int i=1; i<dp[0].length; i++){
            dp[0][i] = amount + 1;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
                
            }
            
        }
        int sol = dp[dp.length-1][dp[0].length-1];
        if(sol > amount){return -1;}
        else{return sol;}
    }  
}