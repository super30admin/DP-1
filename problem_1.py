# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def coinChange(self, coins, amount):
        rows = len(coins) + 1
        columns = amount + 1
        # creating dp
        dp = []
        for i in range(rows):
            dp.append([0]*columns)
        # assigning max value to the columns in dummy row
        for i in range(1, columns):
            dp[0][i] = amount + 1
        # updating the rows to find the minimum coins
        for i in range(1, rows):
            for j in range(columns):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)
        if dp[-1][-1] > amount:
            return -1
        return dp[-1][-1]


check = Solution()
print(check.coinChange([1, 2, 5], 11))


# class Solution:
#     def choose(self, coins, amount, index, min_coins):
#         if amount == 0:
#             return min_coins
#         elif amount < 0 or index >= len(coins):
#             return -1
#         case1 = self.choose(coins, amount, index+1, min_coins)
#         case2 = self.choose(coins, amount-coins[index], index, min_coins + 1)
#         if case1 == -1:
#             return case2
#         if case2 == -1:
#             return case1
#         return min(case1, case2)
#
#     def coinChange(self, coins: list[int], amount: int) -> int:
#         return self.choose(coins, amount, 0, 0)
#
#
# check = Solution()
# print(check.coinChange([1, 2, 5], 11))

