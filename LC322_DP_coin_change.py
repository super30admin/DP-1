#  Time Complexity : O(n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : No

# Approach: at each house, choosing max(skip current, rob current + money from i-2) while keeping only the previous two DP values


def coinChange(coins: list[int], amount: int) -> int:
    m = len(coins)
    n = amount
    # m rows and n cols
    dp = [0] * (n + 1)

    for j in range(1, n + 1):
        dp[j] = 99999

    for i in range(1, m + 1):
        for j in range(n + 1):
            # choose case
            if j >= coins[i - 1]:
                dp[j] = min(dp[j], dp[j - coins[i - 1]] + 1)

    if dp[n] == 99999:
        return -1
    return dp[n]
