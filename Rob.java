// Time Complexity : n^2
// Space Complexity : 1
// Did this code successfully run on Leetcode : Time exceeded 
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class Rob {

    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int index, int maxRobs) {

        // base
        if (index >= nums.length)
            return maxRobs;

        // logic
        int case2 = helper(nums, index + 2, maxRobs + nums[index]);
        int case1 = helper(nums, index + 1, maxRobs);

        return Math.max(case1, case2);
    }

    public static void main(String[] args) {
        Rob r = new Rob();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(r.rob(nums));
    }
}
