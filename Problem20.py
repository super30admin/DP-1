'''
Time complexity: O(m x n) where m is number of coins and n is amount.
Space complexity: O(m x n)
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp_arr = [0] + ([float('inf')] * amount)

        for i in range(1, amount+1):
            for coin in coins:
                if coin <= i:
                    dp_arr[i] = min(dp_arr[i], dp_arr[i-coin]+1)

        if dp_arr[-1] == float('inf'):
            return -1

        return dp_arr[-1]