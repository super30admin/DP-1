/**
 * @author Vishal Puri
 * // Time Complexity : O(m*n)
 * // Space Complexity : O(m*n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class Rob {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] max = new int[nums.length];
        max[0] = nums[0];
        // int maximum = max[0];
        max[1] = nums[1];
        max[2] = nums[2] + max[0];
        int maximum = Math.max(Math.max(max[1], max[0]), max[2]);
        for(int i = 3; i < nums.length; i++) {
            max[i] = Math.max(max[i-2], max[i-3])+nums[i];

            if(max[i] > maximum)
                maximum = max[i];
        }
        return maximum;
    }
}
