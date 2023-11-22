// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {

int[] dp = new int[nums.length];
dp[0] = nums[0];
dp[1] = Math.max(nums[0],nums[1]);

for(int i=2;i<nums.length;i++){
    dp[i] = Math.max(dp[0]+nums[i-2], dp[i-1]);
}

return dp[nums.length-1];
       }

    }
