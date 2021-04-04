class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [amount+1]*(amount+1)
        dp[0] = 0
        
        for coin in coins:
            for amt in range(amount+1):
                if amt < coin: continue
                dp[amt] = min(dp[amt], dp[amt-coin] + 1)

        return dp[amount] if dp[amount] < amount+1 else -1

### Complexity Analysis

# Time Complexity: O(amount * number of coins) --> Since for each coin, we go through all possible amounts in the range [0, amount]
# Space Complexity: O(amount) --> Space occupied by 1D array