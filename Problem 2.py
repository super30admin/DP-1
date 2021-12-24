# Time: O(n)
# Space: O(1)
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        rob = nums[0]
        not_rob = 0
        for i in range(1, len(nums)):
                temp = rob
                rob = nums[i]+not_rob
                not_rob = max(not_rob, temp)
        return max(rob, not_rob)                
        
