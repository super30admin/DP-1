class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0:
            return 0
        #initializing Dp
        dp=[[0 for x in range(0,2)] for y in range(len(nums))]
        dp[0][0]=0
        dp[0][1]=nums[0]
        #updating Dp matrix
        for i in range(1,len(nums)):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            dp[i][1]=nums[i]+dp[i-1][0]
        return max(dp[len(nums)-1][0],dp[len(nums)-1][1])