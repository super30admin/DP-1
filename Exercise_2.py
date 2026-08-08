# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The main decision was keeping only the previous two states instead of a full DP array.
# Approach: At each house, I choose between robbing it with the best value from two houses back or skipping it.
# Two variables are enough because the current answer only depends on the previous two answers.
# After processing all houses, the latest value is the maximum money that can be robbed.


class Solution:

    def rob(self, nums):
        two_back = 0
        one_back = 0

        for money in nums:
            current = max(one_back, two_back + money)
            two_back = one_back
            one_back = current

        return one_back
