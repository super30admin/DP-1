# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
## we need to find out the minimum number of coins we need to use to get to the amount. at each stage we have two choices,
## either we can chose the coin or not for a particular amount, we select it based on which one gives the minimum nuber of coins to make that amount. 
## so for a cell, we see if we dont use the coin, then make the amount with the previously available coins , and if we choose this coin, get the number of coins that we can make 
## to amount - coin and add 1 to it. in the end find the minimum. 
##return the last element

class solution:
    def coinChange(self, coins, amount):
        dp = [[float("inf")]* amount+1 for _ in range(len(coins)+1)]

        for i in range(len(coins)+1):
            dp[i][0] =0
        
        for row in range(1, len(coins)+1):
            for col in range(1, amount+1):
                if (col < coins[row-1]):
                    dp[row][col] = dp[row-1][col]
                else:
                    dp[row][col] = min(dp[row-1][col], 1+dp[row][col-coins[row-1]])
        
        return dp[-1][-1]

    def coinChange_Single(self, coins, amount):
        dp = [float("inf")*amount+1]
        dp[0]=0
        for coin in coins:
            for col in (coin, amount+1):
                dp[col] = min(dp[col] , 1+dp[col-coin])
        
        return dp[-1]
                    



