#Time Complexity - O(n * k)  where n is number of coins and k is amountx
#Space Complexity - O(k) where k is amount

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0

        for i in coins:
            for j in range(i, amount + 1):
                dp[j] = min(1 + dp[j - i], dp[j])
                
        return dp[amount] if dp[amount] != float('inf') else -1