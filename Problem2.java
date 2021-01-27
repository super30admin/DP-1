//Step1 -make a an array with maximum sum untill k.
//Step2 compare the next house + dp[i-2] and dp[i-1], whichever is bigger we continue with that.
//Runtime- O(n) space complexity -O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return (nums[0]>=nums[1]) ? nums[0] : nums[1];
        int dp[]= new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[0]);
        
        for(int i=2;i<nums.length;i++)
        {
                dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        
        return dp[nums.length-1];
    }
}