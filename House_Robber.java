class Solution {
    /*
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0]; // second last 
        if (n == 1) return nums[0];
        int curr = Math.max(nums[0], nums[1]); // last
        for (int i=2; i<n; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i]+prev); // choose from last and (second last+currvalue)
            prev = temp;
        }
        return curr;
    }
}