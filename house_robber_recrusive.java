


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, 0);
    }
     private int helper(int[] nums, int index, int score) {
        //base
        if(index >= nums.length) {
            return score;
        }
        //logic
        //case 0 where current house is not chosen
        int case0 = helper(nums, index + 1, score);
        //case 1 where current is robbed !
        int case1 = helper(nums, index + 2, score + nums[index]);
        return Math.max(case0, case1);
    }
}
    
