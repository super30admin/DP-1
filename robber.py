#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 30 12:19:24 2020

@author: gerrard
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        length = len(nums)
        if length == 0:
            return 0
        
        if length == 1:
            return nums[0]
        
        
        # Bottom Up approach - Dynamic Programming
        dp_array = [-1]*(length)
            
        #dp_array[0] = 0
        dp_array[0] = nums[0]
        dp_array[1] = max(nums[0],nums[1])
            
        for i in range(2,length):  #1 2 
            dp_array[i] = max(dp_array[i-2] +nums[i], dp_array[i-1])
            
        return dp_array[length-1]