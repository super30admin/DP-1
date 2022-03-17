// Time Complexity :O(n) where n is the number of houses
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class HouseRob {
    public int rob(int[] nums) {
        // null
        if (nums == null || nums.length == 0)
            return 0;
        int skip = 0, take = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = skip;
            // skip - max of previous row
            skip = Math.max(skip, take);
            // take - curr+previous skip
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}
