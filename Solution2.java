// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * At each step, the maximum amount that can be robbed is the maximum of sum of amount attained before robbing
 * the previous house and the amount that can be obtained by robbing the current house or the 
 * amount attained by robbing the previous house.
 */

class Solution2 {
    public int rob(int[] nums) {
        int current=nums[0];
        int prev=0;
        for(int i=1;i<nums.length;i++)
        {
            int prev2 = current;
            current=Math.max(current,prev+nums[i]);
            prev=prev2;
        }
        return current;
    }
}