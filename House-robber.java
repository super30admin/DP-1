class Solution {

    /*Time complexity : O(n);
     * Space Complexity : O(1);
     * 
     * executed in leetcode
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length ==0 ) return 0;
        if (nums.length < 2) return nums[0];
        int n = nums.length;
        int prev = nums[0];
        int curr  = Math.max(nums[0] , nums[1]);
        for (int i = 2; i< n; i++){
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }
}
