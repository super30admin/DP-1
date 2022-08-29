//Coin Change I

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        //null case
        if(coins == null || coins.length == 0) return 0;
        
        //n is column (amount) and m is length of array
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1]; //declaaring 2d array
        dp[0][0] = 0; //0th matrix location
        
        //top row // dummmy row
        for(int j=1;j<dp[0].length;j++)
        {
        dp[0][j] = amount+1;
        }
        //remaining matrix
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        
        int result = dp[m][n];
        
        if(result > amount) return -1;
        return result;
    }
    
   
}

//House Robber

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Approach DP 1d array

class Solution {
    public int rob(int[] nums) {
        //null case
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        
        int[] dp = new int[n];
        if(n == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2;i<n;i++)
        {
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        
        return dp[n-1];
        
    }
}

//Approach  using same array and 2 variables

class Solution {
    public int rob(int[] nums) {
        //null case
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        
        if(n == 1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        
        for(int i=2;i<n;i++)
        {
            int temp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = temp;
        }
        
        return curr;
        
    }
}