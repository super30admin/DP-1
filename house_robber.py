"""
Memoization
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [-1]*len(nums)
        def func(idx):
            if idx == len(nums)-1:
                return nums[idx]
            if idx>len(nums)-1:
                return 0
            if dp[idx]!=-1:
                return dp[idx]
            pick = nums[idx]+func(idx+2)
            not_pick = func(idx+1)
            dp[idx] =  max(pick, not_pick)
            return dp[idx]
        return func(0)

"""
#Tabulation
"""
TC -> O(n)
SC -> O(n)
Used the recursive method initially -> led to TLE
Then used memoization and finally arived at Tabulation solution.
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        dp = [-1]*len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], dp[i-2]+nums[i])
        return dp[-1]