#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Feb 12 15:30:44 2026

@author: rishigoswamy

    Problem: Coin Change
    Link: https://leetcode.com/problems/coin-change/

    Description:
    Given an integer array coins representing coin denominations
    and an integer amount representing a total amount of money,
    return the fewest number of coins needed to make up that amount.
    If that amount cannot be made up, return -1.

    Approach:
    Bottom-Up Dynamic Programming.

    - dp[i] represents the minimum coins needed to make amount i.
    - Initialize dp with a large value (amount + 1).
    - Base case: dp[0] = 0.
    - For each amount, try every coin and update dp.

    Time Complexity: O(amount * number_of_coins)
    Space Complexity: O(amount)

"""

class Solution:
    def coinChange(self, coins, amounts: int) -> int:
        dp = [amounts + 1] * (amounts + 1)
        dp[0] = 0
        for amount in range(1, amounts + 1):
            for coin in coins:
                if amount - coin >= 0:
                    dp[amount] = min(dp[amount], 1 + dp[amount - coin])
        return dp[-1] if dp[-1] != amounts+1 else -1
        