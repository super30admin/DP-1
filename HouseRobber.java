//TC: O(n)
//SC: O(1)
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return -1;
        int skip = 0;
        int take = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}

/*
Other approach:
int evenSum = 0;
int oddSum = 0;
for(int i = 0; i < nums.length; i++){
    if(i %2 == 0) {
        evenSum = Math.max(oddSum, evenSum+nums[i]);
        } else{
        oddSum = Math.max(evenSum, oddSum+nums[i]);
        }
}
return Math.max(evenSUm, oddSum);*/
