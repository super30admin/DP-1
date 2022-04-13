#Time Complexity : O(1)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no. 

def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n==0:
            return 0;
        if n == 1:
            return nums[0]
        s = [0]*(n+1)
        s[1] = nums[0]
        s[2] = nums[1]
         
        for i in range(3,n+1):
            s[i] = (max(s[i-2],s[i-3]) + nums[i-1])
        return max(s[n],s[n-1])