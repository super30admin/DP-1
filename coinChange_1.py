# Time Complexity : O(MN) where M is the amount and N is number of coins
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, getting the loop right without going out of bound
class Solution:
    def coinChange(self, coins: [int], amount: int) -> int:
        # edge case
        if not amount or len(coins) == 0:
            return 0
        dp = [amount + 1] * (amount + 1)  # number of coins required to get amount
        for i in range(amount + 1):
            if i in coins:
                dp[i] = 1
                continue
            den = [dp[i - coin] + 1 for coin in coins if i - coin > 0]
            if den:
                dp[i] = min(den)

        return -1 if dp[amount] > amount \
            else dp[amount]


r = Solution()
coins, amount = [1, 2, 5], 11
print("Result:", r.coinChange(coins, amount))
