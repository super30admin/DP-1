# Time Complexity : O(n * amount)
# Space Complexity : O(n * amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use recursion + memoization (top-down DP).
# At each index, we have two choices:
# 1. Pick the current coin and stay at the same index because coins can be reused.
# 2. Do not pick the current coin and move to the next index.
# Store results in a 2D memo table memo[i][amt] to avoid recomputing
# Final answer is the minimum of pick and not_pick. If result stays infinity, return -1.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        def helper(i,amt,memo):
            if i >= len(coins) or amt < 0:
                return float('inf')
            if memo[i][amt] != -1:
                return memo[i][amt]
            if amt == 0:
                return 0
            pick = float('inf')
            if amt >= coins[i]:
                pick = 1 + helper(i,amt - coins[i],memo)
            not_pick = helper(i + 1,amt,memo)
            memo[i][amt] = min(pick, not_pick)
            return memo[i][amt]
        memo = [[-1 for i in range(amount + 1)]for j in range(len(coins) + 1)]
        res = helper(0,amount,memo)
        return -1 if res == float('inf') else res