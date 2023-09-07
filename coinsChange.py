class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return -1
        
        row = len(coins) + 1
        col = amount + 1
        dp = [[0 for i in range(col)] for j in range(row)]
        
        for j in range(col):
            dp[0][j] = amount + 1
            
        for i in range(1,row):
            for j in range(1,col):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)
        
        return -1 if dp[row-1][col-1] > amount else dp[row-1][col-1]
    
# TC: O(n*m)
# SC: O(n*m)