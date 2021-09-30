class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)  == 1:
            return nums[0]
        self.final = 0
        bank = {}
        def chor(i,kamai):
            
            kamai += nums[i]
            if i not in bank.keys():
                bank[i] = kamai
            elif bank[i] < kamai:
                bank[i] = kamai
            else:
                return
            if i == len(nums)-1 or i == len(nums)-2:
                
                self.final = max(self.final,kamai)
                return
            
            for j in range(i+2,len(nums)):
                chor(j,kamai)
        chor(0,0)
        chor(1,0)
        return self.final