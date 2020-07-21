"""
Approach

1. To find the minimum number of coin to reach the target, we can start with finding the minimum number of coins to to get the sum of 0,1, 2, 3 etc
2. we can arrive at optimal solution by solving the sub-problems
3. we create a Dp matrix with row header as coin denominations and column header as target sum from 0 to target amount
4. at each step we either choose to use the new coin or we dont choose to use the coin, we take the minimum amount these value to arrive at the optimal solution

"""


# Time Complexity : O(n*T) where n is the number of coins and T is the target amount 
# Space Complexity : O(n*T) where n is the number of coins and T is the target amount
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows,columns = len(coins)+1, amount+1
        dp = [[None for j in range(columns)] for i in range(rows) ]
        
        for i in range(rows):
            dp[i][0]= 0
        for j in range(1,columns,1):
            dp[0][j]= 99999
        for i in range(1, rows,1):
            for j in range(1,columns,1):
                if (j<coins[i-1]):
                    dp[i][j]  = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j] ,1+dp[i][j-coins[i-1]])
        output = dp[len(coins)][amount]
        
        if output>=99999:
            return -1
        else:
            return output