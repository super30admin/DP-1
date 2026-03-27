// Time Complexity : O(n) since we will have to iterate over each house to see if we want to rob it or not
// Space Complexity : O(n) since we will store the max amount of money that can be robbed until that house
// Did this code successfully run on Leetcode :Yes
//Approach: if there is 1 house, you can only rob that house, if there are two, you can rob the one that has more money to offer
//if there are more than 2, then you will choose the max amount by selecting the max(amount at current + the max amount at i - 2, max amount at i - 1)
/**
 * Finds and Returns the max amount of money that can be robbed without alerting the police
 */
public class HouseRobber {

    /**
     *
     * @param nums the amount of money at each house on the street
     * @return     the max amount of money that can be robbed without alerting the police
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; //there's only one house on the street

        int two = nums[0];
        int one = Math.max(two, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = one;
            one = Math.max(nums[i] + two, one);
            two = temp;
        }

        return one;
    }

    public static void main(String[] args) {
        final HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[] {1, 8, 5, 3, 7, 2})); //return 15
        System.out.println(houseRobber.rob(new int[] {1})); //return 1
        System.out.println(houseRobber.rob(new int[] {1, 6})); //return 6
        System.out.println(houseRobber.rob(new int[] {1, 6, 7})); //return 8
        System.out.println(houseRobber.rob(new int[] {1, 6, 4})); //return 6
        System.out.println(houseRobber.rob(new int[] {2, 7, 9, 3, 1})); //return 12
    }
}
