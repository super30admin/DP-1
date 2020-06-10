#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : coming up with brute force can be tricky
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0

        # following the table approach from class
        dp = []
        for i in range(len(nums)):
            dp.append([0, 0])

        dp[0][1] = nums[0]

        for i in range(1, len(nums)):
            # when we don't take the current value, it'll be the max of the above rows
            dp[i][0] = max(dp[i - 1][1], dp[i - 1][0])

            # otherwise we take the nums[i] and add it to the value of NOT taking the previous number
            dp[i][1] = dp[i - 1][0] + nums[i]

        return max(dp[len(nums) - 1][0], dp[len(nums) - 1][1])