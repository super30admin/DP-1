#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
#at each instance we can either pick a particular house or not pick it. If we don't pick this house,
#then the solution would be the max(picking the previous house, not picking the previous house).
#If we decide to pick this house, then solution for that would be the amount obtained by
# not picking the previous house + amount of currrent house. 
class Solution:
    def rob(self, nums) -> int:
        j=1
        #recursion formuale: L[j]=max(L[j+1], L[j+2]+L[j])
        not_pick=0
        pick=nums[0]
        while(j<len(nums)):
            #case where nums[j] is not picked
            temp=max(not_pick,pick)
            #case where nums[j] is picked
            temp1=not_pick+nums[j]
            not_pick=temp
            pick=temp1
            j+=1
        #print(pick,not_pick)
        return max(not_pick,pick)
s=Solution()
nums = [2,7,9,3,1]
print(s.rob(nums))