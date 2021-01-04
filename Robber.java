//T.C O(n) SC O(n)
class Solution {
    public int rob(int[] nums) {
        // [1,2,3,1] -- running sum
        //[1,2,4,4]
        int[] result = new int[nums.length+2];
        result[0] = 0;
        result[1] = 0;
        for(int i = 2; i < nums.length+2; i++) {
            result[i] = Math.max(result[i-1], (result[i-2]+nums[i-2]));
        }
        return result[nums.length +1];
    }
}