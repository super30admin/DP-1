"""
House Robber; can't rob adjacent house

Time = O(n)--- where n = num of house
space = O(n) -- for dp table
Successfully excecuted on leetcode


Approach:

1. For every house i, there are two options: either to rob it  or not rob it 
2. We can take maximum amount of dp[i-1] result or dp[i-2]+nums[i]

"""

class Robbery:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        if n == 1:
            return nums[0]
        dp = [0]*n
        dp[0] = nums[0]
        dp[1] = max(nums[1],nums[0])
        print("1 ", dp)
        for i in range(2,n):
            dp[i] = max(dp[i-1],dp[i-2]+nums[i])
        print("2 ",dp)
        return dp[n-1]