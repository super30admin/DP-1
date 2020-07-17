// Time Complexity : O(T/min(coins))
// Space Complexity : O(T/min(coins))
// Did this code successfully run on Leetcode : yes but TLM
// Any problem you faced while coding this : none


//Recursive Solution

class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }
    
    private int helper(int[] coins, int amount, int index, int totalCoin){
        if(index>=coins.length || amount<0)
            return -1;
        if(amount == 0)
            return totalCoin;
        
        int num1 = helper(coins, amount, index+1, totalCoin); //if we dont choose the coin
        int num2 = helper(coins, amount-coins[index], index, totalCoin+1); // if we choose the coin
        
        if(num1==-1) return num2;
        if(num2==-1) return num1;
        
        else return Math.min(num1, num2);
    }
}



// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none



//DP Solution

class Solution {
    public int coinChange(int[] coins, int target) {
        int[][] dp = new int[coins.length+1][target+1];
        
        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = 9999;
        }
        
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++)
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
        }
        
        int output = dp[coins.length][target];
        if(output>=9999)
            return -1;
        else return output;
    }
}