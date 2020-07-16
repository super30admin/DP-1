//Time Complexity: O(S)
//Space Complexity:O(S)
//In this program, I'll be creating a new space with length 2 greater than the nums array. I'll then iterate over the array and take the max of the sum of my current house with the value from its previous house -1 with that of the previous house and take that value. At the end I'll be returning the last value in my dp array.
// This program was successfully executed and got accepted in leetcode. 

class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+2];
        for (int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-2]);
        }
        return dp[dp.length-1];
    }
}