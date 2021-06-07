
"""
This without memoization first. Try greedy, then brute force then DP. Notice the pattern and try to make a decision at
each step. Better to create the decision tree to showcase your thought process.

Approach 2:
Find the decision you make at each node.
0) start traversal from the beginning of the coins array and make decisions
1) either choose the coin at index i, or dont
2) keep track of your decision via recursion.
3) pick the optimized solution

Approach 1:
create a memoization matrix and keep track of all combinations
0) initialize the matrix based on the pattern found
1) move to each cell and store results
2) the cell cell would give you the optimized solution

"""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Approach 1 : Top Down + memoization
        """
        if not coins:
            return 0

        dp = [[amount+1]*(amount+1) for _ in range(len(coins)+1)]

        for i in range(len(dp)):
            dp[i][0] = 0

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])

        #print(dp)
        return dp[-1][-1] if dp[-1][-1] < amount +1 else -1
        """
        # Approach 2: Top Down only
        if amount == 0:
            return 0

        return self.helper(coins, amount, 0, 0)

    def helper(self, coins, amount, index, min_coins):
        # base
        if amount == 0:
            return min_coins
        if amount < 0 or index >= len(coins):
            return -1

        # choose coin at index
        case0 = self.helper(coins, amount - coins[index], index, min_coins + 1)

        # do not choose coin at index
        case1 = self.helper(coins, amount, index + 1, min_coins)

        if case0 == -1: return case1
        if case1 == -1: return case0

        return min(case0, case1)

"""
Approach 1:
TC: O(m*n) m -> max denomination, n-> len(coins) 
SC: O(m*n)
Approach 2:
TC: O(2^n)
SC: O(m)
"""