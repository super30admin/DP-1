class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0]*len(nums)
        if not nums:
            return 0
        if len(nums)==1:
            return nums[0]
        dp[0]=nums[0]
        dp[1]=max(nums[0],nums[1])
        for i in range(2,len(nums)):
            dp[i] = max(dp[i-1],dp[i-2]+nums[i])
            
        return max(dp)
        
        
        #tc ---> o(n)
        #sc----> o(n), But this could be efficient, if we use variables instead of dp array
   '''  class Solution:
          def rob(self, nums: List[int]) -> int:
              prev , curr =0,0

              for num in nums:
                  temp = prev
                  prev = curr
                  curr = max(temp+num,prev)
              return curr
              
              
              tc --> o(n)
              sc ---> o(1)'''
        
