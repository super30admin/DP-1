# Time complexity: o(n)  n is the number of elements in nums
# space complexity: o(n) n is the number of elements in nums
class Solution:
    def rob(self, nums: list[int]) -> int:
        # return self.helper(nums,0,0)
        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return max(nums)
        dp = []
        dp.append(0)
        dp.append(nums[0])
        dp.append(nums[1])

        for i in range(2, len(nums)):
            dp.append(max(dp[i-1]+nums[i], dp[i-2]+nums[i]))

        return max(dp[-1], dp[-2])

    # def helper(self, nums, index, total):
    #     # base case
    #     if index >= len(nums):
    #         return total

    #     # logic
    #     case1 = self.helper(nums, index + 2, total + nums[index])

    #     case2 = self.helper(nums, index + 1, total)

    #     return max(case1, case2)
