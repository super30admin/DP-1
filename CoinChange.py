# Time Complexity : O(mn) where m is the amount and n is the coins
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        count = [0] * amount

        if amount < 1:
            return 0
        # This should run O(m) times where m is the amount
        def change(coins, remainder, count):
            if remainder < 0:
                return -1
            if remainder == 0:
                return 0
            if count[remainder - 1] != 0:
                return count[remainder - 1]

            min_val = math.inf
            # Runs in O(n)
            for coin in coins:
                res = change(coins, remainder - coin,  count)
                if res >= 0 and res < min_val:
                    min_val = 1 + res
            if min_val == math.inf:
                count[remainder - 1] = -1
            else:
                count[remainder - 1] = min_val
            return count[remainder - 1]

        return change(coins, amount, count)
