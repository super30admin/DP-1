#Time complexity:O(n)
#space complexity: O(n)
class Solution:
    def rob(self, nums) -> int:
        dp=[[0 for i in range(2)] for j in range(len(nums))]
        dp[0][0]=0
        dp[0][1]=nums[0]
        if len(nums)==1:
            return dp[0][1]
        if len(nums)==2:
            return max(nums[0],nums[1])
        for i in range(1,len(nums)):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            dp[i][1]= max(dp[i-2][0],dp[i-2][1])+nums[i]
            
        return max(dp[i][0],dp[i][1])