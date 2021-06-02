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

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        elif len(nums) == 1:
            return nums[0]

        else:
            num_houses = len(nums)
            # Start with simplest possible case here, when we have 
            # num_houses = 2 and we have finished the base cases =1 and 0
         
            # Total reward for choosing to rob current house
            # This will be dictated by what houses can be robbed without
            # triggerring the alarm
            # This needs to be calculated so lets set it to negative number
            # to help with max() calculation
            reward_current = -1 

            # total reward for choosing to rob next house 
            # Simplest case len(nums) == 2: 
            # The reward will be the value of robbing the last house (nums[1])
            reward_rob_next = nums[num_houses - 1]

            # total reward for choosing to rob the house after the next house
            # Simplest case len(nums) == 2: 
            # reward for robbing the house after the next house is 0 
            # because there is no house since len(nums) == 2
            reward_rob_after_next = 0

            # With reward current, rob_next, and rob_after_next, we can
            # implement the general case. 


            # Starting at nums[num_houses - 2], we have 1 house left to rob.
            # i.e., in example : [1,2,(3),1] - we are at index 2

            # We can either rob nums[num_houses-2] or rob nums[num_houses-1]
            #                   reward = 3                reward = 1
            # We could consider robbing nums[nums_houses] but there are no
            # houses there...

            # We choose to start from the end because the subproblem of 
            # choosing which house to rob, depends on the proceeding elements.
            # If we start at the end and know the max reward possible for
            # the rest of the problem and don't need to recompute
            for i in range(2, num_houses+1):
                # At every location starting from nums[num_houses-2]
                # We have to choose between (robbing current house as well as 
                # current house + 2) OR (robbing next house)
                reward_current = max(reward_rob_next, \
                    nums[num_houses-i] + reward_rob_after_next)

                # NOTE: Range function will return 2, ..., num_houses
                # in the terminating case, nums[num_houses-i] = nums[0]
                
                # We have to update the reward for robbing 
                # current house + 2 with reward from robbing next
                # because we are moving one element to the left of the array
                # So what is next house now will be the house after next house
                # in the proceeding iteration
                reward_rob_after_next = reward_rob_next

                # Similarly, reward for stategy of robbing next house 
                # will be the reward for choosing to rob the current house
                reward_rob_next = reward_current

            return reward_current




