'''
TC: O(m*n) where m is no. of coins and n is the amount
SC: O(n) 1d array for amount
'''
from math import inf
from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> inf:
        res = [float('inf')]*(amount+1)
        res[0] = 0
        for i, v in enumerate(res):
            for coin in coins:
                if i>=coin:
                    res[i] = min(res[i], res[i-coin]+1)
        return res[-1] if res[-1]!=float('inf') else -1
s = Solution()
print(s.coinChange([1,2,5], 11))
print(s.coinChange([2], 3))
print(s.coinChange([1], 0))
print(s.coinChange([3,7,405,436], 8839)) #No timeout error