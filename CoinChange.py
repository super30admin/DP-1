# // Time Complexity : O(nm) where n is len(coins)+1 and m is amount+1
# // Space Complexity :O(nm)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :yes , learnt it from sir

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if (coins==[]):
            return -1
        coins=sorted(coins)
        dp=[[9999999 for j in range(amount+1)] for i in range(len(coins)+1)]
        dp[0][0]=0

        for i in range(1,len(coins)+1):
            for j in range(amount+1):
                if(coins[i-1]>j):
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=(min(dp[i-1][j],1+dp[i][j-coins[i-1]]))
                    
        if (dp[len(coins)][amount]>=9999999):
            return -1
        else:
            return dp[len(coins)][amount]
                