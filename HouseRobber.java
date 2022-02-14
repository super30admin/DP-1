/**

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
With Top Down and Memoization  
 TC -  O(n) where n is the size of an array. 
 SC -  O(n) where n is the size of a dp array that used for storing the results.
 
Bottom up approach
[1,2,3,1]
 
 [1]
f(0)= 1
 
 [1,2]
 f(1) = 2
 
 [1,2,3] -> f(2)= Math.max(f(0) + f(2), f(1))
 
 [1,2,3,1] -> f(3) =  Math.max(f(1) + f(3), f(2))
 
**/
class Solution {
    
    private int dp[];
    
    public int rob(int[] nums) {
        dp = new int[100];
        
        Arrays.fill(dp, -1);
        
        return maxRobAmount(nums, 0);
    }
    
    
    public int maxRobAmount(int nums[], int index)
    {   
        if (index>= nums.length)
        {
            return 0;
        }
        
          if (dp[index] > -1)
          {
             return dp[index];   
          }
    
        int max = Math.max(nums[index] + maxRobAmount(nums, index + 2), maxRobAmount(nums, index + 1)) ;
        
        dp[index] = max;

        return max;
    }
}

/**

nums = [1,2,3,1]

1,2,4,4

Recurrence relation at each house: dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
With Bottom up and DP  
 TC -  O(n) where n is the size of an array. 
 SC -  O(n) where n is the size of a dp array that used for storing the results.

**/
class Solution {
    
    int dp[];
    
    public int rob(int[] nums) {
        
        if (nums.length == 1)
        {
            return nums[0];
        }
        
        if (nums.length == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        
        dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i=2; i<nums.length; i++)
        {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        
        return dp[nums.length - 1];
    }
}