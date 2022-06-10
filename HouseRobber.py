#T(N)= O(N)
# S(N) = O(N)

# Where N is lnegth of nums

class Solution:
    def rob(self, nums: List[int]) -> int:
        a=[0 for i in range(len(nums)+1)]
        for i in range(1,len(nums)+1):
            if i<2:
                a[i]=nums[i-1]
            else:
                a[i]=max((nums[i-1]+a[i-2]),a[i-1])
        return a[-1]
            
        