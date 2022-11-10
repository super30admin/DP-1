//Time complexity is O(N)
//Space complexity is O(N)
//Able to submit in leetcode
class Solution {
    public int rob(int[] nums) {
        int[] dp= new int[nums.length+1];
        if(nums.length==1)
        return nums[0];
        if(nums.length==2)
        return Math.max(nums[0], nums[1]);
        dp[0]=0;
        dp[1]=nums[0];
        dp[2]=nums[1];
        for(int i=2;i<nums.length;i++){
                dp[i+1]=Math.max(dp[i-1], dp[i-2])+nums[i];
        }
        return Math.max(dp[nums.length-1], dp[nums.length]);
    }
}