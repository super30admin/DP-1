# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : y
# Any problem you faced while coding this : n


# Your code here along with comments explaining your approach

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        if not coins:
            return 0
        
        m = len(coins) + 1
        n = amount + 1
        
        dp = [[0 for x in range(n)] for y in range(m)] 
        
        
        # filling the first row
        # if we fill with infinity, it might lead to errors
        for i in range(1, amount+1):
            dp[0][i] = amount + 1 # amout +1 will never occur
            
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                
                # current amount < denomination
                # eg if you have [1,2,5]. basically on fourth row when filling for 5
                # if the amount required is less than 5, we will frtch value from above
                if(j< coins[i-1]): # checking for denomination
                    dp[i][j] = dp[i-1][j]
                
                # choose or dont choose
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1]]+1)
                    
        if dp[len(coins)][amount] == amount+1:
            return -1
        else:
            return dp[len(coins)][amount]
                