// Time Complexity : (O)n*m
// Space Complexity : (O)n*m
// Did this code successfully run on Leetcode : timelimit exceeded


//Recursive solution
//Make two decision and get a number of coins needed to make the given amount
//choose a coin or not choose a coins 
//then compare the min of two result and return the minimum

class Solution {
    func coinChange(_ coins: [Int], _ amount: Int) -> Int {
        //edge
        if coins.count == 0 {
            return 0
        }
        return helper(coins,amount,0,0)
    }
    
    func helper(_ coins: [Int],_ amount: Int, _ index: Int,_ min: Int) -> Int {
        //base
        if amount == 0 {
            return min
        }
        
        if amount < 0 || index == coins.count {
            return -1
        }
        //logic
        //choose a coin
        let case1: Int = helper(coins, amount - coins[index], index, min+1)
        // don't choose a coin
        let case2: Int = helper(coins, amount, index+1, min)
        
        if case1 == -1 {
            return case2
        }
        if case2 == -1 {
            return case1
        }
        
        if case1 < case2 {
            return case1
        }
        
        return case2
    }
}