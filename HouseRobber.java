// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 At each iteration, we take the max of either current max or we add this number to previous max.
 We finally return the current max.

*/

class Solution {
    public int rob(int[] nums) {
         int prevMax = 0;
    int currMax = 0;
    for (int i = 0; i < nums.length; i++) {
        int temp = currMax;
        currMax = Math.max(prevMax + nums[i], currMax);
        prevMax = temp;
    }
    return currMax;
        
    }
}