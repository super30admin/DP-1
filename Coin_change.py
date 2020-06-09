class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins:
            return -1
        x = len(coins)+1
        y = amount+1
        matrix = [[0 for p in range(y)] for q in range(x)]
        for i in range(1,y):
            matrix[0][i] = 99999
            
        for i in range(1,x):
            for j in range(y):
                if j>=coins[i-1]:
                    matrix[i][j] = min(matrix[i-1][j], (matrix[i][j-coins[i-1]])+1)
                else:
                    matrix[i][j] = matrix[i-1][j]
                    
        min_val = matrix[0][-1]
        for i in range(1,x):
            if matrix[i][-1]<min_val:
                min_val = matrix[i][-1]
                
        return min_val if min_val != 99999 else -1


#time complexity - O(m*n), dimensions for the dp matrix as filling out each cell
#space complexity - O(m*n) as the dp matrix used for the problem
#all test cases passed