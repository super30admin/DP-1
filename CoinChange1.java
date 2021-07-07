
// Time Complexity : O(n^2), n is number of coins and amount
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        
//         return helper(coins, 0 , 0,amount);
//     }
    
//     public int helper(int[]coins,int index,int count,  int amount){
//         if(amount == 0){
//             return count;
//         }
//         if(amount < 0 || index >= coins.length){
//             return -1;
//         }
        
//         //choose the coin
//         int case1 = helper(coins,index,count+1,amount-coins[index]);
        
//         //do not choose
//         int case2 = helper(coins,index+1,count,amount);
        
//         if(case1 == -1)return case2;
//         else if(case2 == -1)return case1;
        
//         else return Math.min(case1,case2);
//     }
        
        int[][]dp = new int[coins.length+1][amount+1];
        
        for(int c =1;c <= amount;c++){
            dp[0][c] = 99999;
        }
        for(int i =0; i<= coins.length;i++){
            dp[i][0]=0;
        }
        
        for(int i = 1;i <= coins.length;i++){
            for(int j= 1;j <= amount;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j - coins[i-1]]);
                }
            }
        }
    
        if(dp[coins.length][amount] >= 99999){
            return -1;
        }
    return dp[coins.length][amount];
}
}
