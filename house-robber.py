# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes


# Your code here along with comments explaining your approach

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return nums[0]

        skip = 0  # not choose case
        take = nums[0]  # choose case

        for i in range(len(nums) - 1):
            temp = skip  # store the not chose value in temp

            skip = max(skip, take)  # chosing the max value from skip and take
            # adding the previous skip and take elements
            take = temp + nums[i + 1]

        return max(skip, take)
