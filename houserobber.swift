// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

       func rob(_ nums: [Int]) -> Int {
       
        var maxMoneyArray = Array(repeating: 0, count: nums.count + 1)
        maxMoneyArray.insert(nums[0], at: 1)
        if nums.count < 2 {
            return  maxMoneyArray[nums.count]
        }
        for i in 1...nums.count - 1 {
             var maxMoney = max(maxMoneyArray[i], maxMoneyArray[i-1]+nums[i])
             maxMoneyArray.insert(maxMoney, at: i+1)  
        } 
        return maxMoneyArray[nums.count]
    }