class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        dp = [0 for i in range(n+1)]
        dp[0]=0
        if(n==1):
            return nums[0]
        for i in range(1,n+1):
            dp[i] = max(dp[i-1],nums[i-1]+dp[i-2])
        
        return dp[n]