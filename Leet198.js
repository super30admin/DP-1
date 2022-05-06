// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if(nums.length<2)
        return nums[0];
    const dp=new Array(nums);
    dp[0]=nums[0],dp[1]=Math.max(nums[0],nums[1]);
    for(let i =2;i<nums.length;i++)
    {
      dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
    }
    return dp[dp.length-1];
};