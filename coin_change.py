# tc: O(mn)
# sc: O(mn)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[amount + 1]* (amount+1)]*(len(coins) + 1)
        #print(dp)
        # fill the zero coin's problem
        for i in range(1, len(coins) + 1):
            dp[i][0] = 0
            
        
        for i in range(1,len(coins) + 1):
            denomination = coins[i-1]
            for j in range(1, amount + 1):
                if denomination > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min( dp[i-1][j], dp[i][j-denomination] + 1)
                    
        result = dp[len(coins)][amount]
        if result > amount:
            return -1
        return result
        