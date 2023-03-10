#Time Complexity: O(m * n)
#Space COmplexity: O(m * n)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        row = len(coins) + 1
        col = amount + 1
        matrix = [[0 for i in range(col)] for j in range(row)]

        for i in range(1, col):
            matrix[0][i] = col
        # print(matrix)
        for i in range(1, row):
            for j in range(1, col):
                if j < coins[i - 1]:
                    matrix[i][j] = matrix[i - 1][j]
                else:
                    matrix[i][j] = min(matrix[i][j - coins[i - 1]] + 1, matrix[i - 1][j])
        # print(matrix)
        if matrix[row - 1][col - 1] == amount + 1:
            return -1
        return matrix[row - 1][col - 1]




