# Time complexity: O(2^N) Exponential
# Space complexity: O(1)

# THe decision making varibale is the index of the house. We design the base case to return value if pointer reaches the end


class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.helper(nums, 0, 0)

    def helper(self, nums: List[int], index: int, robbedAmount: int) -> int:
        #         Base Case
        if index >= len(nums):
            return robbedAmount
        #         Choose or Not Choose
        #       Not Choose
        case1 = self.helper(nums, index + 1, robbedAmount)
        case2 = self.helper(nums, index + 2, robbedAmount + nums[index])
        return max(case1, case2)


# Time Complexity: O(n)
# Space Complexity: O(n)

# In the DP again, we just handle the repeated subproblems of the recursion.

# Here, to build the table, the current house robbed value will the max of house i - 2 and adding the amount of the current house.

# This is due to that we can't rob adjacent houses.


class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        n = len(nums)
        if n < 2:
            return nums[0]
        dp = [[0] for i in range(n)]
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        return dp[n - 1]
