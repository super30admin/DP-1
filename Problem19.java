//Time Complexity: O(n)
//Space Complexity: O(1)
//Did it run on leetcode: Yes
//Problems faced any?: No

public class Problem19 {
    public int rob(int[] nums) {
        int choose = 0;
        int Dchoose = 0;

        for(int x : nums){
            int temp = Dchoose;
            Dchoose = Math.max(choose, Dchoose);
            choose = x + temp;
        }

        return Math.max(choose, Dchoose);
    }
}
