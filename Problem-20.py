
#leet code -198
#recursion
# Time complexity = O(2^N)
#space complexity =O(N)
# Got maximum recursive depth error for both the problems while solving through recursive

class Solution(object):
    def rob(self, nums):
        return self.helper(nums,0,0)
        
    def helper(self,nums,i,max_amt):
        
            
            #edge case
            if (i>=len(nums)) :
                return max_amt
            #choosen 
            case1 = self.helper(nums,i+2,(max_amt+nums[i]))
            
             #not choosen
            case2=self.helper(nums,i+1,max_amt)
       
        return max(case1,case2)


# dynamic programming
# Time complexity =o(n)
# space complexity =o(n)
# Dynamic programming approach - First we need to create the matrix of size (n,2). matrix[i][0] stores the maximum element from previous array and matrix[i][1] stores the sum of previous nonchoosen value and current number.


class Solution(object):
    def rob(self, nums):
        if (nums == None or len(nums)==0 ): #edge cases
            return 0
        if len(nums)==1:
            return nums[0]
        
        
        col,rows=2,len(nums)
        i,j=0,0
        dp=[[0 for i in range(col)] for j in range(rows)]
        dp[0][0]=0  #base case
        dp[0][1]=nums[0] #base case
        
        
        for i in range(1,len(nums)):
            for j in range(2):
                if j==0:
                    dp[i][0]=max(dp[i-1][0],dp[i-1][1])
                else:
                    dp[i][1]=dp[i-1][0]+nums[i]
        return max(dp[i][0],dp[i][1])
                
#dynamic programming optimized solution : Same as above but storing the previous results.
#time complexity =o(N)
#space complexity =O(1)


class Solution(object):
    def rob(self, nums):
        if (nums == None or len(nums)==0 ):
            return 0
        if len(nums)==1:
            return nums[0]
        temp=0
        choosen=0
        not_choosen=0
        
        for i in range(len(nums)):
            temp=choosen
            choosen=not_choosen+nums[i]
            not_choosen=max(temp,not_choosen)
        return max(choosen,not_choosen)
            
    
