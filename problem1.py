# Time Complexity: O(n)
# Space Complexity:O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Maintain to variables one to calculate the current step and next steo 
        dp1 = 0
        dp2 = 0
        # literate through each number 
        # and decide which next to go dynamically by calculating the current step and next step
        for num in nums:
            temp = dp2
            dp2 = max(dp1 + num, dp2)
            dp1 = temp
        return dp2 
        