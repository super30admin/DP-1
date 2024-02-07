class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        //return helper(nums, 0);
         int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = curr;
           curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }

        return curr;
    }

    private int helper(int[] nums, int idx){
        //base
        if(idx >= nums.length) return 0;
        
        //logic

        //not choose
        int case1 = 0 + helper(nums, idx + 1);
        //choose
        int case2 = nums[idx] + helper(nums, idx + 2);

        return Math.max(case1, case2);
    }
}