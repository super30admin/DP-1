// Time Complexity :O(number of coins * amount)
// Space Complexity : O(number of coins * amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No




class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // edge
        if(coins.length == 0 || coins == null ) return 0;
        
        // create grid with coins.length+1 rows and amount + 1 columns
        int[][] dp = new int[coins.length+1][amount + 1];
        
        int m = dp.length; int n = dp[0].length;
        
        // set first row, from second element to 9999
        for(int j=1;j<n;j++){
            dp[0][j] = 9999;}
        
        // iterate through second row, second column
        for(int i =1;i<m;i++){
            for(int j=1;j<n;j++){
                
                // case of not choosing, copy result of above sub problem
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                // case of choosing, min(above,steps back = value of current coin)
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        
        // edge case
        if(dp[m-1][n-1]>=9999) return -1;
        
        // return last element of grid
        return dp[m-1][n-1];
        
        
    }
}