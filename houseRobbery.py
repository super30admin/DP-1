class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None and len(nums) == 0:
            return -1
        
        not_rob = 0
        rob = 0
        for i in range(len(nums)):
            temp = rob
            rob = max(rob,not_rob + nums[i])
            not_rob = temp
            
        return max(rob,not_rob)
    
    
    
#Time complexity ---> O(n)
#Space complexity ----> O()