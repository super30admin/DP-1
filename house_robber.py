#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Sep  3 20:04:05 2021

@author: ameeshas11
"""


#Time Complexity : O(n)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        skip = 0
        take = nums[0]
        
        for i in range (len(nums)-1):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i+1]
            
        return max(skip, take)