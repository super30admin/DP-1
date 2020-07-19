# https://leetcode.com/problems/coin-change/

# // Time Complexity : o(row*col) , row = number of coins + 1, col = amount+1
# // Space Complexity : o(row*col) , row = number of coins + 1, col = amount+1
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : I got so lost in the indexing....
#
#
# // Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        MAX = 99999
        coins.insert(0, 0)
        row, col = len(coins), amount + 1
        dp = [[None for i in range(col)] for j in range(row)]

        # initialize
        for i in range(col):
            dp[0][i] = MAX
        for i in range(row):
            dp[i][0] = 0

        for i in range(1, row):
            for j in range(1, col):
                if j < coins[i]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i]] + 1)
        if dp[row - 1][col - 1] == MAX:
            return -1
        else:
            return dp[row - 1][col - 1]
