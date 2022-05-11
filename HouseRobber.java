/**
 * time: 2^n 
 * space: 2^n
 * 
 * Did this code successfully run on Leetcode : Yes but Time Limit Exceeded
 * Any problem you faced while coding this : No
 */
class Problem21 {
    public int rob(int[] nums) {
        // null
        if(nums == null || nums.length == 0) return 0;
        
        return helper(nums, 0, 0);
    }
    
    public int helper(int[] nums, int index, int robbed){
        // base
        if(index >= nums.length) return robbed;
        
        // logic
        // not choose
        int case1 = helper(nums, index+1, robbed);
        // choose 
        int case2 = helper(nums, index+2, robbed + nums[index]);
            
        return Math.max(case1, case2);
    }
}

/**
 * Dynamic programming
 * 
 * time: O(n)
 * space: O(n)
 * 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
class Problem21Approach1 {
    public int rob(int[] nums) {
        // null
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }
}

/**
 * DP 
 * 
 * time: O(n)
 * space: O(1)
 */
class Problem21Approach2 {
    public int rob(int[] nums) {
        // null
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int n = nums.length;
        
        int notChoose = nums[0];
        int choose = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++){
            int temp = notChoose;
            notChoose = Math.max(choose, notChoose);
            choose = nums[i] + temp;
            // dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return Math.max(choose, notChoose);
    }
}
