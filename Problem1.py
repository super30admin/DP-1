#
# Time Complexity = O(nk) n = amount , k=types of coins
# Space Complexity = O(nk) n = amount , k=types of coins
# Works on leetcode
#
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = [float("inf")]*(amount+1)
        memo[0] = 0
        for i in range(amount+1):
            for j in coins:
                if i+j <= amount:
                    memo[i+j] = min(memo[i+j], memo[i]+1)
        if memo[amount] == float('inf'):
            return -1
        return memo[amount]
