#Time Complexity : O(m*n) ... where m is the number of coins and n is the range for the amount
#Space Complexity : O(m*n) ... where m is the number of coins and n is the range for the amount
#Any problem you faced while coding this : faced some difficulty in understanding the path selection based on coin denomination.

# Used the bottom up tabulation method of dynamic programming programming. Referenced a table where the previously solved sub-problem values were used to iteratively build the soltuion.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for _ in range(amount+1)]for _ in range(len(coins)+1)]
        for col in range(1,amount+1):
            dp[0][col] = 99999
        
        for row in range(1,len(coins)+1):
            for col in range(1,amount+1):
                if coins[row-1] > col:
                    dp[row][col] = dp[row-1][col]
                else:
                    dp[row][col] = min(dp[row-1][col], 1 + dp[row][col - coins[row-1]])
        
        if dp[len(coins)][amount] >= 99999:
            return -1
        else:
            return dp[len(coins)][amount]