
// Time Complexity: O(n)
// Space Complexity:  O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Your code here along with comments explaining your approach


//     nums Array                        dp Array
// idx  values
// 0     6                                    6
// 1     9                                    9
// 2     8                   Max(9, 8+6)   = 14
// 3     1                   Max(14,1+9)   = 14
// 4     1                   Max(14,1+14)  = 15
// 5     5                   Max(15,5+14)  = 19 


class Solution {
    public int rob(int[] nums) { 
        //null 
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        //DP array to get max value
        int[] dp = new int[n];
        
        //First Element
        dp[0] = nums[0];

        //if it has only one element return that element
        if(n==1) return nums[0];

        //Second Element
        dp[1] = Math.max(nums[0],nums[1]);
        
        for (int i=2; i<n;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
   
}
  









// Time Complexity: Exponential
// Space Complexity:  O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Your code here along with comments explaining your approach
// Recursive Solution
class Solution {
    public int rob(int[] nums) {
        
        //null 
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0);
        
    }
    
    private int helper(int [] nums, int idx, int amount){
        
        //Base
        if( idx >= nums.length) return amount;
        
        //Case1: Choose
        int case1 = helper(nums, idx+2, amount + nums[idx]);
        
        //Case2: Dont choose
         int case2 = helper(nums, idx+1, amount);
        
        return Math.max(case1,case2); 
    }
}