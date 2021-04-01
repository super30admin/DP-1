# -*- coding: utf-8 -*-
"""
Created on Wed Mar 31 18:50:02 2021

@author: jgdch
"""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[float("inf")]*(amount+1)
        dp[0]=0
        for c in coins:
            for a in (c,amount+1):
                dp[a]=min(dp[a],dp[a-c])
        if dp[amount]!=float('inf'):
           return dp[amount]
        else:
            return -1