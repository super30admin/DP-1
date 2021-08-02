#Leetcode problem: 322
class Solution:
    def coinChange(self, coins, amount):
        dp=[[0]*(amount+1)]*(len(coins)+1)
        for i in range(1,amount+1):
            dp[0][i]=amount+1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j<coins[i-1]: #copying all values above
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1) #taking minimum from above or value at remaining amount+1
        if dp[-1][amount]!=amount+1:
            return dp[-1][amount]
        return -1

#TC: O(m*n) where m is number of rows and n is number of columns
#SC: O(m*n)