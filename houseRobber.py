#TimeComplexity: Searching all the houses money in one pass so  O(N)
#SpaceComplexity: O(1) NO Auxiliary Space, we are manipulating input array
#It successfully runs on leetcode

def rob(nums):
    #Changing input array so nums[0] at 0 index which will be max money we can get at that point.
    for i in range(1,len(nums)):
        if i==1: #for max money till index 1 can be compared taking maximum from prev and current
            nums[i]= max(nums[i], nums[i-1])
        else:
            #Maximum of this two :
            #take either current house money + alternate previous house money (as per security)
            #or just max money till previous house skipping current house
            nums[i]= max(nums[i]+nums[i-2], nums[i-1])
    return nums[-1] # Max money can be robbed till the last point
        
print(rob([2,1,1,2]))