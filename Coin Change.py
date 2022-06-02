# Time Complexity : O(amount*number of coins)
# Space Complexity : O(amount*number of coins)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 0

        for i in range(1, len(dp)):
            dp[i] = amount + 1  # fill the dp array with very high val

        for i in range(1, len(dp)):
            for c in coins:
                if i >= c:
                    dp[i] = min(dp[i], 1 + dp[i - c])
        if dp[amount] == amount + 1:
            return -1
        return dp[amount]



