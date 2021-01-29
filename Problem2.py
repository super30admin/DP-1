"""
198. House Robber
Time Complexity - O(n)
Space Complexity - O(1)
Here we are using two variables choose and dont_choose to resemble if you are choosing that house or not as we can't rob adjacent houses.

Using a loop to iterate given list
    if we choose the house:
        choose = dont_choose o previous house + amount in current house
    else    
        find max from previous house 
returning max value between choose and dont_choose
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None and len(nums) == 0:
            return 0
        
        choose = 0
        dont_choose = 0
        temp = 0
        for i in range(len(nums)):
            for j in range(0,2):
                if j == 0:
                    temp = choose
                    choose = dont_choose + nums[i]
                else:
                    dont_choose = max(temp,dont_choose)
        return max(choose,dont_choose)
                    