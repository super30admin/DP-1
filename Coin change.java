// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
    //     int result = calculateCoins(coins, amount, 0, 0);
    //     if(result == Integer.MAX_VALUE){
    //         return -1;
    //     }
    //     return result;
    // }
    // private int calculateCoins(int[] coins, int sum, int count, int index){
    //     if(sum == 0){
    //         return count;
    //     }
    //     if(sum < 0 ){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(index == coins.length){
    //         return Integer.MAX_VALUE;
    //     }
    //     int taken = calculateCoins(coins, sum - coins[index], count+1, index);
    //     int notTaken = calculateCoins(coins, sum - 0, count , index +1);
    //     return Math.min(taken, notTaken);
    // }
    
        int[][] dp = new int[coins.length+1][amount+1];
        
        //Initialize first column
        for(int i = 1; i <= coins.length; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= amount ; i++){
            dp[0][i] = amount+1;
        }
        for(int row = 1; row <= coins.length; row++){
            for(int column = 1; column <= amount; column++){
                if(coins[row-1] > column){
                    dp[row][column] = dp[row-1][column];
                }
                else{
                    dp[row][column] = Math.min(dp[row-1][column], 
                                               1 + (dp[row][column-coins[row-1]]));
                }
            }   
        }
        if(dp[coins.length][amount]> amount){
            return -1;
        }
        return dp[coins.length][amount];
    }
}
    
        
