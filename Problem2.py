# Problem 2 : House Robber
# Time Complexity :
'''
Memoziation ie Top-Down approach - O(n) where n is the number of house in nums array
Bottom-up approach 2-d matrix - O(n) where n is the number of house in nums array
Bottom-up approach three variable - O(n) where n is the number of house in nums array
'''
# Space Complexity :
'''
Memoziation ie Top-Down approach - O(n) where n is the number of house in nums array
Bottom-up approach 2-d matrix - O(n) where n is the number of house in nums array
Bottom-up approach three variable - O(1)
'''
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# Memoziation ie Top-Down approach
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        # define memo array to store the value of calculated repeated sub-problem
        memo = [-1] * (len(nums)+1)

        # helper recursive function to calculate the maximum amount of money that can be steal from the house with index idx
        def helper(nums: List[int], idx: int) -> int:
            # memo is global variable
            nonlocal memo
            # if the house is a last house in the array or the index is greater than or equal to length of array then return 0
            if idx >= len(nums): return 0
            # check the memo array for the idx position and if the array has the value then return that value
            if memo[idx] != -1: return memo[idx]
            # case 1 - to choose the house at idx location 
            # calculate the value as amount at house at idx position and amount from the idx+2 house
            case1 = nums[idx] + helper(nums, idx + 2)
            # case 2 - not to choose the house at idx location 
            # calculate the value as amount at house from idx+1 position
            case2 = helper(nums, idx + 1)
            # result will be maximum between two value 
            result = max(case1, case2)
            # store the result at idx position in memo array 
            memo[idx] = result
            # return result
            return result
        
        # call helper function at 0th position
        return helper(nums, 0)
    

# Bottom-up approach 2-d matrix
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        # get the length of the nums array
        length = len(nums)
        # define dp array with lenght of nums array and fill with 0
        dp = [0] * len(nums)
        # set the value of 0th position as nums[0]
        dp[0] = nums[0]
        # if the length of nums array is equal to 1 then return value at 0th position of dp
        if length == 1: return dp[0]
        # calculate the dp[1] values as maximum of dp[0] and value of nums[1]
        dp[1] = max(dp[0], nums[1] + 0)
        # loop from 2 to the length of nums array
        for i in range(2, length):
            # calculate the value of ith position as maximum between the value at (i-1)th positionof dp and sum of value at ith position of nums and value at (i-2)th position of dp
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        # return the value of dp at (length-1)th position
        return dp[length - 1]
    

# Bottom-up approach three variable
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        # get the length of the nums array
        length = len(nums)
        # set previous variable to nums[0]
        prev = nums[0]
        # if the length of nums array is equal to 1 then return prev
        if length == 1: return prev
        # calculate the curr as as maximum of prev and value of nums[1]
        curr = max(prev, nums[1] + 0)
        # loop from 2 to the length of nums array
        for i in range(2, length):
            # store the value of curr in temp since the curr will be overwritten
            temp = curr
            # calculate the curr as maximum between the current value and sum of prev and value at ith position of nums
            curr = max(curr, nums[i] + prev)
            # store the value of temp in prev
            prev = temp
        # return the value at curr
        return curr

