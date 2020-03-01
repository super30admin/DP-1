
# RECURSIVE SOLUTION

# Time Complexity: O(2^n)
# Space Complexity: No Extra Space, Recursive Stack uses O(n)
# Did problem run on Leetcode: yes with TLE 

class Solution:
    def houseRobber(self, nums):
        return self.helper(nums, 0, 0)

    def helper(self, nums, index, maxAmount):

        # BASE CASE
        if index >= len(nums):
            return maxAmount

        # LOGIC
        # Choose the House,
        case1 = self.helper(nums, index+2, maxAmount+nums[index])

        # Not-Choose the House,
        case2 = self.helper(nums, index+1, maxAmount)

        return max(case1, case2)

output = Solution()
print(output.houseRobber(nums=[1, 2, 3, 1]))




