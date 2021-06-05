class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        
        
        matrix = [[amount+1] * (amount+1) for i in range(len(coins)+1)]

        for k in range(len(matrix)):
            matrix[k][0] = 0
        for i in range(1,len(matrix)):
            for j in range(1,len(matrix[0])):
                if j < coins[i-1]:
                    matrix[i][j] = matrix[i-1][j]
                else:
                    matrix[i][j] = min(matrix[i-1][j], 1 + matrix[i][j-coins[i-1]])

        if matrix[len(coins)][amount] > amount: return -1
        return (matrix[len(coins)][amount])
    
    
# time and space complexities are O(m*n) where m and n are number of coins and target amount