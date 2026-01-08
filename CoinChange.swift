//
//  DynamicProgramming.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/4/26.
//

/*
 It is optimization of repeated subproblems
 optimizatoin approach - top down DP - memoizaton
 bottom up Dp - tabulation
 
 [1, 2, 5] -> make amount - 11 using coins 1, 2, 5. Use minimum no of coins.
 take maximum denomination of coins e.g. 5 - it's greedy algorithm
 What is greedy algorithm ->
 At everydecision node, whatever is the best option, you take that. This is called greedy approach. We are taking Local optimal decision with the idea that it will lead to global optimal decision
 
 In all problems - first use greedy, if it works, use it. It's linear.
 If it doesn't work - find out the possibilities where greedy might not work.
 e.g. [1, 3, 4, 5] - make sum 7. using greedy we first take 5 (1 coin), then remaining 2 (a coin of 1 denmication) - remaining 1 (again a coin of 1 denomination) -> total no of coins = 3
 But the optimal solution is [4, 3] - 2 coins
 
 [2, 5] -> sum - 6 take 5, no coin for 1. so greedy approach can't be used. Should have used 2 denomination coins.
 
 If greedy doesn't work - go to exhaustive approach ->
 ******Exhaustive approach
 1 choice is to take a coin. another choice is to not take the coin.
 ***** choose or not choose and find th ebrute force solution.
 */

class CoinChange {
    //recursion.
    
    init() {
        let minimumNoOfCoins = coinChange(coins: [1,2,5], amount: 11)
        print("minimumNoOfCoins ** \(minimumNoOfCoins)")
    }
    
    //Time complexity = 2n (exponential complexity). n - no of coins. Means I have  nodes in tree
    //my time complexity depends on only 1 variable that is no of coins.
    //time complexity depends no the amount. I can have 4 coins but amount as 0. So, time complexity will be less.
    /*
     depth of the tree is m + n. It's not 11. It's actually 14.
     n - no of coins. m = sum
     depth is (m - 1) -> post this, don't choose any coin. then +n for number of coins because we say no to all coins.
      m - 1 + n - maxiumum depth of the tree == m+n
     both input variables are in picture. 2m+n is the time complexity of the problem in worst case. It's exponential. That's wy time limit exceeded. (exhaustive solution)
     Now optimize this colution.
     find out if any repeated subproblems are present, then make table.
     In Tabulation - choose
     1-D array - only 1 input variable
     2-D array (matrix) - 2 input variblaes that's why (can be otimized to array if possible)
     */
    func coinChange(coins: [Int], amount: Int) -> Int{
        let result = helper(coins: coins, amount: amount, index: 0)
        //we couldn't find nay valid path. [2, 5] - amount - 3 can't make 3 with any coin
        if (result >= Int.max - 10) {
            return -1
        }
        return result
    }
    
    //word based recursion, int based recursion - which type of recursion
    //index - index of the coin
    //amount - remianing amount
    //coins array
    private func helper(coins: [Int], amount: Int, index: Int) -> Int {
        //base case
        //when we are not able to make the amount 0
        if (index == coins.count || amount < 0) {
            //so that while comparing, you will have a final value of min of 2 cases.
            return Int.max - 10 // -10 to avoid integer overflow. Because 1 will be added at the bottom
        }
        //if amount == 0, then we will not be using any coin. the coins required = 0
        if (amount == 0) {
            return 0
        }
        
        //logic
        //don't choose. pass the coins array, pass the same amount since we have not choosen any coin. index will be incremented by 1 if we are not choosing a coin
        let case1 = helper(coins: coins, amount: amount, index: index + 1)
        
        //choose
//        index - I can reuse the coin bz we have infinite supply of coin
        //amount - since we have chosen the coin, amount will be (amount - chosen coin value)
        let case2 = 1 + helper(coins: coins, amount: amount - coins[index], index: index)
        let result = min(case1, case2)
        
        return result
    }
}

class CoinChangeWithMemoizationTopDownApproach {
    
    var memo: [[Int]] = [[Int]]()
    init() {
        let noOfCOins = coinChangeWithMemoization(coins: [1,2,5], amount: 11)
        print("coin change with memoization *** \(noOfCOins)")
    }
    
    
    func coinChangeWithMemoization(coins: [Int], amount: Int) -> Int {
//        for i in 0..<coins.count {
//            for j in 0...amount {
//                memo[i][j] = -1
//            }
//        }
        memo = Array(repeating: Array(repeating: -1, count: amount + 1), count: coins.count)
        
        let result = helper(coins: coins, amount: amount, index: 0)
        if (result >= Int.max - 3) {
            return -1
        }
        return result
    }
    
    private func helper(coins: [Int], amount: Int, index: Int) -> Int {
        //base case
        //when we are not able to make the amount 0
        //if amount == 0, then we will not be using any coin. the coins required = 0
        if (amount == 0) {
            return 0
        }
        if (index == coins.count || amount < 0) {
            //so that while comparing, you will have a final value of min of 2 cases.
            return Int.max - 3 // -10 to avoid integer overflow. Because 1 will be added at the bottom
        }
        
        if (memo[index][amount] != -1) {
            return memo[index][amount]
        }
        
        //logic
        //don't choose. pass the coins array, pass the same amount since we have not choosen any coin. index will be incremented by 1 if we are not choosing a coin
        let case1 = helper(coins: coins, amount: amount, index: index + 1)
        
        //choose
//        index - I can reuse the coin bz we have infinite supply of coin
        //amount - since we have chosen the coin, amount will be (amount - chosen coin value)
        let case2 = 1 + helper(coins: coins, amount: amount - coins[index], index: index)
        let result = min(case1, case2)
        memo[index][amount] = result
        return result
    }
}

/*
 recursion - top down
 tabulation - bottom up approach
 time complexity - m * n , m = amount, n = no of coins
 space complexity = m * n
 tale 1 dummy row in coins array - it will matter a lot.
 */

class CoinChangeUsingTabulationBottomUpApproach {
    
    init() {
       let noOfCoins =  coinChange(coins: [1,2,5], amount: 11)
        print("no of coins CoinChangeUsingTabulationBottomUpApproach *** \(noOfCoins)")
        
        let noOfCoins2 =  coinChangeWithOneDArray(coins: [1,2,5], amount: 11)
        print("number of coins *** with 1 D array", noOfCoins2)
        
    }
    
    func coinChange(coins: [Int], amount: Int) -> Int {
        let n = amount
        let m = coins.count
        var dp: [[Int]] = Array(repeating: Array(repeating: 0, count: n + 1), count: m + 1) //m+1 - rows, n+1 - columns
        dp[0][0] = 0
        //top row
        for j in 1...n {
            //filling first row after column 0 with infinity. Because with 0 coins, we can't create any sum.
            dp[0][j] = Int.max - 10
        }

        for i in 1...m {
            for j in 1...n {
                //check if my coin denomination is greater than the current amount.
                //Since we took a dummy row, take 1 step back in actual array
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i-1][j]
                } else {
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i - 1]])
                }
            }
        }
        let result = dp[m][n]
        if (result >= Int.max - 10) {
            return -1
        }
        return result
    }
    
    /*
     We are deriving values from the previous row or the same row. We are not using the the rows we are not using. So, we can save on space. We can have 1 DP array and keep overwritting the rows.
     Space complexity - O(n)
     */
    
    func coinChangeWithOneDArray(coins: [Int], amount: Int) -> Int {
        let n = amount
        let m = coins.count
        var dp: [Int] = Array(repeating: 0, count: n + 1) //n - amount
        dp[0] = 0
        //top row
        for j in 1...n {
            //filling first row after column 0 with infinity. Because with 0 coins, we can't create any sum.
            dp[j] = Int.max - 10
        }

        for i in 1...m {
            for j in 1...n {
                //check if my coin denomination is greater than the current amount.
                //Since we took a dummy row, take 1 step back in actual array
                if (j < coins[i - 1]) {
                    dp[j] = dp[j]
                } else {
                    dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]])
                }
            }
        }
        let result = dp[n]
        if (result >= Int.max - 10) {
            return -1
        }
        return result
    }
}

