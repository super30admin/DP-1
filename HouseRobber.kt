// Chose to solve this problem using DP. This is bottom up approach where we keep track of two variables prev and curr. We iterate through the array and each step we update the curr to be max of curr and nums value plus prev. 
// Time complexity is O(n) and space complexity is O(1)

class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size < 2) return nums[0]
        var prev = nums[0]
        var curr = Math.max(nums[0], nums[1])
        for (i in 2..nums.size - 1) {
            var temp = curr
            curr = Math.max(curr, nums[i]+ prev)
            prev = temp
        }

        return curr
    }
}