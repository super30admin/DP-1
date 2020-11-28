# Robber House
# House Robber

# Time Complexity : O(n), the number of houses
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, Runtime: 28 ms and Memory Usage: 14.2 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
The recursive approach to the problem fails due to increase in time complexity. 
Using Dynamic Programming we initialize variables as skip and take which helps
in choosing which house to not rob or rob by finding the maximum amongst the
choices made. It is optimized approach than using Greedy approacch or Reecursive approach.
As well as using Dynamic Programming by initializing 2D array. 

"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if(len(nums)==0 or nums==None): # Edge Cases
            return 0
        skip=0      # Dont rob a house
        take=nums[0] # Rob a house starting with index 0
        for i in range(1,len(nums)): 
            temp=max(skip,take)  # Finding the maximum among robbing a house or not robbing house
            take=skip+nums[i]
            skip=temp
        return max(skip,take) # returning Maximum