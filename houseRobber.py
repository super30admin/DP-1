# All analysis is for the solution on line 24 and beyond.
# Time Complexity : O(n), where n is the length of nums array.
# Space Complexity : O(n), where n is length of nums array.
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : No.

# Your code here along with comments explaining your approach
class Solution(object):
    # approach 1 greedy, Time limit exceeded
    def robGreedy(self, nums):
        if nums == None or len(nums) == 0:
            return 0
        return self.helper(nums, 0, 0)

    def helper(self, nums, index, count):
        # base case
        if index >= len(nums):
            return count
        # logic
        caseChoose = self.helper(nums, index + 2, count + nums[index])
        caseNotChoose = self.helper(nums, index + 1, count)

        return max(caseChoose, caseNotChoose)

    # making a dp array of values, where each value is the max of either
    # the previous house's sum amount or an (alternate house behind + current house) value.
    # return the last sum at last index in dp array.
    def rob(self, nums):
        size = len(nums)
        if nums == None or size == 0:
            return 0

        dpArray = [0] * size
        for i in range(size):
            if i == 0:
                dpArray[i] = nums[i]
            else:
                # choosing max of last sum or an alternate house behind value + current house value.
                dpArray[i] = max(dpArray[i-2] + nums[i], dpArray[i-1])

        return dpArray[size-1]

print(Solution().rob([10,5,1,2]))
