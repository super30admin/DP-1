# Leetcode 198. House Robber

# Time Complexity :  O(n) where n is the size of the array

# Space Complexity : O(1) for iterative search and O(log n) for the recursive search where n is the size of the array.

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use a matrix to store the optimal solution of the previous step and initialize the first row cells
# to 0 and first element in the nums array as they represent the first house being skipped or robbed.
# Either skip the house and take the maximum of previous house YES case or NO case
# rob the house  and take the NO case of previous house and the current house money
# return the maximum value of the last row after the last house.

# Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == None:
            return 0

        matrix = [[None for _ in range(2)] for y in range(len(nums))]
        matrix[0][0] = 0
        matrix[0][1] = nums[0]

        # Either skip the house and take the maximum of previous house YES case or NO case
        # rob the house  and take the NO case of previous house and the current house money
        for i in range(1, len(nums)):
            matrix[i][0] = max(matrix[i-1][0], matrix[i-1][1])
            matrix[i][1] = matrix[i-1][0] + nums[i]

        return max(matrix[len(nums)-1][0], matrix[len(nums)-1][1])
