// Exhaustive method 
// class Solution {
//     public int rob(int[] nums) {
//         return helper(nums,0);
//     }
//     private int helper(int[] nums, int idx){
//         //base
//         if(idx>=nums.length) return 0;
//         //logic
//         //dont choose 
//         int case1 = helper(nums,idx+1);
//         //choose 
//         int case2 = nums[idx]+helper(nums,idx+2);
//         return Math.max(case1, case2);
//     }
// }

// Top Dowm approach 
// import java.util.Arrays;
// class Solution {
//     int[] memo;
//     public int rob(int[] nums) {
//         this.memo= new int[nums.length];
//         Arrays.fill(memo,-1);
//         return helper(nums,0);
//     }
//     private int helper(int[] nums, int idx){
//         //base
//         if(idx>=nums.length) return 0;
//         if(memo[idx]!=-1) return memo[idx];
//         //logic
//         //dont choose 
//         int case1 = helper(nums,idx+1);
//         //choose 
//         int case2 = nums[idx]+helper(nums,idx+2);
//         memo[idx]= Math.max(case1, case2);
//         return memo[idx];
//     }
// }


//Bottom up approach 
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);
//         for(int i=2; i<nums.length;i++){
//             dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
//         }
//         return dp[n-1];
//     }
// }

//Bottom up approach - memory optimised 
// Time Complexity : O(n) where n is the length of the input array
// Space Complexity : O(1) as we are using constant space for the variables
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        //int[] dp = new int[n];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length;i++){
            int temp = curr;
            curr = Math.max(curr,nums[i]+prev);
            prev = temp;
        }
        return curr;
    }
}