// Time Complexity : O(mxn) where m is the number of length of coins array, n is the amount
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        int max = 0, prevMax = 0, temp = 0;
        for (int i = 0; i < nums.length; i += 1) {
            if (i < 2) {
                prevMax = max;
                max = Math.max(max, nums[i]);
                continue;
            }
            temp = max;
            max = Math.max(max, nums[i] + prevMax);
            prevMax = temp;
        }
        return max;
    }
}
