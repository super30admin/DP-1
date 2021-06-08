class Solution2 {
    int maxMoneyRob = 0;
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int moneyRob){
        //base case
        if(index >= nums.length){
            if(moneyRob>=maxMoneyRob){
                maxMoneyRob = moneyRob;
            }
            return moneyRob;
        }

        int case1 = helper(nums,index+1,moneyRob);
        int case2 = helper(nums,index+2,moneyRob + nums[index]);

        return maxMoneyRob;
    }
}