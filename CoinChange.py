class Solution:
    # Time Complexity : O(M*N) where is the N is th length of the coins and M is the amount after using memo. Without memoization it is O(2^M+N)
    # Space Complexity : O(m*n) recursion stack and memo hashmap
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    # Using a 01 DFS approach we choose a coin or we don't choose. And when we chose we increase the count by 1 and in the end we return min(x,y) where x is left and y is right side
    # Finally, we also use memo to optimize on the repeated subproblems. This is also code top down approach
    def coinChangeDFS(self, coins: List[int], amount: int) -> int:
        memo = {}

        def helper(amount: int, idx: int) -> int:
            # Base
            if amount == 0: return 0
            if idx == len(coins) or amount < 0:
                return float("inf")
            # Logic
            if (amount, idx) in memo:
                return memo[(amount, idx)]
            # 0
            v1 = helper(amount, idx + 1)

            # 1
            v2 = 1 + helper(amount - coins[idx], idx)

            memo[(amount, idx)] = min(v1, v2)

            return memo[(amount, idx)]

        val = helper(amount, 0)
        if val == float("inf"): return -1
        return val

    # Time Complexity : O(M*N) where is the N is th lenght of the coins and M is the amount
    # Space Complexity : O(M*N) matrix size
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    # This is an iterative approach also called true DP. Using the bottom up approach

        def coinChange(self, coins: List[int], amount: int) -> int:
            n = amount
            m = len(coins)
            dp = [[0 if j == 0 else float("inf") for j in range(n + 1)] for _ in range(m + 1)]

            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    if j >= coins[i - 1]:
                        dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
                    else:
                        dp[i][j] = dp[i - 1][j]

            result = dp[m][n]
            if result == float("inf"):
                return -1
            return result








