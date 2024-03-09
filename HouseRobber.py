# TC=  O(n) where n is length of nums array
# SC = O(n) where n is length of nums array


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if nums == None or len(nums) == 0:
            return 0
        if len(nums) < 2:
            return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[1], nums[0])
        print(dp)
        for i in range(2, len(nums)):  # O(n)
            print(i, dp[i - 1], dp[i - 2] + nums[i])
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        print(dp)
        return dp[n - 1]
