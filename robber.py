#TC = O(n)
#SC= O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        prev=0
        curr=0
        
        for i in nums:
            temp=prev
            prev= curr
            curr=max(i+temp,prev)
        return curr  