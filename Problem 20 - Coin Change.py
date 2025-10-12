# 322. Coin Change

# Time Complexity: O(n*amount)
# Space Complexity: O(n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        dp = [float('inf') for i in range(amount + 1)]

        dp[0] = 0

        for i in range(1, n + 1):
            for j in range(1, amount + 1):
                if j >= coins[i-1]:
                    dp[j] = min(dp[j],1+dp[j-coins[i-1]])
        
        return -1 if dp[amount] == float('inf') else dp[amount]
    