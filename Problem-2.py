# House Robber
'''
Leetcode all test cases passed: Yes
Solution:
    rob(self, nums):
        n is the number of houses or length of nums
        Space Complexity: O(1)   
        Time Complexity: O(n)
'''

class Solution:
    def rob(self, nums):
        rob = 0
        do_not_rob = 0
        for house in nums:
            do_not_rob,rob = max(rob,do_not_rob), do_not_rob  + house
        return max(rob,do_not_rob)
