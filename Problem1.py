'''
The problem can be solved using brute force of creating every possible
choice of choosing a coin or not. This can be a recursive call to the function itself
and hence creating a tree of choices with depth = amount/min(coins) which is O(2^(depth))

Since there are repeated subproblems we can use dp by storing the answer of each
amount leading to "amount" using the coins till now.
Hence we start with first coin and try to reach a total of 1, 2, 3 ... amount, and
store the minimum coins required to reach the total.
Then we take the previous coins and the next coin combined and try to find the
miminum coins required for each total.

This will take space of O(amount) and time of O(amount*len(coins))
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0

        dp = []
        for _ in range(amount+1):
            dp.append(99999)
        dp[0] = 0

        for coin in coins:
            for i in range(amount+1):
                if coin <= i:
                    dp[i] = min(dp[i], dp[i-coin]+1)

        result = dp[-1]
        if result == 99999:
            return -1
        else:
            return result