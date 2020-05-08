//time complexity is Exponential
//space complexity is O(1)

class Solution {
    public int rob(int[] nums) {
       return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int sum){
        //Base
        if(index >= nums.length) return sum;
        //Logic
        //case1 not chosen
        int case1 = helper(nums, index+1, sum);
        int case2 = helper(nums, index+2, sum+nums[index]);
        return Math.max(case1, case2);
    }
}
