# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n= len(nums)
        dp = [[0 for x in range (2)] for x in range (n)]
        skip = 0 
        take = nums[0] 

        for i in range (1, n):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]

        return max(skip, take)