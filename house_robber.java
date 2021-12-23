class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) return 0; // if we do no have anythhing in nums, return 0;
        int skip = 0, take = nums[0]; // we take 2 variables; skip which is equal to 0 initially and take which is initialized to nums[0] if we take the value.
        for (int i = 0; i < nums.length; i++) { // we go through each element in the array
            int tempSkip = skip
            skip = Math.max(skip, take); // if we skip the value, we take the max from i-1 considering both skip and take cases.
            take = tempSkip + nums[i]; //if we take that value, we add the previous skip value and add the current value to it. and store it in take. since the skip value is getting updated here; we take a variable called tempSkip.
        }
        return Math.max(skip, take); // in the end, we return the max value from skip and take.
    }
}
//Tc - O(n) and Sc - O(1)