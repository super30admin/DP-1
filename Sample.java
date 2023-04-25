// Time Complexity : O(amount * n)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to look for syntax in the return statement because I wanted to check and return at the same time


// Your code here along with comments explaining your approach

## Problem1 (https://leetcode.com/problems/coin-change/)


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];                 //integer array dp of size amount + 1
        Arrays.fill(dp, Integer.MAX_VALUE);             //sets all elements of the dp array to Integer.MAX_VALUE
        dp[0] = 0;                                      //  all elements of dp are set to infinity except dp[0] which is set to 0

        for (int coin : coins) {                                    // iterates through each coin in the coins array
            for (int i = coin; i <= amount; i++) {                  // iterates through each possible amount i that can be made up using the current coin denomination
                if (dp[i - coin] != Integer.MAX_VALUE) {            // checks whether we can make up the amount i using the current coin denomination
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);      //If we can make up the amount i - coin using the previous coins, then we can use the current coin to make up the amount i by adding 1 to the minimum number of coins
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];   //check whether dp[amount] is equal to Integer.MAX_VALUE and returns the minimum number of coins needed to make up the amount 'amount' or '-1'
    }
}

## Problem2 (https://leetcode.com/problems/house-robber/)

// 1st Approach

// Time Complexity - 0(n) because the method uses a single loop that iterates through each element of the input array exactly once
// Space Complexity - 0(n) because it creates a 2D array of size nums.length

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {              // base case
            return 0;
        }
        int[][] dp = new int[nums.length][2];               // using a dp array with row nums.length and column 2
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {      
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);        
            dp[i][1] = dp[i - 1][0] + nums[i];                             
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);    // return max of 0 and 1
    }
}


// 2nd Approach

// Time Complexity - 0(n) because the method uses a single loop that iterates through each element of the input array exactly once.
// Space Complexity - 0(1) because algorithm does not use any additional data structures or arrays, it only stores two variables (skip and take) to keep track of the maximum values.

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {              // base case
            return 0;
        }
        int skip = 0;                                       
        int take = nums[0];

        for (int i = 1; i < nums.length; i++) {      
            int temp = skip;                              // store skip in temp as it will get updated
            skip = Math.max(skip, take);                  // maximum between the old skip value and take 
            take = temp + nums[i];         
        }
        return Math.max(skip, take);
    }
}