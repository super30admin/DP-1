class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = curr;
            curr = Math.max(temp, prev+nums[i]);
            prev = temp;
        }

        return curr;
    }
}