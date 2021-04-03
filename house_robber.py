class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums)==0:
            return 0
        dp = [[None for i in range(0,2)] for j in range(len(nums))]
        dp[0][0]=0
        dp[0][1]=nums[0]
        for i in range(1,len(nums)):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            dp[i][1]=(dp[i-1][0]+nums[i])
        return max(dp[-1][0],dp[-1][1])