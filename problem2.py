#problem  2 house robber
#leetcode solution accepted
#time complexity : O(n) where n is the size of array
class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1,rob2 = 0,0 #maintaing last two max we can rob from
        #[rob1,rob2,n,n+1,........] 
        #iterating through the array
        for n in nums:
            temp = max(n+rob1,rob2)#n+rob1 so there is a gap between the previous house
            rob1 = rob2
            rob2 = temp
        return rob2