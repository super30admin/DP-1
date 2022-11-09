'''
Time Compelxity-->
O(m*n) where m is number of coins and n is amount

Space Complexity-->
O(m*n) for the 2d array created

'''

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[[0 for i in range((amount+1))] for x in range(len(coins)+1)]
        
        i = 0
        for j in range(1,amount+1):
            dp[i][j]=float('inf')
        
        for i in range(1,len(coins)+1):
            for j in range(1, amount+1):
                if j>=coins[i-1]:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
                else:
                    dp[i][j] = dp[i-1][j]
        if dp[-1][-1] ==float('inf'):
            return -1
        else:
            return dp[-1][-1]
                    
                    
        
                
        
        