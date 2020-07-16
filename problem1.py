'''
Time Complexity :O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: There are 2 ways to rob the house either to rob the alternate house or the max accumulated if its higher than
the sum of the alternate ones.
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        prev = 0
        max1 = 0
        for i in nums:
            temp = max1
            max1 = max(prev + i, max1)
            prev = temp

        return max1