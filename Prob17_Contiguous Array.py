#Time Complexity : O(n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no. 


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sums = 0
        ans = 0
        d = {0: -1}
        for i in range(len(nums)):
            sums += -1 if nums[i] == 0 else 1
            if sums in d:
                ans = max(ans, i-d[sums])
            else:
                d[sums] = i
        return ans
        