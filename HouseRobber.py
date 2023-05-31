# Time complexity : O(n)
# Space complexity : O(1)
#The code ran on Leetcode

# Since the robber cannot rob 2 consecutive houses, at index i the money he can rob is nums[i] + nums[i-2] or nums[i-1]
# Consider 3 houses at once and keep updating the max value in the array. The value at the last index is the max he can rob.
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        for i in range(1, len(nums)):

            if i == 1:
                nums[i] = max(nums[i], nums[i-1])
            else:
                nums[i] = max(nums[i-1], nums[i] + nums[i-2])

        return nums[-1]