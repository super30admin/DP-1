// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Since we can not rob two adjacent houses, at any point we can rob either the previous house or
// house previous to that and the current house. At any index i, We need to find max of gold at previous house or
// adding the gold at the house previous to it and gold at the current house.

public class Robber {
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 0) return 0;
        if (len == 1) return nums[0];

        int[] result = new int[len];

        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }


        return result[len - 1];
    }
}
