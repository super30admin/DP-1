#Time Complexity: O(n) here n is length of nums
#Space Complexity: O(1) as we are using two variables choose and notChoose
#Did your code run on leetcode : yes

class Solution:
    def rob(self, nums: List[int]) -> int: 
        if nums == [] or len(nums) == 0 : return 0
        
        
        if len(nums)  == 1: return nums[0]
        
        if len(nums) == 2 : return max(nums[0],nums[1])
        choose = nums[0]
        notChoose = max(nums[0],nums[1])
        
        for i in range(2,len(nums)):
            temp = choose
            choose = max(choose , notChoose)
            notChoose = nums[i] + temp
            
        return max(choose,notChoose)
        
        

