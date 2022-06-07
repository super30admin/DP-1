class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        '''// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
        
        #initialize rows and cols
        m=amount
        n=len(coins)
        
        #Initialize infinity
        inf=99999
        
        #Create the matrix
        dp=[[inf]*(m+1)]*(n+1)
        dp[0][0]=0
        
        
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                #If the amount to be achieved is less than the coin denomination then take the value from above
                if j  < coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                #Else select the minimum
                else:
                    dp[i][j]=min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        
        #If the solution does not exists then return -1
        if dp[n][m]>=inf:
            return -1
        #Else return the last element from the matrix
        else:
            return dp[n][m]
        
        
