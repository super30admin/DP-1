#Given a list of numbers or amounts in each house, we need to identify max robbery of amount.
#So ideally, we first try Greedy, it does not work for all cases.
#So we try to do exhaustive way using choose and no choose.
#then we try to find repeated sub problems, and we see there are repeated sub problems.
#hence we are trying to approach with DP using tabulation
#for 1-d or 2-d array, we are going to decide it by number of input constraints. we have only one input constraint so we are going with 1-d array.


class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        dp = [0 for i in range(0,n)]
        if n == 1: return nums[0]
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        return dp[n-1]
