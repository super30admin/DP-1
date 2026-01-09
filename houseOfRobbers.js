/**
 * @param {number[]} nums
 * @return {number}
 */
// var rob = function(nums) {

//    const robHelper = (idx) => {
//     // base case
//     if(idx >= nums.length) return 0;

//     const zero = robHelper(idx+1);
//     const one = nums[idx] + robHelper(idx+2);
//     return Math.max(zero, one);
//    } ;

//    return robHelper(0);
// };

/**

Intuition:
**Intuition:**
The recursive solution caused time limit issues due to overlapping subproblems, so I converted it into a dynamic programming (tabulation) approach. At each index, the maximum profit is either skipping the current house (`dp[i - 1]`) or robbing it and adding its value to the profit from two houses back (`nums[i] + dp[i - 2]`). Thus:

`dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2])`

**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)`
*/
var rob = function (nums) {
    // base case
    if (nums.length === 1) return nums[0];
    const dp = [nums[0], Math.max(nums[0], nums[1])];
    for (let i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    }
    return dp[nums.length - 1];
};