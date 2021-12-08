/*
Time comlexity = O(n) where n is length of nums array
Space complexity: O(1)
Here we are firt taking 2 variable skip where we are not chossing current house and take where we are chossing current house
if we are not chossing current house that means value will be max of previously choosen or not choosen
and if we choose that means we need to add the value rob till now with that previous house skip as we can't choose adjacent houses.
*/
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int skip = 0, take = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }

        return Math.max(skip, take);
    }
}