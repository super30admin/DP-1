//TC = O(n)
//SC = O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums[0];
        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(0 + nums[1], prev);
        for(int i = 2; i < n; i++)
        {
            int temp = curr;
            curr = Math.max(curr, //dont choose
                                nums[i] + prev);
            prev = temp; 
        }

        return curr;
    }
}