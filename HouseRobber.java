/* LC: 198 Easy https://leetcode.com/problems/house-robber/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
1. At every pont, there are 2 options, either rob at ith house and skip (i-1)st house, OR
   skip ith house, and skip previous house
*/

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] total = new int[nums.length + 1];
        total[0] = 0;
        total[1] = nums[0];
        
        for (int i=2; i<=nums.length; i++) {
            total[i] = Math.max(total[i-1], total[i-2]+nums[i-1]);
        }
        
        return total[nums.length];
    }
}