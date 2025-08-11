class Solution {
    
    public int robRecurse(int[] nums) {
        // TLE solution
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return recurse(nums, 0, 0);
    }

    private int recurse(int[] nums, int index, int amountRobbed) {
        if (index >= nums.length) {
            return amountRobbed;
        }

        int case1 = recurse(nums, index + 1, amountRobbed);
        int case2 = recurse(nums, index + 2, amountRobbed + nums[index]);
        return Math.max(case1, case2);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        
        if (n == 1) {
            return nums[0];
        }

        int robbed[] = new int[n];

        robbed[0] = nums[0];
        robbed[1] = Math.max(nums[0], nums[1]);

        /**
         * 0 1 2 3 4
         * 2,7,9,3,1
         * 
         * 2 7 
         * 
         */
        for (int i = 2; i < n; ++i) {
            robbed[i] = Math.max(robbed[i - 1], nums[i] + robbed[i - 2]);
        }

        return robbed[n - 1];

    }

    public int robSkipTake(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        
        int skip = 0;
        int take = nums[0];
        /**
          s t
        2 0 2
        7 2 7
        9 7 11
        3 11 10
        1 11 12

         */


        for (int i = 1; i < n; ++i) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }

        return Math.max(skip, take);

    }
}