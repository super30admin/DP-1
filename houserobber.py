class Solution:
    # complexity: Space O(n), Time: O(n)
    def rob(self, nums: List[int]) -> int:
        # i,len(nums)-1 value will be stored here
        if(len(nums)==0):
            return 0
        if(len(nums)==1):
            return nums[0]
        x = [-1*float(inf) for i in range(0,len(nums))]
        num = deque(nums)
        # fixing last 2 as base cases
        x[-1] = num.pop()
        x[-2] = max(x[-1],num.pop())
        i = len(x) - 3
        while(i>=0):
            a = num.pop()
            # either a is choosen or not choosen.
            x[i] = max(a+x[i+2],x[i+1])
            i = i-1
        
        return x[0]
