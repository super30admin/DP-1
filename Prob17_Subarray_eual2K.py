#Time Complexity : O(n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no. 

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        d = {}
        cum = count = 0
        for num in nums:
            cum += num
            if cum == k:
                count +=1
            if cum - k in d:
                count += d[cum-k]
            if cum in d:
                d[cum] += 1
            else:
                d[cum] = 1
        return count