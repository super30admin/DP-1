// Time Complexity : O(N*amount)
// Space Complexity : O(N*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
             return -1;
         }
        
        int[][] dp = new int [coins.length+1][amount+1];
        dp[0][0] = 0;
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = amount+1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        
        int result = dp[dp.length-1][dp[0].length -1];
        if (result == amount+1){
            return -1;
        } else 
        return result;
    }
    
    
    
    
    
    
    
//     public int coinChange(int[] coins, int amount) {
//         if(coins.length == 0){
//             return -1;
//         }
//         return coinChangeHelper(coins, amount, 0, 0);
//     }
    
//     private int coinChangeHelper(int[] coins, int amountRemaining, int index, int min){
        
//         //base
//         if(amountRemaining < 0){
//             return -1;
//         }
        
//         if(amountRemaining == 0){
//             return min;
//         }
        
//         if (index > coins.length -1){
//             return -1;
//         }
        
//         //logic
//         int choose = coinChangeHelper(coins, amountRemaining - coins[index], index, min+1);
//         int notChoose = coinChangeHelper(coins, amountRemaining, index+1, min);
        
//         //return
//         if(choose == -1){
//             return notChoose;
//         }
//         if(notChoose == -1){
//             return choose;
//         }
//         return Math.min(choose, notChoose);
//     }
}