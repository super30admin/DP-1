#!/usr/bin/env python
# coding: utf-8

# In[1]:


# This is the Brute force approach to the problem.
# We have used a recursive approah to the problem. 
# This brute Force- recursive approach was taken upon after
# the Greedy approach failed.
# However, this approach will fail on Leetcode with Time limit exceeded and on PyCharm as well 
# Recursion Error: maximum recursion depth exceeded in comparison.ArithmeticError.
# The time complexity will be exponential.
# Input @ which the solutions fails
# [3,7,405,436]
# 8839
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins is None or len(coins) == 0:
            return -1
        return self.helper(coins, amount , idx=0, count=0)
    
    def helper(self, coins, amount, idx, count):
        # Base
        if amount == 0:
            return count
        if amount < 0 or idx == len(coins):
            return -1
        # Logic
        # We pick a coin
        case1 = self.helper(coins, amount- coins[idx], idx , count+1)
        # We don't pick a coin
        case2 = self.helper(coins, amount,idx + 1, count )
        if case1 == -1:
            return case2
        if case2 == -1:
            return case1
        return min(case1,case2)

