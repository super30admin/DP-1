# TC : O(len(nums))
# SC : O(len(nums))
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length==1:
            return nums[0]
        
        dp = [0]*length
        
        dp[0], dp[1] = nums[0], max(nums[0], nums[1])
        for i in range(2, length):
            dp[i] = max(dp[i-2]+nums[i], dp[i-1])

        
        return max(dp)