# O(c*a) time where c is no.of coins and a is amount
# O(a) space
#passed all the test cases
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        min_coins = [float("inf") for i in range(amount + 1)]
        min_coins[0] = 0
        for coin in coins:
            for denom in range(coin,len(min_coins)):
                min_coins[denom] = min(min_coins[denom],1 + min_coins[denom - coin])
        return min_coins[-1] if min_coins[-1] != float("inf") else -1
        

