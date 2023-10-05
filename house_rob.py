# time complexity: O(n)
# Space complexity: O(1)
# Did this code successfully run on Leetcode : yes

# rob1 and rob2 to calculate max money robbed without taking money from adjacent houses in array
# in loop- we check which has max money value by adding current house (num) to 2 houses before-rob1 and the rob2-which is adjacent house. 
# Then we update values for rob1 and rob2 for use in next iteration. 
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        rob1, rob2 = 0, 0
        for num in nums:
            temp = max(num+rob1, rob2)
            rob1=rob2
            rob2=temp
        return rob2