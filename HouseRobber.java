package S30_Codes.DP_1;

// Time Complexity : O(n) // n = length of nums
// space Complexity : O(n)


import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return findMaxRobbery(nums, 0, cache);
    }

    private int findMaxRobbery(int[] arr, int idx, int cache[]){
        if(idx >= arr.length)
            return 0;


        if(cache[idx] == -1){
            int select = arr[idx] + findMaxRobbery(arr, idx+2, cache);

            int notSelect = findMaxRobbery(arr, idx+1, cache);

            cache[idx] = (select > notSelect) ? select : notSelect;
        }

        return cache[idx];
    }
}