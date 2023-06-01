# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        pre1 = 0
        pre2 = 0
        for num in nums:
            dp = max(pre1, (pre2 + num))
            pre2 = pre1
            pre1 = dp
        return pre1