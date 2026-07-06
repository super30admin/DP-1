from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        # dp = [0,1,1,2,2,1,2,2,3,3,2,3]

        for a in range(1, amount + 1):
            for c in coins:
                if a - c >= 0:
                    dp[a] = min(dp[a], 1 + dp[a - c])

        if dp[-1] != (amount + 1):
            return dp[-1]
        return -1

   # A = amount
   # N = number of coins
    # TC = O(A+N)
    # SC = O(A) DP array has amount+1 number of entries