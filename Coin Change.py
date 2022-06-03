"""
TC: O(m * n) 
m - denominations  
n - amount
Sc: O(n)
"""
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0:
            return 0
        ways = [float("inf") for x in range(amount+1)]
        ways[0] = 0
        for i in coins:
            for idx in range(amount+1):
                if i <= idx:
                    ways[idx] = min(ways[idx],ways[idx - i] + 1)
        
        return ways[-1] if ways[-1] != float("inf") else -1
        
