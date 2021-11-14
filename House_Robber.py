def HouseRobber(nums) -> int:
    return helper(nums,0)
    
def helper(nums, count) -> int:
    #base
    if len(nums) <= 0:
        return count
    #recursive logic

    #Choose case
    case1 = helper(nums[2:], count + nums[0])

    #Not Choose case

    case2 = helper(nums[1:], count)

    return max(case1,case2)

output = HouseRobber([1,2,3,1])

print(output)

