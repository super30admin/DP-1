//TC:O(n)
//SC:O(n)

"""
Here we have two cases, either consider that case for robbery or leave, if we consider the case, then we have to take the sum of prev to prev case and current amount taken from the case, else we should consider the robbery ammount till just prev house, we
should take the max between these two scenarios
"""
class Solution {
    public int rob(int[] nums) {

        int n =nums.length;
        if(nums.length<2)
        {
            return nums[0];
        }
        int[] dp =new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}