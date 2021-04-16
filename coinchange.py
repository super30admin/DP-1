class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        '''
        TC: O(n * m) -- O(amount * number of coins)
        SC: O(n) -- O(amount)
        Approach: maintaining DP array for storing the minimum number coin required at that amount.
        for each coin at evry amount 
        dp[j] = min(dp[j],dp[j-coin] + 1)

        '''
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for j in range(coin,amount+1):
                dp[j] = min(dp[j], dp[j-coin]+1)

        return dp[amount] if dp[amount] != float('inf') else -1

            
    