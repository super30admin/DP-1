# Time Complexity:
# O(n)

# Space Complexity:
# O(n)
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]

        dp=[[0] * 2 for _ in range(n)]
        # Base case
        dp[0][0]=0
        dp[0][1]=nums[0]
        
        for i in range(1,n): # Loop through nums
            dp[i][0]= max(dp[i-1][0],dp[i-1][1])
            dp[i][1]=dp[i-1][0]+nums[i]

        return max(dp[n-1][0], dp [n-1][1])