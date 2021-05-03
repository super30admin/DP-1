# TC: O(M x N) where M is the total amount and N is the total number of coins in input array. 
# SC: O(M x N) to store the matrix of values calculate for each combination without repetition. 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins or len(coins) == 0:
            return -1
        
        rows = len(coins) + 1
        cols = amount+1 
        dp = [[float('inf') for i in range(cols)] for j in range(rows)]     
#         Zeroing out the first row
        for i in range(rows):
            dp[i][0] = 0
            
#         Setting first row as infinity/higher amuount = amount + 1
        for j in range(1,cols):
            dp[0][j] = amount + 1
            
        # print(dp)
        
        for i in range(1, rows):
            for j in range(1, cols):
#                 Dealing with all elements where the column/amount is samller than coin
#               denomination/row value 
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
#             dealing with values equal or greater than coin denomination by calculating values from previous calculated solutions.
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][(j - coins[i - 1])] + 1)
            
#         return -1 if valid change does not exist.
        if dp[-1][-1] >= amount + 1:
            return -1
        else:
#             return ast element
            return dp[-1][-1]
