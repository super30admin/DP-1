#Time Complexity: O(mn) -> m: coins, n: amount
#Space Complexity: O(n) ->  n: amount

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] * (amount + 1)
        for i in range(1, amount + 1):
            min_dp = amount + 1
            for c in coins:
                diff = i - c
                if diff >= 0:
                    min_dp = min(min_dp, 1 + dp[diff])
            dp[i] = min_dp
        return -1 if dp[amount] == amount +1 else dp[amount]