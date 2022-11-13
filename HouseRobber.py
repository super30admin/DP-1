class Solution:
    def rob(self, nums: list[int]) -> int:
        """
        Time complexity - O(n). n - no.of houses
        Space Complexity - O(1)
        """
        # this stores the max amount of money robbed till a house when current house is robbed.
        included_max = 0
        # this stores the max amount of money robbed till a house when current house is not robbed.
        normal_max = 0
        for num in nums:
            # choose max of including current house ( then normal_max of previous house)
            # or donot include current house (then choose previous house included max)
            cur_max = max(normal_max + num, included_max)
            normal_max = included_max
            included_max = cur_max
            
        return cur_max
            
            