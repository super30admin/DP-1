import java.util.*;

public class HouseRobber {
    /*
time : O(n)
space : O(n)
*/


        public int rob(int[] nums) {

            TreeSet<Integer> treeSet = new TreeSet<>();
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int dp[] = new int[nums.length];
            if (nums.length == 1) {
                return nums[0];
            } else {

                dp[0] = nums[0];
                dp[1] = Math.max(nums[1], dp[0]);

                for (int i = 2; i < nums.length; i++) {
                    //dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
                    int curr = dp[i - 1];
                    int next = nums[i] + dp[i - 2];

                    if (next > curr) {
                        treeSet.add(i);
                        treeSet.add(i-2);
                    } else {
                        treeSet.add(i-1);
                    }

                    dp[i] = Math.max(curr, next);
                }

            }

            for (int i : treeSet) {
                System.out.println(" i " + i);
            }

            return dp[nums.length - 1];

        }

}
