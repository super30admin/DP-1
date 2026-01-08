//
//  HouseRobber.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/4/26.
//

/*
 [2, 7, 9, 3, 1]
 first check the greedy approach - selecting the maximum. It wouldn't work for [2, 7, 9, 8, 1]
 second greedy approach - take maximum of alternate houses. 2 + 9 + 1 = 12, 7 + 3 = 10
 These can fail when 1. we don't want to rob alternate houses and we cant use the maximum of two approach
 
 above approaches fail with - [2, 1, 1, 3, 5, 4]
 
 Exhaustive solution -
 1. either rob the house 2. don't rob the house
 scenario - If we are not robbing the alternate houses and now robbing the house with maximum value but still we get maximum value.
 */
//brute force solution

//One decision making variable = number of houses. Subproblems depends upon the input variables.

class HouseRobber {
    init() {
        let maximumRobbing = maximumRobbing(nums: [2, 1, 1, 3, 5, 4])
        print("maximum robbing \(maximumRobbing)")
    }
    func maximumRobbing(nums: [Int]) -> Int {
        if (nums.count == 1) {
            return nums[0]
        }
        return helper(nums: nums, index: 0)
    }
    
    private func helper(nums: [Int], index: Int) -> Int {
        //base
        if (index >= nums.count) {
            return 0
        }
        //logic
        //don't choose
        let case1 = helper(nums: nums, index: index + 1)
        
        //choose
        let case2 = nums[index] + helper(nums: nums, index: index + 2)
        
        return max(case1, case2)
    }
    
  
}

//Use Dp
/*
 optimize recursion using memoization
 tabulation -  bottom up approach
 
 1 D array for storage - because we have 1 input variable
 */
class HouseRobberUsingDpTabulation {
    init() {
        let maximumMoney = HouseRobberUsingDP(nums: [2, 1, 1, 3, 5, 4])
        print("maximum money using DP house robber \(maximumMoney)")
        
        let max = HouseRobberUsingTwoVariables(nums: [2, 1, 1, 3, 5, 4])
        print("max HouseRobberUsingTwoVariables *** \(max)")
    }
    
    func HouseRobberUsingDP(nums: [Int]) -> Int {
        if (nums.count == 0) {
            return 0
        }
        if (nums.count < 2) {
            return nums[0]
        }
        var dp: [Int] = Array(repeating: 0, count: nums.count)
        //first element in dp should be first element of the input array
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])
        for i in 2..<nums.count {
            /*
             dp[i-1] - if not choosing, give value for the array until previous index
             if choosing - then nums[i] + dp[i-2] //because we should rob alternate house
             */
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        }
        
        return dp[nums.count - 1]
    }
    
    /*
     We are using the dp values for the previous 2 indices in Dp array, hence can save those two indexed value in two variables and can eliminate the dp array. Space optimization
     */
    func HouseRobberUsingTwoVariables(nums: [Int]) -> Int {
        let n = nums.count
        if (n == 0) {
            return 0
        }
        if (n < 2) {
            return nums[0]
        }
        //we can have boolean array path
        var path: [Int] = Array(repeating: 0, count: n)
        var prev = nums[0]

        path[0] = 1
        var curr = max(nums[0], nums[1])
        if (nums[1] > nums[0]) {
            path[1] = 1
        }
        for i in 2..<n {
            let temp = curr
            if (curr < nums[i] + prev) {
                path[i] = 1
            } else {
                path[i] = 0
            }
            curr = max(curr, nums[i] + prev)
            prev = temp
        }
        
        print(path)
        return curr
    }
}

class HouseRobbingUsingDPMemoization {
    
    var memo: [Int] = Array(repeating: -1, count: 6)
    init() {
        let maxRobbing = maximumRobbingUsingMemoization(nums: [2, 1, 1, 3, 5, 4])
        print("maxRobbing HouseRobbingUsingDPMemoization *** \(maxRobbing)")
    }
    
    //House robbing using memoization
    func maximumRobbingUsingMemoization(nums: [Int]) -> Int {
        if (nums.count == 1) {
            return nums[0]
        }
        return memoizationHelper(nums: nums, index: 0)
    }
    
    private func memoizationHelper(nums: [Int], index: Int) -> Int {
        //base
        if (index >= nums.count) {
            return 0
        }
        //logic
        //don't choose
        if (memo[index] != -1) {
            return memo[index]
        }
        let case1 = memoizationHelper(nums: nums, index: index + 1)
        
        //choose
        let case2 = nums[index] + memoizationHelper(nums: nums, index: index + 2)
        
        memo[index] = max(case1, case2)
        return max(case1, case2)
    }
    
}
