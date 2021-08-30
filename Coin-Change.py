#Time Complexity: O(amount * len(coins))
# Space COmplexity: O(amount)
# Did you find this problem on leetcode: Yes
# Approach to solve this problem:
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)                               # Initializing dp array
        dp[0] = 0                                                      # Base Case
        
        for a in range(1, amount + 1):                                 
            for c in coins:
                if a - c >= 0:
                    dp[a] = min(dp[a], 1 + dp[a - c])                  # Get minimum of itself and the computation of amount - coins
        return dp[amount] if dp[amount] != amount + 1 else -1          # Return amount if its not default(Edge case)
        