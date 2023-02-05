// Time Complexity : O(nums)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//just depending on the previous rob and robnot values, while 
//updating the maximum possible every time for robnot
class Solution {
    public int rob(int[] nums) {
        int consider = 0, donot = 0;
        for (int num : nums) {
            int curr = consider;
            consider = donot + num;
            donot = Math.max(curr, donot);
        }
        return Math.max(consider, donot);
    }
}