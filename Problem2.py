# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums):
        if not nums or len(nums) ==0:
            return 0 
        if len(nums) == 1 :
            return nums[0]
        small = nums[0]
        large = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            current  = max(large, small + nums[i])
            small = large 
            large = current
        return large 

if __name__ == "__main__":
    s = Solution()
    nums = [2,7,9,3,1]
    res = s.rob(nums)
    print(res)
