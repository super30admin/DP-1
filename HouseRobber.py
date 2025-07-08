# Time Complexity : It is O(n) looping through list of n elements.
# Space Complexity : Creating the matrix of O(n) to rob the max amount.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) <=2:
            return max(nums[0],nums[1])
        
        maxRob = [None] * (len(nums) + 1)        
        maxRob[0]=0
        amount=0
        for i in range(1,len(maxRob)):
            previousAmount = maxRob[i-1]
            currentAmount = nums[i-1] 
            if i >=2 :
               currentAmount+= maxRob[i-2]
            amount = max(previousAmount,currentAmount)
            maxRob[i]=amount
            
        
        return maxRob[-1]
        

obj = Solution()
print(obj.rob([1,2,3,1]))
print(obj.rob([2,7,9,3,1]))