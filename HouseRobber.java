// Time Complexity :  Exponential =~  2^n
// Space Complexity : O(n) n is the length of nums
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
/*
 * We want to minimize and thus we tried greedy. We then do exahuastive search(recurssion) using DO NOT CHOOSE CHOOSE method.
 * Choose: means we robbed the house, maxRob amount gets updated and index = index + 2 (cannot rob adjacent houses)
 * Not choose: maxRob amount will be the same and increment the index.
 * Base case: If index is equal OR GREATER to length return maxRob amount. We check greate as it can go out of bounds.
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        return recurse(nums, 0, 0);
    }

    private int recurse(int[] nums, int index, int maxRob) {
        //Base case:
        if(index >= nums.length) {
            return maxRob;
        }
        //Logic: DO NOT CHOOSE CHOOSE
        int case1 = recurse(nums, index + 1, maxRob);
        int case2 = recurse(nums, index + 2, maxRob + nums[index]);
        return Math.max(case1, case2);
    }
}

// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  


// Your code here along with comments explaining your approach
/*
 * DP where we consider dimension = length of the deciding factor. We creat dp[][2] with nums.length + 1 = row and 2 constant = coloumn(choose, not choose)
 * Fill 1st ROW with 0. Fill dp matrix: (As we added extra row we will get amount at 1 lesser index in array)
 * Not Choose: Max between previous index. Choose:  current nums value + Not Choose value of previous.
 */

class HouseRobberDP {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i-1] + dp[i-1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  


// Your code here along with comments explaining your approach
/*
 * DP where we consider dimension = length of the deciding factor. We creat dp[][2] with nums.length + 1 = row and 2 constant = coloumn(choose, not choose)
 * Fill 1st ROW with 0 and nums[0]. Fill dp matrix: Not Choose: Max between previous index. Choose:  current nums value + Not Choose value of previous.
 */

class HouseRobberDP2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  


// Your code here along with comments explaining your approach
/*
 * As in above approach we only look at the previous 2 rows, instead of dp[][2] we couls just maintain skip and take variables.
 * Iterate over the loop, and store skip in temp. Update skip to max between previous skip and take, and update take to nums value + temp
 * Return max of skip and take.
 */

class HouseRobberOptimized {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = nums[i] + temp;
        }
        return Math.max(skip, take);
    }
}
