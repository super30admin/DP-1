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
# Time             :  32 ms (59.57 %ile)
# Space            :  14.1 MB (76.14 %ile)
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        else:
            skip_reward = 0 # Reward for skip_rewardping first house
            rob_reward = nums[0] # Reward for Robbing first house

            for i in range(1, len(nums)):
                prev_skip_reward = skip_reward # store previous skip_reward
                # 0 case
                skip_reward = max(skip_reward, rob_reward) #skip_reward previous and rob_reward this

                # 1 case
                rob_reward = prev_skip_reward + nums[i] # previous skip_reward + current house

            return max(skip_reward, rob_reward)


obj = Solution()

print(obj.rob([2,7,9,1,1,8]))




