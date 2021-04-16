class Solution:
    def rob(self, nums: List[int]) -> int:
        '''
        Time Comlexity : O(n)
        Spcae complexity : O(n)
        approach :
            dp[i] = max(dp[i-1],dp[i-2] + nums[i])
        '''
        n = len(nums) 
        if n<=2 :
            return max(nums)
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1]) #choose house with most moeny between 1st and 2nd house
        for i in range(2,n):
            dp[i] = max(dp[i-1],dp[i-2] + nums[i]) # choose previous house or choose this house
        print(dp)
        return dp[-1]
            