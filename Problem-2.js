// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @return {number}
 */
 var rob = function(nums) {
    let maxValue = 0;
    
    let prevValue = 0;
    let prevPrevValue = 0;
    
    for (let i = 0; i < nums.length; i += 1) {
        maxValue = Math.max(prevValue, prevPrevValue + nums[i]);
        prevPrevValue = prevValue;
        prevValue = maxValue;
    }
    
    return maxValue;
};