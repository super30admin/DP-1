# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def rob(self, nums):
        skip = 0
        take = nums[0]

        for i in range(1,len(nums)):
            prev_skip = skip
            skip = max(prev_skip,take)
            take = prev_skip + nums[i]
        return max(skip,take)


obj = Solution()
house = [2, 7, 9, 1, 1, 8]
print(obj.rob(house))
