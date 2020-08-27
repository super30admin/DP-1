"""
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Time = O(amount*n)
space = O(amount) -- for dp table
Successfully excecuted on leetcode

Approach:
Bottom up iterative dynamic programming

Before calculating F(n), we have to compute all minimum counts for amounts up to n.
On each iteration ii of the algorithm F(n) is computed as min(dp[i+coin],dp[i] + 1)

"""
class Coin: 
    def coinChange(self, coins: List[int], amount: int) -> int:       
        if not amount: 
            return 0
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        print(dp)
        for i in range(amount + 1):
            for coin in coins:
                if i + coin <= amount:
                    print("i",i,"coin",coin)
                    dp[i+coin] = min(dp[i+coin],dp[i] + 1)
                    print("dp here", dp)
        print("2 : ",dp)
        
        if dp[amount] != float('inf'):
            return dp[amount]
        else:
            return -1