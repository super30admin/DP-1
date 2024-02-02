'''
Time Complexity - O(n*m) where n is number of denominations and m is the target amount
Space Complexity - O(n*m). We are using a 2D array to store the result at particular value

This code works on leetcode.
'''

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for j in range(amount+1)] for i in range(len(coins)+1)] #create a DP 2D Array
        dp[0][0] = 0 #for denomination 0 and target 0 you need 0 coins
        for j in range(1, amount + 1):
            dp[0][j] = 1e9 #for denomination of 0 and target 1 - 11 you will need infinite number of coins
        for i in range(1, len(coins)+1):
            dp[i][0] = 0 #Any denomination target 0, min number of coins required is 0
        for i in range(1, len(coins)+1): #Iterate from the first denomination (at index 0 we have 0)
            for j in range(1, amount+1): #Iterate for all target values from 1
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j] #copy the values from the row above until the target is less than the denomination
                else:            
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j - coins[i-1]]) #else 1 + min of value same column row above and same row - the denomination.
        return dp[len(coins)][amount] if dp[len(coins)][amount] < 1e9 else -1 #return the value at the last column in last index
