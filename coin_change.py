"""
Approach1:
Recursive solution, using exhaustive approach. For each call, we decide if we select the coin[indx] or not,
if we do, add 1 to count and subtract value from the amount. If we select the coin, index stays the same, and
else index+1

TC: Exponential
SC: Stack space
"""
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.helper(coins, amount, 0, 0)

    def helper(self, coins: List[int], amount: int, index: int, count:int) -> int:
        # base case
        # we can't make exact amount or index is out of bounds
        if  amount < 0 or index >= len(coins):
            return -1
        # we made the correct amount. return count
        if amount == 0:
            return count
        
        case1 = self.helper(coins, amount-coins[index], index, count+1)
        case2 = self.helper(coins, amount, index+1, count)
        # if any of the case returns -1 then return the other case
        if case1 == -1: return case2
        if case2 == -1: return case1
        # else return minimum of two counts
        return min(case1, case2)
    
"""

"""Approach2:
Build a table - tabulization - bottom up DP

Rows would be range(0, coins) and columns (0,target)

0th row is value greater than maximum coin demonition or some other random big number
0th column is all 0s
Loop i and j over rows and columns from index 1 and build the table
For each dp[i][j]  value would be min(dp[i-1][j], 1+dp[i][j - coins[i-1]])


e.g. table for [1,2,5], target=11
      0      1      2      3      4      5      6      7      8      9     10     11
0     0     50     50     50     50     50     50     50     50     50     50     50
1     0      1      2      3      4      5      6      7      8      9     10     11
2     0      1      1      2      2      3      3      4      4      5      5      6
5     0      1      1      2      2      1      2      2      3      3      2      3

TC: O(n^2) time for 2 loops that are nested
SC: O(len(coins)*amount) for the DP matrix so O(n^2)
"""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m, n = len(coins)+1, amount+1
        # initialize first row for column 0 through 11 (total 12) taking example from comment above
        dp = [[99999]*n]
        for i in range(1,m):
            dp.append([0]*n)
        # first index in first row+col should be 0 as there are 0 ways to make 0 with 0 coin
        dp[0][0] = 0
        for i in range(1,m):
            for j in range(1,n):
                if j < coins[i-1]:  # j is less than denomination of the coin
                    # we use coins[i-1] because in our DP array we assume coins are [0,1,2,5] but in reality its only [1,2,5]
                    dp[i][j] = dp[i-1][j]           # to accommodate that, when we are on 1st index in dp table row, we should be looking at 0th index in coins array
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
        
        return dp[m-1][n-1] if dp[m-1][n-1] !=99999 else -1

