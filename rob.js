// Time Complexity : O(n) where n is length of nums
// Space Complexity : O(n) where n is length of nums
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let dp = [new Array(2)]
    let n = nums.length;
    if(nums == null || n == 0) return 0;
    if(n == 1) return nums[0];
    dp[0][0] = 0;
    dp[0][1] = nums[0];
    for(let i=1; i<n; i++) {
        if(!dp[i]) {
            dp[i] = new Array(2);
            dp[i][0] = 0;
        }
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        dp[i][1] = (dp[i-1][0]+nums[i]);
    }
    return Math.max(dp[n-1][0], dp[n-1][1]);
};