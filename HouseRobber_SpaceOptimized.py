# TC = O(n) where n is length of nums array
# SC = O(1) as we are using just 2 variables instead of dp array


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if nums == None or len(nums) == 0:
            return 0
        if len(nums) < 2:
            return nums[0]

        prev = nums[0]
        curr = max(nums[1], nums[0])

        for i in range(2, len(nums)):  # TC =O(n)
            temp = curr
            # dp[i]= max(dp[i-1],dp[i-2]+nums[i])
            curr = max(curr, prev + nums[i])
            prev = temp

        return curr
