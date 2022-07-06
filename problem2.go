
// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Approach 1 Time limit exceed

func rob(nums []int) int {
    if len(nums) == 0{
        return 0
    }   
    
    return helper(nums,0,0)
}


func helper(nums []int, index int, amount int) int{
    
    
    if index >= len(nums){
        return amount
    }
    
    case0:= helper(nums,index+1,amount)
    
    case1:= helper(nums,index+2,amount+nums[index])
    
    return max(case0,case1)
}


func max(a,b int) int{
    if a > b{
        return a
    }
    
    return b
}


//Approach 2
func rob(nums []int) int {
    if len(nums) == 0{
        return 0
    } 
 
    n := len(nums)
    
    skip:=0
    take:=nums[0]
    
    for i:=1;i<n;i++{
        temp := skip
        
        skip = max(skip,take)
        take = temp+nums[i]
    }
    
    return max(skip,take)
    
}
