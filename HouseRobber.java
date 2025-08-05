// This solution considers the fact that present house can be robbed with maximum amount based on the present value + present-2 (sub problem) and present-1 (sub problem) and iteratively calculates the max at any given index
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++) {
            int temp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = temp;
        }
        return curr;
    }
}
