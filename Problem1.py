# Time Complexity: O(nk) where k is the amount and n is the coin counts 
# Space Complexity: O(k)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp = [[float('inf') for _ in range(amount+1)] for _ in range(len(coins)+1)]

        # for i in range(len(coins)+1):
        #     for amt in range(amount+1):
        #         if i == 0:
        #             dp[i][amt] = 0
                    
        #         if amt == 0:
        #             dp[i][0] = 0
        #         elif amt < coins[i-1]:
        #             # IF the amount is less the coin you are trying to add,
        #             #  then best we can do is the result from the previous coin
        #             dp[i][amt] = dp[i - 1][amt]
        #         elif amt == coins[i-1]:
        #             dp[i][amt] = 1
        #         else:
        #             # Else, the result is the min between 2 options:
        #             # choose the current coin, and not choose
        #             dp[i][amt] = min(
        #                 1 + dp[i][amt - coins[i-1]], # Choose the current coin
        #                 dp[i - 1][amt] # Not choosing the coin
        #             )
        # res = dp[-1][-1]
        # if res == float('inf'):
        #     return -1
        # return res

        dp = [float('inf') for _ in range(amount+1)]
        dp[0] = 0

        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)
                
        return dp[amount] if dp[amount] != float('inf') else -1 
