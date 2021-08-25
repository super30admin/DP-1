public class Rob {

    public int robFun(int[] nums) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                even += nums[i];
            else
                odd += nums[i];
        }
        if (even > odd)
            return even;
        else
            return odd;
    }

    public static void main(String[] args) {
        Rob r = new Rob();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(r.robFun(nums));
    }
}
