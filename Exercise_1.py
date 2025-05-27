# Time Complexity  : O(amount * len(coins))
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

from typing import List

class Solution:

    def coinChange(self, coins: List, amount: int) -> int:

        #Tabulation

        if amount == 0:
            return 0

        if len(coins) == 1:
            if amount % coins[0] == 0:
                return amount // coins[0]
            else:
                return -1

        INF = amount + 1
        dp = [INF] * (amount + 1)
        dp[0] = 0

        for r in range(amount + 1):
            for c in coins:
                if c <= r:
                    dp[r] = min(dp[r], dp[r-c] + 1)

        return dp[amount] if dp[amount] != INF else -1

#---------------------------------------------------------------------

        #Memoization
        # n = len(coins)

        # if amount == 0:
        #     return 0

        # if n == 1:
        #     if amount % coins[0] == 0:
        #         return amount // coins[0]
        #     else:
        #         -1

        # memo = [[-1] * (amount + 1) for _ in range(n)]

        # INF = float("inf")

        # def helper(i, rem):

        #     if rem == 0:
        #         return 0
            
        #     if i == n or rem < 0:
        #         return INF
            
        #     if memo[i][rem] != -1:
        #         return memo[i][rem]
            
        #     take = 1 + helper(i, rem - coins[i])
        #     skip = helper(i + 1, rem)

        #     memo[i][rem] = min(take, skip)
        #     return memo[i][rem]

        # ans = helper(0, amount)
        # return ans if ans != INF else -1

#---------------------------------------------------------------------

        #Recursive    
        # n = len(coins)

        # if amount == 0:
        #     return 0

        # if n == 1:
        #     if amount % coins[0] == 0:
        #         return amount // coins[0]
        #     else:
        #         -1

        # INF = float("inf")

        # def helper(i, rem):

        #     if rem == 0:
        #         return 0
            
        #     if i == n or rem < 0:
        #         return INF
                
        #     take = 1 + helper(i, rem - coins[i])
        #     skip = helper(i + 1, rem)

        #     best = min(take, skip)
        #     return best

        # ans = helper(0, amount)
        # return ans if ans != INF else -1


if __name__ == "__main__":

    sol = Solution()
    # Example 1
    print(sol.coinChange([1, 2, 5], 11))  # expected 3  (5+5+1)
    # Example 2
    print(sol.coinChange([2], 3))         # expected -1 (cannot make 3)
    # Additional tests
    print(sol.coinChange([1], 0))         # expected 0  (zero amount needs zero coins)
    print(sol.coinChange([1], 1))         # expected 1
    print(sol.coinChange([1], 2))         # expected 2






