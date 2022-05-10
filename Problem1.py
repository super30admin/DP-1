#Time Complexity: O(mn)
#Space Complexity: O(mn)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [[amount+1 for i in range(amount+1)] for j in range(len(coins)+1)]
        
        dp[0][0] = 0
        
        for i in range(1,len(dp)):
            for j in range(amount+1):
                
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
                    
        if dp[-1][-1] > amount:
            return -1
        else:
            return dp[-1][-1]
                   
                   