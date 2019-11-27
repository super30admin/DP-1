# Time Complexity : Brute Force: O(2^n) S:target, DP1: O(n), DP2: O(n)
# Space Complexity : Brute Force: O(2^n) S:target, DP1: O(n), DP2: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution1(object):
    def __helper(self, nums, index, money):
        if index >= len(nums):
            return money
        choosen = self.__helper(nums, index + 2, money + nums[index])
        notchoosen = self.__helper(nums, index + 1, money)
        return max(choosen, notchoosen)
    
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.__helper(nums, 0, 0)

class Solution2(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0 or nums == []:
            return 0
        
        dp = [[None for x in range(2)] for y in range(len(nums))] 
        dp[0][0] = nums[0]
        dp[0][1] = 0
        
        for i in range(1, len(nums)):
            dp[i][0] = dp[i-1][1] + nums[i]
            dp[i][1] = max(dp[i-1][0], dp[i-1][1])
        
        return max(dp[len(nums) -1 ][0], dp[len(nums) -1 ][1])

class Solution3(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0 or nums == []:
            return 0
        
        choosen, notChoosen = nums[0], 0
        for i in range(1, len(nums)):
            notChoosen, choosen = max(choosen, notChoosen), notChoosen + nums[i]
        
        return max(choosen, notChoosen)

o1, o2, o3 = Solution1(), Solution2(), Solution3()
nums = [1,2,3,1]
print(o1.rob(nums))
print(o2.rob(nums))
print(o3.rob(nums))