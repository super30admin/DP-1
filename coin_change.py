"""
Memoization
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[-1 for i in range(amount+1)]for j in range(len(coins))]
        def func(idx, target):
            if target == 0:
                return 0
            if idx>=len(coins) or target<0:
                return float('inf')

            if dp[idx][target]!=-1:
                return dp[idx][target]
            choose = 1+func(idx, target-coins[idx])
            not_choose = func(idx+1, target)

            dp[idx][target] = min(choose, not_choose)
            return dp[idx][target]
        res = func(0,amount)
        return res if res!=float('inf') else -1

"""
# Tabulation
"""
TC -> O(C*A) where C = len(coins)+1 and A = amount+1
SC -> O(C*A)
Used the recursive method initially -> led to TLE
Then used memoization and finally arived at Tabulation solution.
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[float('inf') for i in range(amount+1)]for j in range(len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0] = 0
        for i in range(1,len(coins)+1):
            coin = coins[i-1]
            for amt in range(1,amount+1):
                if coin>amt:
                    dp[i][amt] = dp[i-1][amt]
                else:
                    dp[i][amt] = min(dp[i-1][amt],1+dp[i][amt-coin])
        return dp[len(coins)][amount] if dp[len(coins)][amount]!=float('inf') else -1