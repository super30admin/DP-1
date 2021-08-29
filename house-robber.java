//Time complexity: O(N)
//Space complexity: O(N), because space is occupied by recursion stack
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return helperMethod(nums, 0, 0);
    }

    private int helperMethod(int[] nums, int index, int max) {
        //base case
        if(index >= nums.length) {
            return max;
        }
        //choose
        int case1 = helperMethod(nums, index + 2, max + nums[index]);
        //not choose
        int case2 = helperMethod(nums, index + 1, max);
        return Math.max(case1, case2);
    }
}