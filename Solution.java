//time complexity: o(n)
//space complexity: o(n)--- we used an additional array

// class Solution{
//     public int rob(int[] nums){
//         if(nums == null || nums.length == 0 ) return 0;
        
//         int n = nums.length;
//         int[][] dp = new int[n][2];
//         dp[0][1] = nums[0];
//         for(int i=1; i<n; i++){
//             //not choose
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
//             // choose
//             dp[i][1] = nums[i] +dp[i-1][0];
//         }
//         return Math.max(dp[n-1][0], dp[n-1][1]);
//     }
    
    
// }

// optimal solution where space complexity is o(1), instead of using array we are using two variables skip and take
class Solution{
    public int rob(int[] nums){
        if(nums == null || nums.length == 0 ) return 0;
        
       int n = nums.length;
       // int[][] dp = new int[n][2];
       // dp[0][1] = nums[0];
        int skip = 0;
        int take = nums[0];
        
        for(int i=1; i<n; i++){
            //not choose
            int temp = skip;
            skip = Math.max(skip, take);
            // choose
            take = nums[i] + temp;
        }
        return Math.max(skip, take);
    }
    
    
}



// //exhaustive search , time limit exceeded
// class Solution {
//     public int rob(int[] nums) {
//         if(nums == null || nums.length== 0) return 0;
//         return helper( nums, 0, 0);
//     }
//     private int helper(int[] nums, int index, int robbedamount){
//         // base case
        
//         if(index >= nums.length){
//             return robbedamount;
//         }
        
//         //logic
//         // do not rob the house
//         int case1 = helper(nums, index+1, robbedamount);
//         // robs the house
//         int case2 = helper(nums, index+2, robbedamount+nums[index]);
//         return Math.max(case1, case2);
//     }
// }