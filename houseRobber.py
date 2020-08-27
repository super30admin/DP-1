# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
        # maintain two pointers: when you choose, one when you don't choose
        ch = 0
        dch = 0
        
        # for each element in the array, assess if we choose or don't choose the house to rob: if a house is chosen-> assign value of ch to the maximum of previous ch value and current+ previous dch value
        # update dch value and temp to track the previous vals when pointer value changes
        for i in range(len(nums)):
            temp = ch
            ch = max(dch+nums[i], ch)
            dch = temp
        
        # return the max value gotten by the choices made!
        return ch
            
            