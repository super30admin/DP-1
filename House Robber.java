// Time Complexity = O(n)
// Space Complexity = O(1)


class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length ==1) return nums[0];
        int n = nums.length;
        int [] dp = new int [n];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n;i++){
                            // not choose, choose
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
