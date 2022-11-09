# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        tempArr = [0]*(len(nums)+2)
        for i in range(len(nums)-1, -1, -1):
            tempArr[i] = max(nums[i]+tempArr[i+2], tempArr[i+1])
        return tempArr[0]
            