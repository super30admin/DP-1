import java.util.Arrays;
/* soultion 1 basic recursion */
//Time Complexity O(2 ^N) two choices for every house
//Space Complexity O(1) space for recursion on the stack but not counting
//Leetcode works for base case but timeouts out for other/worst case scenarios.

public class HouseRobberLeetcode198 {
    public int rob(int[] nums) {
        if (nums == null) return 0;

        return robMoney(nums, 0);
    }

    public int robMoney(int[] nums, int house) {
        int gold = 0;
        // we only need one base condition to stop recursion for out of bounds
        if (house >= nums.length) {
            return nums[house];
        }
        //two options everytime either pick the current house and then leave the next or
        //leave the current and pick the next house.
        gold = Math.max((nums[house] + robMoney(nums ,house + 2)), robMoney(nums,house + 1));
        return gold;
    }

/* Solution 2 with memoization */
//Time Complexity O(N). Visiting every house once.
//Space Complexity O(N) exra array for memoization or storing the result for previous seen houses
//Leetcode yes
    int []memoization;
    public int rob1(int[] nums) {
        if (nums == null) return 0;

        memoization = new int[nums.length];
        Arrays.fill(memoization, -1);

        return robMoney(nums, 0);

    }

    public int robMoney1(int[] nums, int house) {
        int gold = 0;
        //don't need this will automatically happen, we only need one base condition to stop recursion for out of bounds
       /* if (house == (nums.length -1)) {
            return nums[house];
        }*/
        if (house >= nums.length) {
            return 0;
        }
        //this with memoization or dp to prevent same case recusrion again, store result and if we see
        //same case recursion again then return value from stored array instead of calculating it again
        if (memoization[house] != -1) {
            return memoization[house];
        }
        //two options everytime either pick the current house and then leave the next or
        //leave the current and pick the next house.
        gold = Math.max((nums[house] + robMoney1(nums, house + 2)), robMoney1(nums, house + 1));
        memoization[house] = gold;
        return gold;
    }
}
