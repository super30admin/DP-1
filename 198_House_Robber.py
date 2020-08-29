# Leetcode problem link : https://leetcode.com/problems/house-robber/
# Time Complexity : O(n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(2^n) => form a tree for each starting index as house and to choose or not choose the house to rob and explore all the options. It will be exponential as we are going through each subtree recursively with two options: choose the house or not to choose the house till we reach the end of house array

        Optimized approach: O( n ) => At each index, keep track of previous two values to choose the house to rob and not to choose the house to rob. The value for not choosing the house will be maximum of previous two values (i.e. choosing or not choosing the previous house). But when we chose the house the value will be what is robbed from current house + not choosing the prev house ( as we cant rob two consecutive houses)

        
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        # 1. Declare the two variables
        C = 0
        DC = 0
        # Traverse through the house value array 
        for num in nums:
            # store dont choose from previous index in a temp variable as it will be used to compute the current choose value
            temp = DC
            # not choosing the current house will result in current value to be max of choosing or not choosing prev house
            DC = max(C, DC)
            # choosing current house, we cant choose prev house so we add current house cash value to value computed when we didnt choose the prev house
            C = temp + num
        # return maximum of choosing and not choosing the last house at the end
        return max(C, DC)
        