# Time Complexity :O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, had to lookup solution several times.
class Solution:
    def rob(self, nums: List[int]) -> int:
        house1=0
        house2=0
        for n in nums:
            temp=max(house1+n,house2)
            house1,house2=house2,temp
        return house2