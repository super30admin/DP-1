'''
Time Complexity : O(m*n) where m is number of denominations and n is required amount
Space Complexity: O(n) where n is required amount (Using 1D DP)
Run on LeetCode : YES
Problems: Took some time to compress 2D DP to 1D DP
'''
class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        col = amount + 1
        dp = [999999] * col
        dp[0] = 0
        for i in range(len(coins)):
            for j in range(1, col):
                if not j < coins[i]:
                    dp[j] = min(dp[j], 1 + dp[j - coins[i]])
        if dp[col - 1] >= 999999:
            return -1
        return dp[col-1]