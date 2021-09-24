# Time complexity: O(n) where n is the number of houses
# Space complexity: O(n) where n is the number of houses
# Did this run successfully on Leetcode: Yes
# Did you face any problem in solving this: Although I had solved this problem earlier, I still have some gap in understanding the main logic


from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)
        memo = [float('-inf')]*len(nums)
        memo[0] = nums[0]
        memo[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            memo[i] = max(memo[i-1], nums[i]+memo[i-2])
        return memo[-1]


solution = Solution()
print(solution.rob([5, 3, 2, 4, 6]))
