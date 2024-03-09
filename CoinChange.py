# Time Complexity : O(m*n) (where m is the amount to be made, n is the no of elements in coin array)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #Initialize a 2d array
        n = len(coins)
        #Initialize a 2d array
        dp = [[float('inf')]*(amount+1) for _ in range(n+1)]
        #Initialize column 0 to 0, as no.of coins need to make amount 0 is 0
        for i in range(n + 1):
            dp[i][0] = 0
        for i in range(1,n+1):
            for j in range(1,amount+1):
        #If the amount to be made is less than the coin
                if coins[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)

        if dp[-1][-1] == float('inf'):
            return -1
        else:
            return dp[-1][-1]