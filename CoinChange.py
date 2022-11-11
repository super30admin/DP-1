#Time Complexity : O(amount * len(coins))
#Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No

# Approach: Creating a dp array that mainly records the minimum number of coins for each amount
# coins = [1,2,5] and amount = 11
# Here amount = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
#          dp = [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3 ]
# when amount is equal to 0, the coin we need is 0
# dp[0] == 0
# dp[1] = 1
# dp[2] = 1 and similarly, 
# dp[11] = 3

from typing import List
class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount + 1):
            for c in coins:
                if i - c >= 0:
                    dp[i] = min(dp[i], dp[i - c])
        return dp[amount] if dp[amount + 1] != amount + 1 else -1