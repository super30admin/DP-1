#
# Time Complexity = O(m* 2^n) m=amount, n=number of coins
# Space Complexity = O(m+n) m=amount, n=number of coins
# Works on leetcode
#

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def helper(index, am, count):
            if index >= len(coins) or am < 0:
                return float('inf')
            if am == 0:
                return count
            return min(helper(index+1, am, count), helper(index, am-coins[index], count+1))
        res = helper(0, amount, 0)
        if res == float("inf"):
            return -1
        else:
            return res
