"""
Time Complexity: O(n * m) where n is the length of coins and m is the amount
Space Complexity: O(m)
"""


def change(coins, amount):
    if not coins or len(coins) == 0:
        return 0

    if len(coins) == 1:
        return coins[0]

    n, m = len(coins), amount
    dp = [m+1] * (m + 1)
    dp[0] = 0

    for j in range(1, m + 1):
        for i in range(n):
            if j - coins[i] >= 0:
                dp[j] = min(dp[j], dp[j - coins[i]] + 1)

    print(dp)
    return -1 if dp[-1] > m else dp[-1]


coins = [1, 2, 5]
amount = 11
print(change(coins, amount))
