class Solution {
    
    private int[] memo;
    
    public int rob(int[] nums) {
        
        this.memo = new int[100];
        Arrays.fill(this.memo, -1);
        return this.robFrom(0, nums);
    }
    
    private int robFrom(int i, int[] nums) {
        
        // Edge cases:
        // Case 1: reached end
        if (i >= nums.length) {
            return 0;
        }
        // Return value if reached end here.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }
        
        // Recursive comparison for adjacent  indexes
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);
        
        this.memo[i] = ans;
        return ans;
    }
}