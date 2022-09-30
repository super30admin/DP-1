// class Solution {
//     public int rob(int[] nums) {
//         //BACKTRACKING
        
//         return helper(nums, 0, 0);
//     }
    
//     private int helper(int[] nums, int index, int robbed_amount){
//         //base
//         if(index >= nums.length)
//             return robbed_amount;
        
//         //logic
//         int case1 = helper(nums, index+1, robbed_amount);
//         int case2 = helper(nums, index+2, robbed_amount + nums[index]);
        
//         return Math.max(case1, case2);
//     }
// }

//Time Complexity: 
//Space Complexity: O()
class Solution {
    public int rob(int[] nums) {
        
       //rob , do not rob, dp solution:
        
        int n = nums.length;
    
        
        int[][] dp = new int[n][2];
        
        dp[0][1] = nums[0];
        
        for(int i = 1; i < n; i ++){
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        
        dp[i][1] = dp[i-1][0] + nums[i];
        }
        
        return Math.max(dp[n-1][0], dp[n-1][1]) ;
    }
}