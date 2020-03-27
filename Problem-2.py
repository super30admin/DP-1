## Problem2 (https://leetcode.com/problems/house-robber/)
"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]

Output: 4

Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).


             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]

Output: 12

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : To deduce the recursive equation

"""

def robber(nums):
    if len(nums)==0:   # check if we have zero houses to rob return 0
        return 0

    if len(nums)==1:   # check if we have 1 house to rob return that house
        return nums[0]

    if len(nums) == 2:  # check if we have 2 houses to rob return max of 2 houses
        return max(nums[0],nums[1])

    dp=[0]*len(nums)   # create dp 1-D array
    dp[0]= nums[0]     # first element will be dp[0]
    dp[1] = max(nums[0],nums[1])    # max of 1st or 2nd element will be dp[1]
    for i in range(2,len(nums)):    # loop from 2 as we already have dp[1] and dp[2]
        dp[i]=max(nums[i]+dp[i-2],dp[i-1]) # dp[i] will be max of current amount + amount robbed till 2 houses before or robbed till 1 house before
    return dp[-1]    # return last element of dp array


print(robber([2,7,9,3,1]))