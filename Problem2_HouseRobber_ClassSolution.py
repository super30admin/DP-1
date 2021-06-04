'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 198. House Robber
# You are a professional robber planning to rob houses along a street. 
# Each house has a certain amount of money stashed, the only constraint 
# stopping you from robbing each of them is that adjacent houses have security 
# systems connected and it will automatically contact the police if two adjacent
# houses were broken into on the same night.

# Given an integer array nums representing the amount of money of each house, 
# return the maximum amount of money you can rob tonight without alerting the 
# police.


# Example 1:

# Input: nums = [1,2,3,1]
# Output: 4
# Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
# Total amount you can rob = 1 + 3 = 4.
# Example 2:

# Input: nums = [2,7,9,3,1]
# Output: 12
# Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and 
# rob house 5 (money = 1).
# Total amount you can rob = 2 + 9 + 1 = 12.

#-----------------
# Time Complexity: 
#-----------------
# O(N): Need to iterate over input array once
#------------------
# Space Complexity: 
#------------------
# O(1) - Need only reward variables for current house, next, and after next

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  32 ms (59.16 %ile)
# Space            :  14.1 MB (92.00 %ile)
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        else:
            skip = 0 # Skip first house
            take = nums[0] #  Take first house

            for i in range(len(nums)):
                temp = skip # store previous skip
                # 0 case
                skip = max(skip, take) #Skip previous and take this

                # 1 case
                take = temp + nums[i] # previous skip + current house

            return max(skip, take)


obj = Solution()

print(obj.rob([2,7,9,1,1,8]))




