# Time Complexity : O(N) N:length of array.
# Space complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took some time to reach pointer solution.

# Your code here along with comments explaining your approach
# Keep track of two values, option2(maximum loot from two houses ago) and option1(maximum loot from one house ago).
# For every house value n in the list, calculate a new maximum i.e either skip the current house or rob it.
# swap and return option1 at the end.

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        option1, option2 = 0, 0

        for num in nums:
            new_rob = max(option1, option2 + num)  
            option2 = option1  
            option1 = new_rob  

        return option1