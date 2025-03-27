/* Using 1D array: Time complexity - O(n) & Space complexity - O(n) */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }
}

/* Using pointers(prev, curr): TC - O(n) & SC - O(1) */

/* Recursive logic: Time complexity - 2^n & Space complexity - n
* n-number of houses */
/*
class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int i, int robbings){
        //base case
        if(i >= nums.length) return robbings;

        //don't robb
        int case0 = helper(nums, i+1, robbings);

        //robb
        int case1 = helper(nums, i+2, robbings+nums[i]);
        
        return Math.max(case0, case1);
    }
}
    */