
# Time Complexity - O(mn)
# Space Complexity - O(mn)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount 
        matrix = [[0 for i in range(n+1)] for i in range(m+1)]

        matrix[0][0] = 0 
        for j in range(1,n+1): 
            matrix[0][j] = amount + 1 
        for i in range(1,m+1): 
            for j in range(1,n+1):
                if(coins[i-1] > j) : 

                        matrix[i][j] = matrix[i-1][j] 
                else : 
                    matrix[i][j] = min(matrix[i-1][j], matrix[i][j-coins[i-1]]+1) 
        if matrix[m][n] >= amount + 1 : 
            return -1 
        return matrix[m][n]

