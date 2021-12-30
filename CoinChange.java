// Time Complexity : O(N!) as we are trying to find all combinations.
// Space Complexity : O(N) auxillary space of hashset used to store already
//                  visited coins
// Did this code successfully run on Leetcode : no, failing few test cases
// Any problem you faced while coding this : yes, hard time figuring out an
//  optimal solution

/* Followed greedy approach where if I start from highest denomination and
finding the max that it can take and then figuring out for each smaller ones.
but failing edge cases. Also, this is not an optimal solution. */



class CoinChange
{
    public int coinChange(int[] coins, int amount) {

        Set<Integer> map = new HashSet<>();

        List<Integer> list = new ArrayList<>();

        int coinNum = 0;

        Arrays.sort(coins);

        list = helper(coins, amount, map, coinNum, list);

        if(amount == 0) return 0;

        if(list.isEmpty()) return -1;

        Collections.sort(list);

        return list.get(0);
    }


    public List<Integer> helper(int[] sample, int amount, Set<Integer> map,
                                int coins, List<Integer> list){

        int count = 0;
        boolean res;

        int[] ans = new int[2];

        if(amount == 0){
            ans[0] = 0;
            ans[1] = count;
        }

        int size = list.size();

        for(int i = sample.length - 1; i >= 0; i--)
        {
            count = amount / sample[i];

            List<Integer> temp = new ArrayList<>();

            while(count >= 0)
            {
                int newAmount = amount - sample[i] * count;

                if(newAmount == 0){
                    ans[1] = coins + count;
                    ans[0] = 0;
                    list.add(ans[1]);
                }

                if(map.contains(newAmount)){
                    break;
                }

                size = list.size();

                temp = this.helper(Arrays.copyOfRange(sample, 0, i ),
                                newAmount, map, coins + count, list);

                if(temp.size() == size){
                    map.add(newAmount);
                }
                count -= 1;
            }
        }


        Collections.sort(list);
        ans[0] =   amount;
        ans[1] = list.size() > 0 ? list.get(0) : 0 ;
        return list;

    }
}
