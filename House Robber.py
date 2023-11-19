#LC: yes, 198
#problems: NA
#TC: O(2^n), n is len of nums, TLE!!
#SC: O(2^n), n is len of nums
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        def helper(nums, idx, amount):
            #base
            if(idx >= len(nums)):
                return amount
            
            #logic
            #choose
            case1= helper(nums, idx+2, amount+nums[idx])
            
            #no chosse
            case2= helper(nums, idx+1, amount)
            
            return max(case1, case2)
        return helper(nums, 0, 0)
 
#TC: O(n), n is len of nums
#SC: O(n), n is len of nums
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        
        if len(nums) < 2:
            return nums[0]
        
        n = len(nums)
        dp = [0]*n
        
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, n):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
            
        return dp[n-1]

#TC: O(n), n is len of nums
#SC: O(1), n is len of nums
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        
        if len(nums) < 2:
            return nums[0]
        
        n = len(nums)
        
        prev = nums[0]
        curr = max(nums[0], nums[1])
        
        for i in range(2, n):
            temp = curr
            curr = max(curr, nums[i]+prev)
            prev = temp
            
        return curr
    

            
        
