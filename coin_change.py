// Time Complexity :o(mk)
// Space Complexity :o(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows=len(coins)+1
        cols=amount+1
        dp=[[None for i in range(cols)] for j in range(rows)]
        for i in range(rows):
            dp[i][0]=0
        for j in range(1,cols):
            dp[0][j]=9999
        
        
        for i in range(1,rows):
            for j in range(1,cols):
                #print(coins[i-1],j)
                if coins[i-1] > j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)
                    
        if dp[rows-1][cols-1]==9999:
            return -1
        else:
            return dp[rows-1][cols-1]
