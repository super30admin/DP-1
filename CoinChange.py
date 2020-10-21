#Time Complexity : O(mn) where m is the length of input array i.e. number of coins and n is amount
#Space Complexity : O(mn) where m is the length of input array i.e. number of coins and n is amount
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #DP
        if coins == None or len(coins) == 0:
            return -1

        dp = [[99999 for _ in range(amount+1)]for _ in range(len(coins)+1)]

        rows, cols = len(dp), len(dp[0])

        dp[0][0] = 0

        for r in range(1, rows):
            for c in range(cols):
                if coins[r-1] > c:
                    dp[r][c] = dp[r-1][c]
                else:
                    dp[r][c] = min(dp[r-1][c], 1 + dp[r][c-coins[r-1]])


        return dp[rows-1][cols-1] if dp[rows-1][cols-1] < 99999 else -1

        #RECURSIVE - TLE
#         def helper(coins, amount, index, minCoins):
#             if amount == 0:
#                 return minCoins

#             if amount < 0 or index >= len(coins):
#                 return -1

#             #choose coin at index
#             choose = helper(coins, amount - coins[index], index, minCoins+1)
#             #don't choose coin at index
#             dontChoose = helper(coins, amount, index + 1, minCoins)

#             if choose == -1:
#                 return dontChoose
#             elif dontChoose == -1:
#                 return choose

#             return min(choose, dontChoose)

#         return helper(coins, amount, index=0, minCoins=0)
