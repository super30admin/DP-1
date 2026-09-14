'''
322 Coin Change
https://leetcode.com/problems/coin-change/description/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Assume N denominations of coins and target sum is K.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Solution:
1. Brute Force (Recursion): Starting from the target sum, for each coin coins[i], we can either include it or exclude it. If we include it, we subtract its value from sum and recursively try to make the remaining amount with the same coin denominations. If we exclude it, we move to the next coin in the list.
Thus, at each step, we have N choices of coin denominations. At the max, we take K such steps (since least denomination is 1).
Time: O(2^(N+K)), Space: O(N+K)
https://youtu.be/J-jY2VQPt3s?t=2858 (Time complexity discussed till 54:14)


2. Recursion with memoization (top-down approach): Keep track of overlapping sub-problem using a hash map. The key of the hash map is the remaining sum to be computed and the value is the minimum no. of coins to reach the remaining sum. If we encounter it again, we just use the hash map instead of repeating the computation.
Time: O(N*K), Space: O(N*K)

3. Tabulation (bottom-up approach): Construct a 2-D DP array of size
(N+1) x (K+1).

dp[i][j] = min number of coins required to reach the target amount j using denominations coins[0],...,coins[i-1]
Note: In the dp matrix, row i=0 correspond to a dummy coin of denomination 0. Hence, row i=1, correspond to coins[0]. Thus dp[1][4] correspond to the min no. of coins to reach target amount 4 using only coins[0]
Next, row i=2 correspond to coins[1]. dp[2][4] correspond to the min no. of coins to reach target amount 4 using only coins[0] and coins[1].
In general, row i corresponds to coins[0],...,coins[i-1]

Initialize dp and fill the array using:
    case_0 = dp[i-1][j]
    case_1 = 1 + dp[i][j - coins[i-1]]
    dp[i][j] = min(case_0, case_1)
Time: O(N*K), Space: O(N*K)
https://www.youtube.com/watch?v=1p5hI8epOUU
'''
import time
import numpy as np

def coin_change(coins, amount):
    '''
    recursion
    '''
    def recurse(coins, amount, index):
        # base
        if index >= N or amount < 0:
            return float('inf')

        if amount == 0:
            return 0

        # logic
        # don't pick
        case_0 = recurse(coins, amount, index+1)

        # pick
        case_1 = 1 + recurse(coins, amount - coins[index], index)

        return min(case_0, case_1)

    N = len(coins)
    if N == 0:
        return 0

    result = recurse(coins, amount, 0)
    if result == float('inf'):
        result = -1
    return result

def coin_change_DP(coins, amount):
    '''
    dynamic programming
    '''
    N = len(coins)
    if N == 0 or amount <= 0:
        return 0

    dp = [[0]*(amount+1) for _ in range(N+1)]
    for j in range(1, amount+1):
        dp[0][j] = amount + 1

    for i in range(1, N+1):
        for j in range(1, amount + 1):
            if coins[i-1] > j:
                dp[i][j] = dp[i-1][j]
            else:
                case_0 = dp[i-1][j]
                case_1 = 1 + dp[i][j - coins[i-1]]
                dp[i][j] = min(case_0, case_1)

    if dp[N][amount] == amount + 1:
        return -1

    return dp[N][amount]


def run_coin_change():
    tests = [([1,2,5], 11, 3),
             ([2], 3, -1),
             ([9, 6, 5, 1], 19, 3),
             ([9, 6, 5, 1], 30, 4)
    ]
    for test in tests:
        coins, amount, ans = test[0], test[1], test[2]
        start = time.time()*1000
        num_coins = coin_change(coins, amount)
        elapsed =  time.time()*1000 - start
        # if num_coins == float('inf'):
        #     num_coins = -1
        print(f"\ncoins = {coins}")
        print(f"Min number of coins to reach target {amount} = {num_coins}, time = {elapsed:.2f} ms (recursion)")
        print(f"Pass: {ans == num_coins}")

    for test in tests:
        coins, amount, ans = test[0], test[1], test[2]
        start = time.time()*1000
        num_coins = coin_change_DP(coins, amount)
        elapsed =  time.time()*1000 - start
        # if num_coins == float('inf'):
        #     num_coins = -1
        print(f"\ncoins = {coins}")
        print(f"Min number of coins to reach target {amount} = {num_coins}, time = {elapsed:.2f} ms (DP)")
        print(f"Pass: {ans == num_coins}")


run_coin_change()
