class Solution:
    #bruteforce
    def rob(self, nums: List[int]) -> int:

        if not nums:
            return
        return self.helper(nums, 0, 0)

    def helper(self, nums, index, maxnum):
        # base
        if index >= len(nums):
            return maxnum

        # logic
        case1 = self.helper(nums, index + 2, maxnum + nums[index])
        case2 = self.helper(nums, index + 1, maxnum)

        return max(case1, case2)


    #DP
    def rob(self, nums: List[int]) -> int:

        if not nums:
            return

        skip, take = 0, nums[0]

        for i in range(1, len(nums)):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]

        return max(skip, take)
