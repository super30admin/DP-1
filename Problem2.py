# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#basically its just decision to take a coin or not

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        a = [0 for i in range(len(nums)+1)]
        
        a[1] = nums[0]
        
        for i in range(2,len(a)):
            a[i] = max(a[i-1],nums[i-1]+a[i-2])
        
        return a[len(nums)]
        