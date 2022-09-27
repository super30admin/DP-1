// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //Approach3 TC:O(n) SC: O(1)
//     public int rob(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
//         if( nums.length==1) return nums[0];
//         int n = nums.length;   
//         int skip = 0;
//         int take = nums[0];
//         for( int i = 1; i<n; i++){
//             int temp = skip;
//             skip = Math.max(skip,take);
//             take = nums[i] + temp;
        
//         }
//         return Math.max(skip,take);
//     }
//Approach3 TC:O(n) SC: O(n)
// public int rob(int[] nums) {
//     if(nums == null || nums.length == 0) return 0;
//     if( nums.length==1) return nums[0];
//     int n = nums.length;
//     int [][] dp = new int[n][n];
//     dp[0][1] = nums[0];
//     for(int i = 1;i<n; i++){
//         dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
//         dp[i][1] = nums[i]+dp[i-1][0];
//     }
//     return Math.max(dp[n-1][0],dp[n-1][1]);
//}
//Approach2 TC:O(n) SC: O(n)
public int rob(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    if( nums.length==1) return nums[0];
    int[] dp = new int [nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0],nums[1]);
    for( int i = 2; i<nums.length; i++){
         dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
    }
    return dp[nums.length-1];
}




//     public int rob(int[] nums) {
//         //approach1 TLE
//         if(nums == null || nums.length==0) return 0;
//         return helper(nums,0,0);
//     }

//     private int helper(int[] nums, int i, int robbed ){// i is the house number which is a.ready robbed
//         //base
//         if(i>=nums.length) return robbed;
//         //logic
//         //choose
//         int case1 = helper(nums,i+2,robbed+nums[i]); //i+2 bcoz no consective houses can be choosen for robbing, i is already robbed
//         //not choose
//         int case2 = helper(nums,i+1,robbed);// i is not robbed so go to next house
//         return Math.max(case1,case2);
//     }
}