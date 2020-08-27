# // Time Complexity :  O(n*m)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int: 
        
        # initialize the matrix  
        dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins) + 1)]
        
        # set zero as zero #of coins can be used to sum the amount 
        for i in range(len(coins)):
            dp[i][0] = 0
            
        # set intmax, if no coins, no number of coins can amount to anything
        for j in range(1, amount+1):
            dp[0][j] = 99999

        # if amount is greater than the coin denomination, copy the value from (i-1) index
        # else, get the minimum of the values if the coin denomination was chosen(1)+ the already calculated value(minimum number of coins used to calculate: amount-chosen denomination) 
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j< coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        
        if dp[len(coins)][amount] >= 99999:
            return -1
        else:
            return dp[len(coins)][amount]
        
        
        