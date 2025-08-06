// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// line 11 
class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        if(nums.size == 1) return nums[0]
        val dp = IntArray(nums.size){0}
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        var max = dp[1]
        for(i in 2 until nums.size){
            val curr = nums[i]
            dp[i] = max(curr + dp[i-2], dp[i-1])
            max = max(max, dp[i])
        }
        return max
    }
}