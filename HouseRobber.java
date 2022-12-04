// Time Complexity :O(n)
// Space Complexity :O(n)

/*
 * we travel through the array and find the max of current element
 * and the one two steps back or the prevoius element. store them in an
 * array and return the final value.
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int [] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], 0+nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
    
    /*
    // recursive solution
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0);
    }
    
    public int helper(int[] nums, int idx, int maxRob){
        //base
        if(idx >= nums.length) return maxRob;
        
        //logic
        //dont choose
        int case1 = helper(nums, idx+1, maxRob);
        //choose
        int case2 = helper(nums, idx+2, maxRob+nums[idx]);
        return Math.max(case1, case2);
    }
     */
}
