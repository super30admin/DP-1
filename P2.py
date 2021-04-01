# -*- coding: utf-8 -*-
"""
Created on Wed Mar 31 19:32:25 2021

@author: jgdch
"""

class Solution(object):
    def rob(self, nums):
       
        dp=[0]*(len(nums))
        if(len(dp)==1):
            return nums[0]
        if(len(dp)==0):
           return 0
       
    
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
    
        for i in range(2,len(nums)):
            dp[i] = max(dp[i-2] + nums[i], dp[i-1])        
    
        return dp[len(dp) - 1]; 