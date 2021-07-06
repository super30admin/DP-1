"""
// Time Complexity : o(n*m), where n is the amount and m is the size of coins array
// Space Complexity : o(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
"""


class Solution(object):
        
    
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        inf = amount + 1
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)] #DP matrix
        
        
        for i in range(1,amount+1):
            dp[0][i] = inf #setting the first row to inf, dummy row
        
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]: #if amount it less than the denomination, copy previous values
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] +1) #else, put min out of the value above and value present at position we get after subtracting denomination value from current position 
        res = dp[len(coins)][amount]  # last value in the matrix is the result 
        
        if res >= inf: #when there is no possible solution
            return -1
        return res
            
        