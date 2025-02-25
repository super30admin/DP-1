public class house_robber {
    public int rob(int[] nums) {
        if(nums ==null || nums.length ==0){
            return 0;
        }
        int choose = nums[0];
        int notchoose = 0;
        for(int i=1; i< nums.length; i++){
            int temp = notchoose;
            notchoose = Math.max(choose, notchoose);
            choose = temp + nums[i];
        }
        return Math.max(choose, notchoose);
    }
}
