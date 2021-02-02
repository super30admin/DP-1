#TimeComplexity:O(NM) 
#SpaceComplexity: O(MN)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        n=len(coins)+1 #rows
        m=amount+1 #cols
        dp=[[0]*m for _ in range(n)]
        for j in range(m): #rows
            dp[0][j]=amount+1
        for i in range(n): #cols
            dp[i][0]=0
        for i in range(1,n):
            for j in range(1,m):
                if coins[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        if dp[n-1][m-1]<=amount:
            return dp[-1][-1]
        else:
            return -1
