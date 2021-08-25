# Time Complexity : O (m * n)  where m is number of rows, n is number of columns
# Space Complexity : O (m * n) for the dp matrix
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : I took a little time to 
# figure out how to correctly declare the 2d dp matrix in python


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or coins is None:
            return 0
        
        dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins) + 1)]
        
        for j in range(1, len(dp[0])):  # for top row
            dp[0][j] = amount + 1  # not inf due to overflow if inf + 1
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                
                # the zero case, amount < denomination of coin
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                
                # zero and one case
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
        
        if dp[len(dp) - 1][len(dp[0]) - 1] > amount:
            return -1
        return dp[len(dp) - 1][len(dp[0]) - 1]