"""322. Coin Change
Time Complexity - O(n*m)
Space Complexity - O(n*m)
Construct index  rows and columns
Check if coin value is less than amount then update dp with column-1 value
else find min(1+same row and go back in column as per coin  ,a row above the value)
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0]*(amount+1)]*(len(coins)+1)
        
        "Constructing row"
        for i in range(0, amount + 1):
            dp[0][i] = 99999
            
        "Constructing column"  
        for j in range(0, len(coins) + 1):
            dp[j][0] = 0
        
        "Implementation"
        for i in range(1, len(coins)+1):
            for j in range (1,amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(1 + dp[i][j-coins[i-1]], dp[i-1][j])
        
        if dp[len(coins)][amount] == 99999:
            return -1
        else:
            return dp[len(coins)][amount]
        
        