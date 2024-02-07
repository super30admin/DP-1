'''
TC: O(2^(m+n)) where (m+n) is the height of the tree
    m: successful cases and n: non successfull cases
SC: O(m+n) since the recursive calls occupy stack space internally
'''
from math import inf
from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> inf:
        
        def dfs(amount, idx, minCoins):
            #base
            if amount < 0 or idx == len(coins):
                return float("inf")
            if amount == 0:
                return minCoins

            #logic
            notChosen = dfs(amount, idx+1, minCoins)
            chosen = dfs(amount-coins[idx], idx, minCoins+1)
            return min(notChosen, chosen)
            
        res = dfs(amount, 0, 0)
        return res if res != float("inf") else -1
    
s = Solution()
print(s.coinChange([1,2,5], 11))
print(s.coinChange([2], 3))
print(s.coinChange([1], 0))
print(s.coinChange([3,7,405,436], 8839)) # Gives time limit exceeded as expected