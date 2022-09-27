# Time Complexity : O(mn) where n is the number of rows of the coins and m is the number of columns of amount in the matrix  
# Space Complexity : O(mn) we are creating a matrix of size mn in storing in a variable 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Yes it is difficult ot create a 2D array in python


# Your code here along with comments explaining your approach : - We create a matrix table of rows and columns and calculate the minimum number of coins required to mae that amount based on previous recursion values.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        dp = []
        for i in range(0,m+1):
            cols=[]
            for j in range(0,amount+1):
                cols.append(0)
            dp.append(cols)
        
        
        for i in range(1,n+1):
            cols= dp[0]
            cols[i] = amount+1
            dp[0] = cols
        
        for j in range(1,m+1):
            for i in range(1,n+1):
                if i<coins[j-1]:
                    dp[j][i] = dp[j-1][i]
                else:
                    dp[j][i] = min(dp[j-1][i],1+dp[j][i-coins[j-1]])
        
        if dp[m][n]>= amount+1:
            return -1
        else:
            return dp[m][n]