/**
 * TC: O(n)
 * SC: O(1)
 */
public class HouseRobber {

        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int choose = nums[0], notToChoose = 0;

            for(int i = 1; i < nums.length; i++) {
                int temp = Math.max(choose, notToChoose);;
                choose = notToChoose + nums[i];
                notToChoose = temp;
            }

            return Math.max(choose, notToChoose);
        }
}
