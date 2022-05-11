# Time Complexity : O(mn)
# Space Complexity : O((m+1)(n+1))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import math
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for j in range(amount + 1)] for i in range(len(coins)+1) ]
        
        for j in range(1, len(dp[0])):
            dp[0][j] = math.inf
            
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
                            
        res = dp[-1][-1]
        
        if res >= math.inf:
            return -1
        
        return res

# Time Complexity : O(n) | n -> number of houses 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0: return 0
        elif len(nums) == 1: return nums[0]
        
        dp = [0 for _ in range(len(nums))]
        dp[0], dp[1] = nums[0], max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            
        return dp[-1]

            