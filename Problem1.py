# Problem 1 : Coin Change
# Time Complexity :
'''
Top-Down Approach 2d-array -  O(m*n) where m is the number of coins and n is the amount
Top-Down Approach 1d-array -  O(m*n) where m is the number of coins and n is the amount
'''
# Space Complexity :
'''
Top-Down Approach 2d-array -  O(m*n) where m is the number of coins and n is the amount
Top-Down Approach 1d-array -  O(n) where n is the amount
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# 2-D matrix
from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # length of the list of coins
        m = len(coins)
        # store the value of amount in a variable
        n = amount
        # define a dp matrix with amounts from 1 to amount in column and coins from coins list in rows
        dpMatrix = [[None for i in range((amount+1))] for j in range((len(coins)+1))]
        # initialize the first column for all the coin as 0
        for i in range(len(coins)+1):
            dpMatrix[i][0] = 0
        
        # initialize the first row ie dummy row with higher value
        for j in range(amount+1):
            dpMatrix[0][j] = 99999
        
        # loop through dp matrix from [1][1] postion to last cell in the matrix
        for i in range(1, len(dpMatrix)):
            for j in range(1, len(dpMatrix[0])):
                # check if the amount is less than the coin
                if j < coins[i-1]:
                    # if it is then just set the value of [i][j]th position as previous row values ie [i-1][j]th position
                    dpMatrix[i][j] = dpMatrix[i-1][j]
                else:
                    # else the value of [i][j]th position is minimum of previous row values ie [i-1][j]th position and (1+ value of [i][j-coins[i-1]]th position)
                    dpMatrix[i][j] = min(dpMatrix[i-1][j], 1 + dpMatrix[i][j-coins[i-1]])
        
        # if the value at last cell is greater than higher value means return -1 ie cannot make the amount
        if dpMatrix[m][n] >= 99999:
            return -1
        # else return the value of the last cell of the matrix ie minimum number of coins
        return dpMatrix[m][n]
    
# 1-d array
from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # store the value of amount in a variable
        n = amount
        # define a dp array for the amount
        dp = [99999] * (amount + 1)
        # set the 0 element of the dp array as 0 
        dp[0] = 0
        # loop through coins array
        for i in range(len(coins)):
            # loop from coins[i] to amount + 1
            for j in range(coins[i], amount+1):
                # calculate the value of dp as minimum of dp[j] and (1+ dp[j-coins[i]])
                dp[j] = min(dp[j], 1 + dp[j-coins[i]])
        # if the value at nth position is greater than 99999 then return -1 ie value can not make from the given coins
        if dp[n] >= 99999:
            return -1
        # else return the number of coins at nth position of dp array
        return dp[n]
