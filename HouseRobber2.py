#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov 27 08:45:29 2019

@author: tanvirkaur
"""

#time complexity = O(n)
#Space complexity = O(n*2)
#LeetCode acceptance = Yes
# using 2D matrix

class Solution:
    def rob(self, nums: List[int]) -> int:
        # base case
        if not nums:
            return 0
        dp = [[0 for _ in range(2)] for _ in range(len(nums))]
        dp[0][1] = nums[0]
        for i in range(1,len(nums)):
            # if we not choose
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            # if we choose we have to take the amount of the previous not choosen
            dp[i][1] = nums[i] + dp[i-1][0]
            # in the end we return the maximum of the last row
        return max(dp[len(nums)-1][0],dp[len(nums)-1][1])