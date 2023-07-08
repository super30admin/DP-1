# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m=amount
        n=len(coins)
        matrix=[[0 for columns in range(m+1)] for rows in range(n+1)]

        for j in range(m+1):
            matrix[0][j]=99999

        for i in range(n+1):
            matrix[i][0]=0

        for i in range(1,n+1):
            for j in range(1,m+1):
                if j < coins[i-1]:
                    matrix[i][j]=matrix[i-1][j]
                else:
                    matrix[i][j]=min(matrix[i-1][j],matrix[i][j-coins[i-1]]+1)
        #print(matrix)

        if matrix[n][m]==99999:
            return -1
        else: 
            return matrix[n][m]