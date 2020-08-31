class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        c = dc = tmp = 0
        for n in nums:
            tmp = dc
            dc = max(c,dc)
            c = tmp+n
        return max(c,dc)

#Time Complexity = O(n)
#Space Complexity = O(1)