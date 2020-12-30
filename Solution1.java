// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;
        for (int i: nums)
        {
            int temp = curr;
            curr = Math.max(prev+i, curr);
            prev = temp;
        }
        return curr;
    }
}