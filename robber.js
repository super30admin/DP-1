// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var rob = function(nums) {
    const dp = [0, 0];
    
    for(let i = 0; i < nums.length; i++) {
        dp[i+2] = Math.max(dp[i+1], dp[i] + nums[i]);
    }
    return dp[dp.length-1]
};