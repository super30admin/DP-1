#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 27 09:31:09 2019

@author: tanvirkaur
"""
# Brute Force Solution:
# time complexity = O(2^n)
# space complexity = 
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.helper(coins, amount,0,0)
    
    def helper(self,coins, amount,i,minn):
        #base case
        if i >= len(coins) or amount < 0:
            return -1
        if amount == 0:
            return minn
        
        # chosen
        case1 = self.helper(coins, amount-coins[i], i, minn+1)
        # not chosen
        case2 = self.helper(coins, amount, i+1, minn)
        if case1 == -1:
            return case2
        elif case2 == -1:
            return case1
        else:
            return min(case1,case2)
        
