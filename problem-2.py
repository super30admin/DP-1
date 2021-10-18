#Time Complexity: O(n)
#Space Complexity: O(1)
#Problem sucessfully accepted in leetcode: yes
class Solution:
    def rob(self, nums: List[int]) -> int:
        taken=0
        notTaken=0
        res=0
        for num in nums:
#Store the value if previous house not taken
            prevnotTaken=notTaken
#Calculate not taken of current house as max of taking and not taking previous house
            notTaken=max(taken,notTaken)
#Taking current house by adding current value to not taking previous
            taken=prevnotTaken+num
#Decide taking current house by max of taking and not taking
            res=max(res,max(taken,notTaken))
        return res