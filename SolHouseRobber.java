// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// house robber pattern (here we can use 1D array as well)

class SolHouseRobber {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        // make first value as the previous and current as the max out of previous and (nothing + nums_at_index)
        int n = nums.length;
        int pre = nums[0];
        if(n==1)return nums[0];
        int curr = Math.max(nums[0],nums[1]);

        // calculate the current out of the max of curr and (previous + nums_at_index)
        for(int i=2; i<n; i++){
            int tmp = curr;
            curr = Math.max(tmp, pre+nums[i]);
            pre = tmp;
        }
        return curr;
    }
}