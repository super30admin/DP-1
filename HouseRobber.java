//Problem: House Robber
// Time Complexity : Time limit exceeds. O(2^n), here n is number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Using Exhaustive Approach
class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    private int helper(int[] nums, int idx){
        //base
        if(idx >= nums.length)
            return 0;

        //logic
        //don't choose the house
        int case1 = helper(nums, idx+1); 

        //choose the house
        int case2 = nums[idx] + helper(nums, idx+2);

        return Math.max(case1, case2);
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Using DP:- Top-down approach

class Solution {
    private int [] memo;
    public int rob(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int idx){
        //base
        if(idx >= nums.length)
            return 0;

        if(memo[idx] != -1){
            return memo[idx];
        }

        //logic
        //don't choose the house
        int case1 = helper(nums, idx+1); 

        //choose the house
        int case2 = nums[idx] + helper(nums, idx+2);

        memo[idx] = Math.max(case1, case2);
        return memo[idx];
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Using DP:- Bottom up approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int [] dp = new int[nums.length];
        dp[0] =nums[0];
        
        dp[1] = Math.max(dp[0], nums[1] + 0);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[nums.length -1];
    }
}

//Space Optimized solution
//Space Complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int prev =nums[0];
        
        int curr = Math.max(nums[0], nums[1] + 0);
        for(int i=2; i<nums.length; i++){
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}