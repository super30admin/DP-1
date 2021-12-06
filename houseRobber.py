# // Time Complexity : O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach



class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        Pseudocode:
        each step we have a descion to make can rob the house or leave the house
           0  1
        1  0  1
        2  1  2
        3  2  4
        1  4  3
        skip = 0
        take = nums[1]
        ans = 0
        for i in nums:
            temp_skip = skip
            skip = max(skip,take)
            take = max(ans,nums[i]+tmep_skip)

        """
        rows = len(nums)
        cols = 2
        rob_array = [[0 for i in range(cols)] for j in range(rows)]

        rob_array[0][1] = nums[0]

        # print(rob_array[0][1])

        for i in range(1,len(nums)):
            rob_array[i][0] = max(rob_array[i-1][0],rob_array[i-1][1])
            rob_array[i][1] = rob_array[i-1][0] + nums[i]


        return max(rob_array[len(nums)-1][0],rob_array[len(nums)-1][1])