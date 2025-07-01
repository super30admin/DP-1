// This solution solves House Robber problem using DP method.

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int skip = 0; // <-- dontPick case / 0
        int take = nums[0]; // <-- pick case / 1

        for(int i=1;i<nums.length;i++){
            int temp = skip; // Store current dontPick in a temp variable
            skip = Math.max(temp, take); // If we dont pick the current value, we can choose max of previous skip and take
            take = temp + nums[i]; // If we pick the current value, we have to skip previously, so previous skip + current value
        }

        return Math.max(skip, take);
    }
}
