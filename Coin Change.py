# Time Complexity : O(m*n)
# Space Complexity : O(m)
# Did this code successfully run on Leetcode :


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:


        dp_matrix = [[None for i in range((amount + 1))] for j in range(len(coins) + 1)]
        for i in range(len(coins) + 1):
            dp_matrix[i][0] = 0
        for j in range(1, len(dp_matrix[0])):
            dp_matrix[0][j] = 999999
        for i in range(1, len(dp_matrix)):
            for j in range(1, len(dp_matrix[0])):
                if j < coins[i - 1]:
                    dp_matrix[i][j] = dp_matrix[i - 1][j]
                else:
                    dp_matrix[i][j] = min(dp_matrix[i - 1][j], dp_matrix[i][j - coins[i - 1]] + 1)
        if dp_matrix[len(coins)][amount] >= 999999:
            return -1
        return dp_matrix[len(coins)][amount]