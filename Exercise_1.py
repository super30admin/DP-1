# Problem1 (https://leetcode.com/problems/coin-change/)


# // Time Complexity :2^(m + n)
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins, amount):
        if not coins:
            return -1 if amount > 0 else 0
        m = len(coins)
        n = amount
        dp = [[amount + 1] * (n + 1) for _ in range(m + 1)]
        for i in range(m + 1):
            dp[0][i] = 0
        for i in range(m + 1):
            for j in range(1, n + 1):
                # till amount is less than denomination
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        return -1 if dp[m][n] > amount else dp[m][n]


sol = Solution()
coins = [1, 2, 5]
amount = 11
print(sol.coinChange(coins, amount))


# # // Time Complexity :2^(m + n)
# # // Space Complexity :
# # // Did this code successfully run on Leetcode :
# # // Any problem you faced while coding this :


# # // Your code here along with comments explaining your approach
# class Solution:
#     def coinChange(self, coins, amount):
#         if len(coins) == 0:
#             return 0
#         result = self.helper(coins, amount, 0, 0)
#         return result if result != float('inf') else -1

#     # coins, amount sum, index, number of coins used
#     def helper(self, coins, amount, i, coinsUsed):
#         # base case
#         if amount == 0:
#             return coinsUsed
#         if amount < 0 or i == len(coins):
#             return float('inf')

#         # main logic
#         # case 1: choosing the coin
#         case1 = self.helper(coins, amount - coins[i], i, coinsUsed+1)

#         # case 0: not choosing the coin
#         case0 = self.helper(coins, amount, i+1, coinsUsed)

#         return min(case1, case0)


# sol = Solution()
# coins = [1, 2, 5]
# amount = 11
# print(sol.coinChange(coins, amount))
