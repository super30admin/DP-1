// Time Complexity : O(n) n is the input array length.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int rob(int[] nums) {
       //bottom-up approach
        int[] dp = new int[nums.length+2];
        for(int i=nums.length-1;i>=0;--i){
                dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return dp[0];
    }
} 
    
      //  MEMOIZATION
//     int dp[];
//     public int rob(int[] nums) {
//         dp = new int[nums.length];
//         Arrays.fill(dp,-1);
//         return rob(nums, 0);
//     }
    
//     int rob(int[] nums, int index){
//         // if(nums.length == 1 || index == nums.length-1){
//         //     return nums[index];
//         // }
//         if(index >= nums.length){
//             return 0;
//         }
//         if(dp[index] != -1){
//             return dp[index];
//         }
//         int money = nums[index] + rob(nums,index+2);//Robbing that house
//         int money1 = rob(nums,index+1);//Not robbing that house
//         dp[index] = Math.max(money,money1);
//         return dp[index];
        
//     }
