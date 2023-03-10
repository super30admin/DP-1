public class HouseRobberRecursive {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }
    private int helper(int[] nums, int idx, int amountTillNow){
        //base
        if(idx >= nums.length) return amountTillNow;
        //logic
        int case0 = helper(nums, idx+1, amountTillNow);
        int case1 = helper(nums, idx+2, amountTillNow + nums[idx]);
        return Math.max(case0, case1);
    }
}
