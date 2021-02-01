// Time complexity - O(n) where n is the length of nums array
// Works on leetcode

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int choose = nums[0];
        int dontChoose = 0;
        int prev_choose = nums[0];

        for(int i=1; i<nums.length;i++){
            choose = dontChoose + nums[i];
            dontChoose = Math.max(prev_choose, dontChoose);
            prev_choose = choose;
        }
        return Math.max(choose, dontChoose);
    }
}
