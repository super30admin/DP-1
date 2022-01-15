// Greedy Solution will not give Guaranteed Solution. 

// Exhaustive - Recursive Solution
// Time Complexity = O[2^m+n] where m is length of coins array and n is equal to amount
// Space Complexity = O[1] No Extra Space used.

class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(amount,coins,0,0);
    }
    private int helper(int amount, int[] coins, int index, int count){
        //base condition
        if(amount==0) return count;
        if(amount<0 || index == coins.length) return -1;
        //Logic
        //Choose
        int case1 = helper(amount - coins[index], coins, index, count+1);
        //Not Choose
        int case2 = helper(amount, coins, index+1, count);
        if(case1==-1) return case2;
        if(case2==-1) return case1;
        return Math.min(case1, case2);
    }
}

// DP Approach
// Form a matrix to store possible values from the denominations
// Check for min between the row just above it and the value of no of coins in case-coin denomination occoured just before
// Fill the matrix and the last value will give you the min number of coins used
// While choosing the coins always go for bottom up approach. 

// Time Complexity O(m*n) 
// Space Complexity O(m*n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 0;
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i< dp.length;i++){
            for(int j = 1; j< dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        int result = dp[dp.length-1][dp[0].length-1];
        if(result>amount) return -1;
        return result;
    }
}