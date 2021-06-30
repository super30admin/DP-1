class Solution:
    def rob(self, nums: List[int]) -> int:
        store=[0]*len(nums)
        for i in range(len(nums)):
            housePre1=0
            housePre2=0
            store[i]=nums[i]
            if i>=2:
                housePre1=store[i-2]
            if i>=3:
                housePre2=store[i-3]
            store[i]=max(store[i]+housePre1,store[i]+housePre2)
        
        return max(store)
        #Time O(n)
        #Space O(n)
        #House Robber
