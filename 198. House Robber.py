#Time Complexity:O(n)
#Space Complexity:O(1)
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        rob1,rob2=0,0
        for n in nums:
            maxi=max(rob1+n,rob2)
            rob1=rob2
            rob2=maxi
        return maxi