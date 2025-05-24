// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0]; 
        //int[] dp = new int[nums.length];

      // as we only need two previous values of the dp array so prev and curr are those var 
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            //dp[i] = Math.max(dp[i-1] , dp[i-2]+nums[i]);
          // check if the new combination with the current house gives more money then the on previous one 
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }

        return curr;
    }
}
