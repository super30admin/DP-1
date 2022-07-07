# Time Complexity: O(m*n)
# Space Complexity: O(m*n) max depth of recursion
# Dynamic Programming repeated sub problems
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows = len(coins)+1
        cols = amount+1
        dp_matrix = [[0]*cols]*rows
        #print(dp_matrix)
        for j in range(1, cols):
            dp_matrix[0][j] = amount + 1
        for i in range(1, rows):
            for j in range(1, cols):
                if j < coins[i-1]:
                    dp_matrix[i][j] = dp_matrix[i-1][j]
                else:
                    dp_matrix[i][j] = min(dp_matrix[i-1][j], dp_matrix[i][j - coins[i-1]] + 1)
        #print(dp_matrix)
        if dp_matrix[rows-1][cols-1] == amount +1:
            return -1
        else:
            return dp_matrix[rows-1][cols-1]
            