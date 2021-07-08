# TC: O(AMOUNT * NUM_COINS)
# SC: O(AMOUNT)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0
        
        for c in coins:
            for i in range(1, amount+1):
                if i-c >= 0:
                    dp[i] = min(dp[i-c] + 1, dp[i])
        
        return -1 if dp[-1] == float("inf") else dp[-1]