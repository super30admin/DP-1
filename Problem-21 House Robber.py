# 198. House Robber
# https://leetcode.com/problems/house-robber/

# Brute Force
class BF_Solution:
    def _helper(self,nums,count,idx):
        if idx >= len(nums):
            return count
        
        notTaken = self._helper(nums,count,idx+1)
        taken = self._helper(nums,count+nums[idx],idx+2)

        return max(notTaken,taken)

    def rob(self, nums) -> int:
        return self._helper(nums,0,0)

obj = BF_Solution()
print(obj.rob([1,2,3,1]))
print(obj.rob([2,7,9,3,1]))

# DP
# Time complexiety: O(n)
# Space complexiety: O(1)
class Solution:
    def rob(self, nums) -> int:
        notTaken = 0
        taken = -1

        for i in range(len(nums)):
            notTaken, taken = max(notTaken,taken), nums[i] + notTaken
        return max(notTaken,taken)

obj = Solution()
print(obj.rob([1,2,3,1]))
print(obj.rob([2,7,9,3,1]))