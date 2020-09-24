# Time Complexity: O(N)
# Space Complexity: O(N)
# Leetcode all test cases passed: Yes
# Any difficulties: No


class Solution:
    def rob(self, nums: List[int]) -> int:
        length = len(nums)
        dp = [0]*length
        if length==0:
            return 0
        if length==1:
            return nums[0]
        if length==2:
            return max(nums)
        dp[0], dp[1] = nums[0], max(nums[0], nums[1])
        for i in range(2,length):
            dp[i] = max(dp[i-2]+nums[i],dp[i-1])        # Comparing with the prev and prev to prev element, max value to be stored in the array
        return max(dp)
