# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :found trouble finding the logic


# // Your code here along with comments explaining your approach




class Solution:
    def rob(self, nums: List[int]) -> int:
        print(nums)
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        li=[]
        li.append(nums[0])
        print()
        li.append(max(li[0],nums[1]))
        for i in range(2,len(nums)):
            li.append(max((nums[i]+li[i-2]),(li[i-1])))
        print(li)
        return li[len(nums)-1]
        