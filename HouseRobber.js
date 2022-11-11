// Time Complexity : O (n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
  if (nums.length === 0 || nums === null) {
    return 0;
  }

  var n = nums.length;

  // using n * 2 matrix
  // var dp = new Array(2);
  // for (var i = 0; i <= n; i++) {
  //   dp[i] = new Array(n);
  // }

  // dp[0][0] = 0; // default
  // dp[0][1] = nums[0];

  // for (var i = 1; i < n; i++) {
  //   dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
  //   dp[i][1] = dp[i - 1][0] + nums[i];
  // }

  // No extra space
  var skip = 0,
    take;
  take = nums[0];
  for (var i = 1; i < n; i++) {
    var temp = skip;
    skip = Math.max(skip, take);
    take = temp + nums[i];
  }

  return Math.max(skip, take);
};
