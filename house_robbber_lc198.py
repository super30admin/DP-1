"""
Name: Srinidhi Bhat
Time Complexity - O(n) - Recursion Stack has n elements.
Space Complexity - O(2^n) - every node has two paths 

Did it run on Leetcode - TLE - time limit exceed
Logic -
1.What do we need? - total(i) = max(total(arr,pos-2)+arr[pos],total(arr,pos-1))
We can either take an item, or not - based on that 
design a reccurence relation.
"""

class Solution:
    def robHelper(self,arr,pos):
        if pos<0:
            return 0
        return max(arr[pos]+self.robHelper(arr,pos-2),self.robHelper(arr,pos-1))
    
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        
        if len(nums)==1:
            return nums[0]
        
        if len(nums)==2:
            return max(nums[0],nums[1])
        
        position = len(nums)-1
        return self.robHelper(nums,position)