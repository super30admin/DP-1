// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0){
            return 0;
        }
        
        int[][] matrix = new int[coins.length+1][amount+1];
        
        for(int j = 1; j <= amount; j++) {
            matrix[0][j] = amount+1;
        }
        
        for( int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j < coins[i - 1]) {
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j - coins[i-1]] + 1);
                }
            }
        }
        
        if(matrix[coins.length][amount] == amount+1) {
            return -1;   
        } else {
              return matrix[coins.length][amount];
        }
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
            
            for(int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
            }
            
        return dp[nums.length - 1];
    }
}