"""
Time Complexity : O(n) whene n is the number of houses
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
This is the DP approach with constant space. At every house, the robber has 2 options, either to choose
or to not choose. Here, if the robber decides to choose a house, his earnings uptil now can be money in 
the house + total money when he did not choose the previous house. If the robber decides not to choose
a house, his total earnongs would be the maximum of what he earnt till now(if he chose or did not choose
the previous house). Finally, we can return the maximum earnings.
"""


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        not_choose, choose = 0, 0
        for i in nums:
            not_choose, choose = max(not_choose, choose), i+not_choose
        return(max(not_choose, choose))


"""
This is the recursive code as of now which I wrote, will be modifying it to DP and submitting again
once I understand how DP can be handled here. For now it gives me time limit exceeded. Thanks
"""


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        return self.helper(nums, 0, 0)

    def helper(self, nums, idx, maxsum):
        if idx >= len(nums):
            return maxsum
        case1 = self.helper(nums, idx+2, maxsum+nums[idx])
        case2 = self.helper(nums, idx+1, maxsum)
        return max(case1, case2)
