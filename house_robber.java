// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {
    int prevMax = 0;
    int currMax = 0;
    for (int num : nums) {
        int temp = currMax;
        currMax = Math.max(prevMax + num, currMax);
        prevMax = temp;
    }
    return currMax;
    }
}