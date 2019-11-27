#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 27 08:44:57 2019

@author: tanvirkaur
"""

#BruteForce Solution : Timecomplexity = O(n^2)
class Solution(object):
    def rob1(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.helper(nums, 0,0)
    
    def helper(self, nums, amount, i):
        # base case
        if i >= len(nums):
            return -1
        
        #choose
        case1 = self.helper(nums, amount+nums[i], i+2)
        #not choose
        case2 = self.helper(nums, amount, i+1)