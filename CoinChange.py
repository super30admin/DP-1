# Time Complexity: O(2^n+m)
# Space Complexity: O(2^n+m)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: Figuring out the edge case

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        
        if coins == None or len(coins) == 0:
            return -1
        
        n = len(coins)
        inf = amount + 5 # this is the inifinity value which is filled in the top row with 0 coin value. You can add up any value

        # design the matrix with 0 values
        dp = [[0] * (amount + 1)] * (n+1) # adding 1 to both amount and n to have the dummy row and column
        
        # adding infinity to the first row
        for i in range(1,amount + 1): # iterating through columns in matrix
            dp[0][i] = inf

        # adding all values in the matrix
        for i in range(1, n+1): # iterating through each row. Starting from 1 because row 0 is filled with infinity value
            for j in range(1, amount + 1): # iterating through columns. Starting with 1 because col 0 is filled with 0
                if j < coins[i-1]: # if the amount is less than the coin denomination. (we to i-1 as i is the index in matrix which is 1 index larger than index in coins array)
                    dp[i][j] = dp[i-1][j] # this is the "just above" value from matrix
                else:
                    dp[i][j] = min((dp[i][j - coins[i-1]] + 1), dp[i-1][j]) # minumum between the values at (same row and [number of coin denomination] steps back in matrix + 1) and ("just above" in matrix)
        
        if dp[n][amount] == inf: # if the value at last row and last column is infinity. This happens where the input has only 1 coin denomination and amount required cannot be generated with that denomination Eg. Coins = [2] | amount = 3
            return -1
        else:
            return dp[n][amount]