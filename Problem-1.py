## Problem1 (https://leetcode.com/problems/coin-change/)
"""
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
// Time Complexity :  O(n^2) , not sure
// Space Complexity :  O(mn) , not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

"""
def coinchange(coins, amount):
    dp=[[float('inf')]*(amount+1) for i in range(len(coins)+1)]   # create a 2d matrix dp of length + 1, to consider 0 coins or 0 amount
    if coins == None or len(coins) == 0:                          # check if coins list is empty return 0
        return 0
    for i in range(len(dp)):       # when amount = 0 we need 0 coins so insert 0 in  whole first col
        dp[i][0]=0
        
    for j in range(1,len(dp[0])):  # when coin value is 0 , we need infinite coins
        dp[0][j]=float('inf')

    # we filled our first row and first col above now start filling the dp matrix/table from index(1,1)
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            if j < coins[i-1]:  # if current coin value is greater than the amount dp[i][j] will be same dp[i-1][j]
                dp[i][j] = dp[i - 1][j]      # means copy from top
            else:
                dp[i][j]=min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
    return dp[-1][-1] if dp[-1][-1] != float('inf') else -1

print(coinchange(coins = [1, 2, 5], amount = 11))