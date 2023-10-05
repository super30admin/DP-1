// Time Complexity : O(2 ^ (m+n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


// Your code here along with comments explaining your approach
// DP-1
// Problem1 (https://leetcode.com/problems/coin-change/)
// Brute force approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        //Brute force soultion
        return helper(coins, 0, amount, 0);
    }
    private int helper(int[] coins, int index, int amount, int coinUsed){
        //base case
        if(amount == 0) return coinUsed;
        if(amount < 0 || index == coins.length) return -1;
        //logic
        //choose
        int case1 = helper(coins, index, amount - coins[index], coinUsed+1 );
        //not choose
        int case2 = helper(coins, index+1, amount, coinUsed);
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
        
    }
}
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


// Your code here along with comments explaining your approach
// DP-1
// Problem1 (https://leetcode.com/problems/coin-change/)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int j=0; j<= n; j++){
            dp[0][j] = Integer.MAX_VALUE - 100;
        }
        for(int i=1; i<= m; i++){
            for(int j=1; j<= n; j++){
                if(j < coins[i-1]){
                   dp[i][j] =  dp[i-1][j];
                }else{
                    dp[i][j] =  Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }      
        }
        }
        if(dp[m][n] >= Integer.MAX_VALUE - 100) return -1;
        return dp[m][n];
        
    }
}