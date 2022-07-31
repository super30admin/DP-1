// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : I don't have premium, need to buy
// Any problem you faced while coding this : no
class Problem2 {
    public static void main(String args[]) {
        int arr[] ={6,9,8,1,1,5};
        int previous = arr[0];
        int current = Math.max(arr[0],arr[1]);
        if (arr.length <= 2) {
            System.out.println(current);
            System.exit(0);
        }
        for(int i = 2; i < arr.length; i++) {
            int temp = current;
            current = Math.max(current, previous + arr[i]);
            previous = temp;
        }
        System.out.println(current);
        System.out.println(greedy(arr,0,0));
        System.out.println(optimization(arr));
    }
    public static int greedy(int[] arr,int index, int amount) {
        // Time complexity: O(2^n)
        // base
        if(index >= arr.length) return amount;

        // logic
        // not choose
        int case1 = greedy(arr,index + 1, amount);
        // chose
        int case2 = greedy(arr,index+2, amount + arr[index]);

        return Math.max(case1, case2);

    
    }
    public static int optimization(int[] arr) {
        // Space Complexity: O(n)
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++)
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);

        return dp[arr.length-1];
    }
}