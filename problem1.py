#coin-change
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp_matrix = [[None for _ in range(amount + 1)] for _ in range(len(coins) + 1)]

    # Fill base cases
        for i in range(len(coins) + 1):
            dp_matrix[i][0] = 0 
        for j in range(1, len(dp_matrix[0])):
            dp_matrix[0][j] = float('inf') 

    # Fill the DP matrix
        for i in range(1, len(dp_matrix)):
            for j in range(1, len(dp_matrix[0])):
                if j < coins[i - 1]:
                    dp_matrix[i][j] = dp_matrix[i - 1][j]
                else:
                    dp_matrix[i][j] = min(
                        dp_matrix[i - 1][j],              
                        dp_matrix[i][j - coins[i - 1]] + 1)

        result = dp_matrix[-1][-1]
        return -1 if result == float('inf') else result