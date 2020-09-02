class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return 0
        if length ==1:
            return nums[0]
        dp =[]
        dp.append(nums[0])
        dp.append(max(nums[0],nums[1]))
        for x in range(2,length):
            dp.append(max(nums[x]+dp[x-2],dp[x-1]))
        print(dp)
        return dp[length-1]
        
    """
    TC- O(n)
    SC- O(n)
    Did this code successfully run on Leetcode- Yes :
    Any problem you faced while coding this- No :
    """
        