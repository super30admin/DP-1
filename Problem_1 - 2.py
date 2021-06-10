"""
Coin Change - 1 

Time Complexity : O(m*n) n is number of denominations and m is the amount. 
Space Complexity : O(m*n)
    
"""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins or len(coins) == 0:
            return 0 
        if amount == 0:
            return 0 
        
        matrix = [[0 for _ in range(amount + 1 )] for _ in range(len(coins)+1)]
        
        m = len(matrix)
        n = len(matrix[0])
        
        for i in range(m):
            matrix[i][0] = 0
        
        for j in range(1,n):
            matrix[0][j] = float("inf") 
        
        for a in range(1,m):
            for b in range(1,n):
                
                if coins[a-1] > b:
                    matrix[a][b] = matrix[a-1][b]
                
                else:
                    matrix[a][b] = min(matrix[a-1][b], 1 + matrix[a][b - coins[a-1]])
        
        result = matrix[m-1][n-1]
        if result > amount: return -1 
        return result 
                
       