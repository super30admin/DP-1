package com.company;

public class HouseRobber {
        public int rob(int[] nums) {

            if (nums.length == 1) return nums[0];

            int n = nums.length;

            int[] memo = new int[n];

            memo[n-1] = nums[n-1];

            memo[n-2] = nums[n-2];
            int max = Math.max(memo[n-2], memo[n-1]);
            for (int i = n-3; i >=0 ; i--){
                memo[i] = Math.max(nums[i] + memo[i+2], i < n-3 ? nums[i] + memo[i+3] : 0);
                max = Math.max(max, memo[i]);
            }
            return max;


        }
}
