// Exhaustive Search - Time limit exceeds

/* const helper  = (nums, index, robbedAmt) => {
    if (index >= nums.length) {
        return robbedAmt;
    }
    var case1 = helper(nums, index+1, robbedAmt);
    var case2 = helper(nums, index+2, robbedAmt + nums[index]);
    return Math.max(case1, case2);
} */

/**
 * @param {number[]} nums
 * @return {number}
 */
/* var rob = function(nums) {
    if (nums===null || nums.length == 0) return 0;
    return helper(nums, 0, 0);
}; */

// Dynamic programming

function fill2DimensionsArray(arr, rows, columns) {
  for (var i = 0; i < rows; i++) {
    arr.push([0]);
    for (var j = 0; j < columns; j++) {
      arr[i][j] = 0;
    }
  }
  return arr;
}

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  if (nums === null || nums.length == 0) return 0;
  var n = nums.length;

  var arr = [];
  var rows = nums.length;
  var columns = 2;

  var dp = fill2DimensionsArray(arr, rows, columns);
  dp[0][1] = nums[0];
  for (i = 1; i < n; i++) {
    // not choose
    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
    // choose
    dp[i][1] = dp[i - 1][0] + nums[i];
  }
  return Math.max(dp[n - 1][0], dp[n - 1][1]);
};
