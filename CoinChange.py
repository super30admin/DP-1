# Time Complexity : O(n * m)
# Space Complexity : O(n * m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        m = amount
        # Initialize DP table
        dp = [[0 for _ in range(m+1)] for _ in range(n+1)]

        # Edge case
        if not coins:
            return -1

        # First row except for dp[0][0] set to a high value (infinity can also be used)
        for j in range(1, m+1):
            dp[0][j] = float('inf')

        for i in range(1, n+1):
            for j in range(1, m+1):
                # Case 0: If the amount (j) is less than the coin denomination (coins[i-1])
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # Case 1: We compare the value from the previous row with the value from
                # the current row at position j minus the denomination of the coin plus one
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)

        # If dp[n][m] is still set to the initial high value, return -1, else return dp[n][m]
        return dp[n][m] if dp[n][m] != float('inf') else -1
            