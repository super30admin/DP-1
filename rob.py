# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No
class Solution(object):
    def rob(self, nums):
        rob1,rob2=0,0
        for i in nums:
            temp=max(i+rob1,rob2)
            rob1=rob2
            rob2=temp
        return temp
            
        
        