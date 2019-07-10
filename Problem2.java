// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : No, passed 39 cases. I didn't took account of values which which can be more than 2 distance and still can be more in outcome. Ex: [2,1,1,2]
// Any problem you faced while coding this :
class Solution {
    public int rob(int[] nums) {
        int sumEven = 0, sumOdd = 0;
        for(int i = 0; i< nums.length; i += 2){
            sumEven += nums[i];
        }
        for(int i = 1; i< nums.length; i += 2){
            sumOdd += nums[i];
        }
        
        return Math.max(sumEven, sumOdd);
        
    }
}