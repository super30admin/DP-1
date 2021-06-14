//recursive solution:

class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int robbings) {

        // base
        if (index >= nums.length)
            return robbings;
        // logic
        // choosing to rob
        int case1 = helper(nums, index + 2, robbings + nums[index]);

        // not choosing the house
        int case2 = helper(nums, index + 1, robbings);

        return Math.max(case1, case2);
    }

}