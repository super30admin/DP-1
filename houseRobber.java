class Solution {
    //Time complexity: O(n)
    //Space complexity: O(n)
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] dp=new int[nums.length+1];
        dp[nums.length]=0;
        dp[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            dp[i]=Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return dp[0];
    }
}