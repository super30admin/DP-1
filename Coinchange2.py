#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 27 09:45:54 2019

@author: tanvirkaur
"""

# Brute Force Solution:
# time complexity = O(2^n)
# space complexity = 
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins or not amount:
            return 0
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(1,len(coins)+1):
            dp[i][0] = 0
        for j in range(1,amount+1):
            dp[0][j] = float('inf')
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                # when we are at 3 index our coin in coins array is at coins[i-1]
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i][j-coins[i-1]]+1,dp[i-1][j])
        result = dp[-1][-1]
        if result == float('inf'):
            return -1
        else:
            return result
                