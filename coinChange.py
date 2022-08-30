# Time Complexity: O(2^n) : Exponential
# Space Complexity: O(1)

# Recursion solution. Keep on building on the exhaustive approach of Choosing or not choosing a particular coin.

# The base case would be when the remaining amount is 0 -> we return minCoins
# Or if amount is negative, or the index is out of bounds


# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
# #         Exhaustive -> Choose or Not Choose

#         return self.helper(coins, 0, amount, 0)

#     def helper(self, coins: List[int], i: int, amount: int, minCoins: int) -> int:

# #         Base Case
#         if amount == 0:
#             return minCoins
#         if (amount < 0) or (i == len(coins)):
#             return -1
# #         Choose

#         case1 = self.helper(coins, i, amount - coins[i], minCoins + 1)
#         case2 = self.helper(coins, i + 1, amount, minCoins)
#         if case1 == -1:
#             return case2
#         if case2 == -1:
#             return case1

#         return min(case1, case2)


# DP Approach

# Time Complexity: O(mn)
# Space Complexity: O(mn) : Because we create the DP table 2-D array

# DP is just an extension of the Recursion tree, where we represent repeated subproblems on the Decision making variables


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #         Exhaustive -> Choose or Not Choose

        n = amount
        m = len(coins)

        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]

        for i in range(1, len(dp[0])):
            dp[0][i] = 9999999
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    # We take the minimum from the row above, and adding 1 to the calculated subproblem at location column - coin amount
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        if dp[m][n] >= 9999999:
            return -1
        else:
            return dp[m][n]
