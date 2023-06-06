# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to solve it by solving repeated sub problems by constructing a 2D matrix 
# and store all the min combination to construct the sum and return the last value of the matrix.


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        nrows = len(coins) + 1
        ncols = amount + 1
        
        dp = [[99999 for _ in range(ncols)] for _ in range(nrows)]
        
        for j in range(1, nrows):
            dp[j][0]=0
        
        for i in range(1,nrows):
            for j in range(1,ncols):
                if coins[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
                
        if(dp[-1][-1] == 99999): 
            return -1
        return dp[-1][-1]
