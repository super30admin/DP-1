'''
    Time Complexity:
        O(S*n) (where S is the amount and n is the length of the coins array)

    Space Complexity:
        O(S) (where S is the amount)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Top Down Memoized DP approach.
        For all the given coins, if the current coin <= amount, check for
        amount = amount - coin
        Keep doing it until amount == 0.
        Memoize the answers to reduce TC.
'''
MAX_INT = sys.maxsize

class Solution:
    def __init__(self):
        self.coins = []
        self.dp = {}

    def coinChange(self, coins: List[int], amount: int) -> int:
        self.coins = coins
        min_coins = self.find_min_coins(amount)
        return min_coins if min_coins < MAX_INT else -1

    def find_min_coins(self, amount_left):
        if amount_left in self.dp:
            return self.dp[amount_left]

        if amount_left == 0:
            return 0

        min_coins = MAX_INT
        for coin in self.coins:
            if coin <= amount_left:
                min_coins_with_coin = self.find_min_coins(amount_left - coin)
                min_coins = min(min_coins, min_coins_with_coin)

        self.dp[amount_left] = min_coins + 1
        return self.dp[amount_left]
