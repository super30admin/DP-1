'''
T.C: O(n)
n - length of nums
S.C: O(1)

Intuition: bottum up dp, start from last and ull be left with robbing 1st or 2nd house

'''
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums_len = len(nums)
        if not nums_len:
            return 0
        
        if nums_len <= 2:
            return max(nums)
        
        last = nums[-1]
        sec_l = max(last, nums[-2])
        third_l = 0
        
        for i in range(nums_len - 3, -1, -1):
            third_l = max(nums[i] + last, sec_l)
            last = sec_l
            sec_l = third_l
        
        return max(sec_l, third_l)