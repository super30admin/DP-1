// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//DP1

// class Solution {
//     // TC : O(n*m)
//     //SC O(n*m)
//     public int coinChange(int[] coins, int amount) {

//         if(coins == null || coins.length ==0) return 0;

//         int[][] dp = new int[coins.length+1][amount+1];

//         for(int j=1; j<amount+1; j++){
//             dp[0][j] = amount+1;
//         }
//         for(int i =1;i<coins.length+1;i++){
//             for(int j =1;j<amount+1;j++){
//                 if(j<coins[i-1]){
//                     dp[i][j] = dp[i-1][j];
//                   } else{
//                     dp[i][j] = Math.min(dp[i-1][j],1+ dp[i][j-coins[i-1]]);

//                 }
//             }

//         }

//         if(dp[coins.length][amount] == amount+1) {return -1;}

//         return dp[coins.length][amount];



//     }
// }



//========


// class Solution {
//     // TC O(N)
//     // SC O(N)
//     public int rob(int[] nums) {
//         if(nums == null || nums.length ==0) return 0;
//         int n = nums.length;
//         int[][] dp = new int[n][2];
//         dp[0][1] = nums[0];
//         for(int i =1;i<n;i++){
//             //not robbed
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
//             //robbed
//             dp[i][1] = dp[i-1][0] + nums[i];
//         }

//         return Math.max(dp[n-1][0], dp[n-1][1]);
//     }
// }