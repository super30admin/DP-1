#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 27 09:18:14 2019

@author: tanvirkaur
"""

#time complexity = O(n)
#Space complexity = O(1)
#LeetCode acceptance = Yes

class Solution:
    def rob(self, nums: List[int]) -> int:
        # base case
        if not nums:
            return 0
        Notchosen = 0
        chosen = nums[0]
        for i in range(1,len(nums)):
            chosen, Notchosen = nums[i] + Notchosen, max(Notchosen, chosen)
        return max(chosen, Notchosen)