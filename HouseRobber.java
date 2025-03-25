//Without DP array, just simple Array
//TC: O(n)
// SC: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // if (n == 0) return 0; // Edge case for empty array
        if (n == 1) return nums[0]; // Edge case for single element array
        // int[] dp = new int[n];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i=2;i<n;i++){
            int temp = curr;
            curr = Math.max(temp,nums[i]+prev);
            prev = temp;
        }
        return curr;
    }
}

//DP - Array approach
//TC: SC: O(n)
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         //if (n == 0) return 0; // Edge case for empty array
//         if (n == 1) return nums[0]; // Edge case for single element array
//         int[] dp = new int[n];

//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);

//         for(int i=2;i<n;i++){
//             dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
//         }
//         return dp[n-1];
//     }
// }

//Exhaustive Approach - Time limit exceeded
// TC: 2 power(n) - n is no. of houses

// class Solution {
//     public int rob(int[] nums) {
//         return helper(nums,0,0);
//     }
//     private int helper(int[] nums, int i, int robbings){

//         //base case
//         if(i >= nums.length) return robbings; // == only checks one element (i+1)     but skips (i+2) which is why check for >=
//         //logic
//         //not choose
//         int case0 = helper(nums, i+1, robbings);
//         //choose
//         int case1 = helper(nums, i+2, robbings + nums[i]);

//         return Math.max(case0, case1);

//     }
// }