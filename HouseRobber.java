class HouseRobber {
    //T = O(n)
    
    //space = O(1)
    public int rob(int[] nums) {
        if (nums.length ==1) return nums[0];
        int n = nums.length;
        // int[] dp = new int[n];
        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1]);
        for (int i=2; i<n; i++){
            int temp = curr;
            curr= Math.max(curr,prev+nums[i]);
            prev = temp;
        }
        return curr;

    }
}

// class Solution {
//     //T = O(n)
//     //space = O(n)
//     public int rob(int[] nums) {
//         if (nums.length ==1) return nums[0];
//         int n = nums.length;
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0],nums[1]);
//         for (int i=2; i<n; i++){
//             dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
//         }
//         return dp[n-1];

//     }
// }


//O(2^n)
// class Solution {
//     public int rob(int[] nums) {
//         if (nums.length ==1) return nums[0];
//         return helper(nums, 0);
//     }
//     private int helper(int[] nums, int idx) {
//         //base
//         if (idx >= nums.length) return 0;
        
//         //logic
//         int case0 = helper(nums, idx+1);
//         int case1 = nums[idx] + helper(nums,idx+2);
    
//         return Math.max(case0, case1);
//     }
// }