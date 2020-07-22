//Time Complexity=O(N), N=no. of houses
//Space Complexity=O(N), N=No. of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

//As per the brute force we are doing choose & don't choose, to implement it using dp we are creating a matrix of length n and 2 columns, (i.e we can say they are don't choose and choose). So for 1st house we don't rob it then the amount(or loot) is 0, and if we choose to do it then we have the amount as the house value. Now for the other house we have two option 0 or 1(i.e. don't choose pr choose), if we don't choose the house then then we are taking the max amount obtained from the previous house. If we were to choose the current house than that means we haven't robbed from the previous house, so we add the amount of current house to the amount at not choosing previous house.And the Max value at the end after going to all houses is the answer.   
class Solution {
    public int rob(int[] nums) {
        int[][] dp=new int[nums.length][2];
        if(nums.length==0)
            return 0;
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=nums[i]+dp[i-1][0];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}