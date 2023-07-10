class Solution:
    def rob(self, nums: List[int]) -> int:
        prev=0
        curr=0
        for num in nums:
            temp= prev
            prev= curr
            curr= max(num+temp, prev)
        return curr