// Time Complexity : O(n) where n = number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        // check if array is null or empty
        if(nums == null || nums.length == 0) return 0;
            
        // initalize skip and take variables
        int skip = 0;
        int take = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            
            // store the skip variable in temp variable for each element in array to avoid overwriting of skip variable 
            int temp = skip;
            
            // update the skip variable to previous element's maximum between skip or take
            skip = Math.max(skip, take);
            
            // update the take variable by adding previous element's skip and current element
            take = temp + nums[i];
        }
        
        // return the the maximum of skip or take
        return Math.max(skip, take);
    }
}

// // Time Complexity : O(n) where n = number of houses
// // Space Complexity : O(n)
// // Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No


// // Your code here along with comments explaining your approach
// class Solution {
//     public int rob(int[] nums) {
//         // check if array is null or empty
//         if(nums == null || nums.length == 0) return 0;
        
//         int [][]dp = new int [nums.length + 1][2];
        
//         dp[0][1] = nums[0];
        
//         for(int i = 1; i < nums.length; i++){
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            
//             dp[i][1] = dp[i-1][0] + nums[i];
//         }
        
//         return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
//     }
// }