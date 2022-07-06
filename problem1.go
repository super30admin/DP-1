
// Time Complexity : o(m*n)---> O(N)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

func coinChange(coins []int, amount int) int {
    
    if len(coins) == 0 {
        return -1
    }
    
    m:= len(coins)
    n := amount
    
    dp := make([][]int,m+1)
    for i,_:= range(dp){
        dp[i] = make([]int,n+1)
    }
    
    for j:=0;j<n+1;j++{
        dp[0][j] = amount+1
    }
   
    for i:=1;i<m+1;i++{
        for j:=1;j<n+1;j++{
            if j < coins[i-1]{
                dp[i][j] = dp[i-1][j]
            }else{
                dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
            }
        }
    }
    
    if dp[m][n] == amount+1{
        return -1
    }
    
    return dp[m][n]
    
}

func min(a,b int) int{
    
    if a < b{
        return a
    }
    
    return b
}
