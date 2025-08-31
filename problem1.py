"""
Space Complexity: O(n) where n is the amount of coins 

Time Complexity: O(m * n) 

"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        INF = 10 ** 20 
        dp = [0 for _ in range(amount+1)] 

        # Rows are the coins, columns is the amount 

        # fill the first row to be INFINITY to assure the base case 

        for i in range(1, amount+1): 
            dp[i] = INF
        
        for i in range(1, len(coins)+1): 
            for j in range(1, amount+1): 

                if coins[i-1] <= j:
                    dp[j] = min(dp[j] , 1 + dp[j - coins[i-1]])

        return -1 if dp[-1] == INF else dp[-1]
                
