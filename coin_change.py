#time complexity: O(mxn)
#space complexity: O(mxn)

class Solution:
    def coinChange(self, coins, amount):
        self.coins=coins
        self.amount=amount
        if(coins==None or len(coins)==0):
            return 0
        #while making matrix, columns the rows
        dp=[[0]*(amount+1)for _ in range(len(coins)+1)]
        
        for j in range(amount+1):
            dp[0][j]=amount+1
            
        
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
            
        if dp[len(coins)][amount]>amount:
            return -1
        else:
            return dp[len(coins)][amount]