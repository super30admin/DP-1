// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution:
    def rob(self, nums: List[int]) -> int:
        def totalMoney(memo):
            memo[0] = nums[0]
            memo[1] = nums[1]    
            for house in range(2,len(nums)): 
                options = [memo[n] for n  in range(house-2,-1,-1)] 
                memo[house] = nums[house]+ max(options)
                
        if not nums:   
            return 0 
        elif len(nums) == 1:
            return nums[0]
        elif len(nums) == 2: 
            return max(nums[0],nums[1])
        
        memo = [0 for _ in range(len(nums))]
        totalMoney(memo)
        return max(memo)
        
