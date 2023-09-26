#Time complexity: O(N*M)
#Space complexity:O(N*M)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) ==0:
            return -1
        
        #length of rows
        m=len(coins)

        #length of columns
        n=amount

        #assigining zero's for  first columns
        dp=[[0] * (n+1)]*(m+1)

        #assigining values for first rows
        for j in range(1, n+1):
            dp[0][j]=amount + 1 
        

        for i in range(1,m+1):
            for j in range(1, n + 1):
                #zero or do not choose case
                if j < coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
        
        if dp[m][n]==amount + 1:
            return -1
        return dp[m][n]
        