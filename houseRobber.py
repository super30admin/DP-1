# TC: O(N), N - > num_houses
# SC: O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        c, nc = 0, 0
        
        for n in nums:
            _c = nc + n
            _nc = max(c, nc)
            c, nc = _c, _nc
            
        return max(c, nc)
        