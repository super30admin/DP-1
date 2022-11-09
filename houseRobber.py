'''
Time Complexity -->
O(m*n) where m is number of elemnts in array and n is teh sum of teh amount

Space Complexity -->
O(m*n) since we are using 2d array
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        s_sum = 0
        for i in range(len(nums)):
            s_sum+=nums[i]
        if s_sum ==0:
            return 0
            
        dp = [[0 for i in range(s_sum+1)] for x in range(len(nums)+1)]
        val = self.MaxMoney(nums, 0, 0, dp)
        return(val)
    
    
    def MaxMoney(self, nums, index, amount, dp):
        if index<len(nums):
            if dp[index][amount]!=0:
                return dp[index][amount]
            else:
                dp[index][amount] = max(self.MaxMoney(nums, index+1, amount, dp), self.MaxMoney(nums, index+2, amount+nums[index], dp))
                return dp[index][amount]
            
        else:
            return amount
            
        