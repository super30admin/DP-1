// TimeComplexity: O(2^n)
// SpaceComplexity: O(n)

// Approach:
//     Create a 2D matrix where rows will be the number of houses and columns are of length 2.
//     For the first house, dp[0][0] =0 & dp[0][0] = 1 , j -> 0 is when we dont rob the house and j->1 is when we rob the house.
//     For the next subsequent house at j=0, dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]).
//     If we rob any house, then the dp[i][1] = nums[i]+dp[i-1][0];

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length<1) return 0;
        
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        for(int i =1; i<nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}