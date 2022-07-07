# Time Complexity : O(N) //As it would run N times in nums
#  Space Complexity : O(1) //The variables defines takes in constant time
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        #Declare variable to to maintain the previous and current value
        rob = 0
        anotherRob = 0
        
        #Here we manipulate with three varaibles val being stored as first previous value and rob being the current value of the robbery done
        for i in range(len(nums)):
            val = rob
            rob = nums[i] + anotherRob
            anotherRob = max(val, anotherRob)
        return max(rob,anotherRob)
    