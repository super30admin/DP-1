// Ran on leetcode : Yes
/*
Do choose and no choose, get the maximum of the choose to rob in which case add the value of the current house to the previously calculate value and no choose which is the previous value. Return the last element of the array used to store of the result.
*/
// TC: O(n) SC: O(n)
class Solution2 {
    public int rob(int[] nums) {
        int numsLen = nums.length;
        int result[] = new int[numsLen];
        result[0] = nums[0];
        if(numsLen == 1) return result[0];
        result[1] = Math.max(result[0], nums[1]);
        for(int i = 2; i < numsLen; i++){
            //find max between no choose and choose case
            result[i] =  Math.max(result[i - 1], nums[i] + result[i - 2]);
        }

        return result[numsLen - 1];
    }

    
}