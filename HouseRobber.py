# Recursive
# Time Complexity :O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

# Iterative with constant space
# Time Complexity :O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums) - 1
        money = [float('-inf')] * (len(nums) + 2)

        def recursive(i):
            if i > size:
                return 0
            if money[i] != float('-inf'):
                return money[i]
            money[i+1] = recursive(i+1)
            money[i+2] = recursive(i+2)

            return max(money[i+1], money[i+2] + nums[i])

        def dp():
            skip = 0
            take = nums[0]

            for index in range(1, len(nums)):
                num = nums[index]
                temp_skip = skip
                skip = max(temp_skip, take)
                take = temp_skip + num
            return max(skip, take)

        return dp()
