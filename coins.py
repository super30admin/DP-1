class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #initializing dp matrix
        dp=Matrix = [[0 for x in range(amount+1)] for y in range(len(coins)+1)] 
        #assigning 1st column with 0
        for i in range(len(coins)+1):
            dp[i][0]=0
        #assigning first row with inf
        for j in range(1,amount+1):
            dp[0][j]=9999
        #generating a dp matrix
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],(1+dp[i][j-coins[i-1]]))
        if dp[len(coins)][amount]==9999:
            return -1
        else:
            return dp[len(coins)][amount]