// Time Complexity :  O(N) 
// Space Complexity :  O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no , understood the solution.


// Your code here along with comments explaining your approach
// suppose we are at the ith house and we want to find out the max rob amount till that house.
// if we rob ith house then we shouldn't consider (i-1)th house, in this case only (i-2)th house is useful

class Solution {
    public int rob(int[] nums) {
        
        //Recursive solution 
/*
    //1. Recursive Solution
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        return robHouse(nums, nums.length);   
    }
    
    public int robHouse(int[] nums, int n){
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHouse(nums, n - 3) + nums[n - 1], robHouse(nums, n - 2));
    }
*/
        
         //2. Dynamic Programming Solution
  
        if(nums.length == 0){  
            return 0;               // if we dont have any house to rob return 0
        }
        if(nums.length == 1){
            return nums[0];      // if we  have 1 house to rob return  house money at 0th location.
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);  // if we  have 2 houses to rob then we only rob the max house.
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++){  // running loop from 3rd located house.
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);   
           // suppose we are at the ith house and we want to find out the max rob amount till that house.
        // if we rob ith house then we shouldn't consider (i-1)th house, in this case only (i-2)th house is useful
        }
        return dp[nums.length - 1]; //return the max value i.e. profit.

        
    }
}


   
