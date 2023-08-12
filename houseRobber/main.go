/*
approach: bottom up ; using dp array
    - we only have 1 decision making variable therefore prefernce on dp array over matrix
        - matrix can work too if you want to use the naive 0/1 as decision vars
    - since we are solving bottom up, we will scope each problem only up until that idx(inclusive)
        - for example; [2,7,9,3,1]
        - if we are solving for idx 2 (value 9)
        - then in bottom up, we scope our problem from 0 till idx 2 (inclusive)
        - therefore our subproblem becomes [2,7,9] - forget the right side, thats what bottom up says!
        - solve at a idx, by looking back 
        - solve the global problem by 
            - leveraging previously computed results!
        - OR DRAW THE 0/1 decision tree from right side ( just like coin change )
    - for each idx i ( starting from idx 1 in nums array - since idx 0 does not have a previous house to compare to, so that answer will not change)
        - the answer for subproblem [2] will always be 2
        - therefore starting at idx 1
    - for each idx i, we have 2 choices
        1. choose this house; which means we cannot pick the immediate previous house, but can pick the one before the immediate previous
            - where is the FINAL answer for immediate previous idx and previous-previous idx located? in the dp array
            - the nums array just gives us whats in store in that house, not the final answer for that house.
            - nums[i] + dp[i-2]
            - if we draw the bottom up decision tree!
                            [2,7, 9 ]
                                 0/ \1
this is 1 step back [2,7] [2] = this subproblem is 2 steps back!
                  
        2. not choose; which means we can pick the immediate previous FINAL answer ( dp[i-1] )
            - dp[i-1] ( 1 step back )
    - then its just a max(choose, notChoose)
            - dp[i] = max(nums[i]+dp[i-2], dp[i-1])
    - we will go thru the entire nums array from idx 1 and fill out the dp array 

    WHY extra dummy element in dp array???
    - dp array size, lets says its same as nums array
    - dp[i-1] wont fail since we start from idx = 1
    - dp[i-2] will fail when we start our loop at 1
    - we have 2 choices to fix this
        1. either handle the edge case of going out of bounds
        2. take an extra element in dp array ( len(nums)+1 ) and start from idx 2
            - so that dp[i-2] will end up at dp[0] 
            - but now the i pointer will point to incorrect position in nums array ( same problem as coin change )
            - therefore when we need to reference current element in nums array, we will use i-1 ( coins[i-1] gave us coin value because of the extra row we took - same problem here but in 1d array )
            
    time: o(n)
    space: o(n)
*/
// func rob(nums []int) int {
//     n := len(nums)
//     if n == 1 {return nums[0]}
//     // if nums = [1,2,3,1]
//     // no need to offset or add dummy cell because 
//     // dp[0] means solve for nums[0]; [1] = max(choose1, notChoose1); therefore dp[0] = nums[0]
//     // dp[1] means solve for nums[1]; [1,2] ( bottom up), max(choose2, notChoose2)
//     // notChoose2, then problem becomes [1], which is 1 step back
//     // choose2, means choose this but not previous house ( ie. nums[i] + dp[i-2] // excluding prev house )
//     dp := make([]int, n)
//     dp[0] = nums[0]
//     dp[1] = max(nums[0], nums[1])
//     for i := 2; i < n; i++ {
//         // nums position is off by 1 because we took a dummy idx 0 to accomodate for dp[i-2] 
//         //           choose+prev-prev OR notChoose then use prev
//         dp[i] = max(dp[i-1], nums[i]+dp[i-2])
//     }
//     return dp[n-1]
// }

/*
    approach: bottom up dp + space optimization
    - using previous solution but instead of dp array, we just need 2 answers for each ith problem
        - immediate previous ( lets call this current )
        - immediate previous-previous ; 2 steps back answer ( lets call this previous )
    - once we solve for ith position
        - promote current value to previous ( prev = current )
        - set the new value to current ( current = newCurrent ) 
    
    time: o(n)
    space: o(1)
*/

func rob(nums []int) int {  
    prev := 0 // 2 steps back
    current := nums[0] // immediate previous
    for i := 1; i < len(nums); i++ {
        newCurrent := max(nums[i]+prev, current)
        prev = current
        current = newCurrent
    }
    return current
}

func max(x, y int) int {
    if x > y {return x}
    return y
}
