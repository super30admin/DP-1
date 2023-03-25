# Time Complexity : O(n) because we are iterating through the array once
# Space Complexity : O(n) because we are using a hashmap to store the values
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""We use a hashmap to store the values. We use a helper function to recursively find 
the maximum amount that can be robbed within the array."""

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0

        book = collections.defaultdict()
        answer = self.helper(nums, 0, book)
        return answer

    def helper(self, nums:List[int], index:int, book:dict) -> int:
        if index in book:
            return book[index]

        # when to end recursion:
        if index == len(nums) - 1:
            return nums[index]
        if index > len(nums) - 1:
            return 0

        # to not rob
        case1 = self.helper(nums, index+1, book)

        # to rob
        case2 = nums[index] + self.helper(nums, index+2, book)

        book[index] = max(case1, case2)
        return book[index]
