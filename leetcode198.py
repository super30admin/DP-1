#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Feb 12 15:33:04 2026

@author: rishigoswamy

    Problem: House Robber
    Link: https://leetcode.com/problems/house-robber/

    Description:
    You are given an integer array nums representing the amount of money
    at each house. Adjacent houses cannot be robbed.
    Return the maximum amount of money you can rob.

    Approach:
    Optimized Dynamic Programming (Space Optimized).

    Let:
    r1 = max money till house i-2
    r2 = max money till house i-1

    For each house:
        current = max(r1 + num, r2)

    Shift:
        r1 = r2
        r2 = current

    Time Complexity: O(n)
    Space Complexity: O(1)

"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        r1, r2 = 0, 0 
        for num in nums:
            temp = max(r1 + num, r2)
            r1 = r2
            r2 = temp
        return r2
        

