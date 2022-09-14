// Problem1 - https://leetcode.com/problems/coin-change/submissions/

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding base cases

public class problem1 {
            if(coins.length == 0 || coins == null) return 0;
        
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=0;
        
        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = amount + 1;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[m][n];
        if(result > amount) return -1;
        return result;
}
