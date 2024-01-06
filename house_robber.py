""" Explanation: I am essentially storeing the max sum we can get for each house, and then using it to calculate the following houses until
    we get the final result.
    In the path that the robber chose to rob with max money, it is guaranteed that either the last house (num[-1]) or the 
    2nd last house (num[-2]) will be robbed. 
    So we can compare the max sum path that includes num[-1] with the max sum path that includes num[-2] and return the larger one.
    Time Complexcity: O(n)
    Space Complexcity: O(1)
"""

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_three, max_two, adjacent = 0,0,0

        for i in nums:
             max_three, max_two, adjacent = \
                max_two, adjacent, max(max_three + i, max_two + i)

        return max(max_two, adjacent)