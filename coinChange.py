"""
dp[i] in the dp array has the min coins needed to for amount i. Initialize it with a large value before, and keep dp[0] = 0
For each coin, go through the dp array from coin to amount, make dp[i] = min(dp[i], dp[i - coin] + 1)
Return dp[amount] if it's changed; else return -1 stating combination can't make that amount
"""
"""
Time Complexity: O(amount * len(coins)) - Each n coins for all amount
Space Complexity: O(amount) - dp array of size amount + 1
"""

class coinChange:
    def coinChanges(self, coins: list[int], amount: int) -> int:

        maximumm_val = amount + 1

        dp = [maximumm_val] * (amount + 1)

        dp[0] = 0

        for coin in coins:
            for i in range(coin, amount + 1):

                dp[i] = min(dp[i], dp[i-coin] + 1)

        return dp[amount] if dp[amount] != maximumm_val else -1 
    
if __name__=="__main__":
    coins = [1,2,5]
    amount = 11
    obj = coinChange()
    print(obj.coinChanges(coins,amount))
