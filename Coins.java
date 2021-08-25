import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Coins
 */
public class Coins {

    HashMap<Integer, Integer> hs = new HashMap<>();
    int countFinal = 0;

    public int coinChange(int[] coins, int amount) {

        int[] result = new int[coins.length];
        int count = -1;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount % coins[i] == 0)
                result[++count] = amount / coins[i];
            else {
                int reminder = (amount % coins[i]);
                countFinal = 0;

                if (coins.length == 1) {
                    result[++count] = (amount % coins[i] == 0) ? (amount / coins[i]) : 1000000;
                } else {
                    if (amount < coins[i]) {
                        result[++count] = 1000000;
                    } else {
                        int temp = checkReminder(reminder, i, coins);

                        if (temp > 0) {
                            result[++count] = (amount / coins[i]) + temp;
                        } else {
                            result[++count] = 1000000;
                        }
                    }
                }

            }
        }
        System.out.println(Arrays.toString(result));
        Arrays.sort(result);

        return result[0] == 1000000 ? -1 : result[0];
    }

    public int checkReminder(int leftOver, int index, int[] arr) {
        // if (hs.containsKey(leftOver))
        // return hs.get(leftOver);

        if (leftOver % arr[index - 1] == 0) {
            // hs.put(leftOver, arr[i]);
            // countFinal = countFinal; // + leftOver / arr[index - 1];
            if (countFinal == 0) {
                countFinal = leftOver / arr[index - 1];
            }
            return countFinal;
        } else {
            countFinal = countFinal + (leftOver % arr[index - 1]);
            return checkReminder(leftOver % arr[index - 1], index - 1, arr);
        }
    }

    public static void main(String[] args) {
        Coins cs = new Coins();
        // int[] arr = { 1, 2, 5 };
        // int[] arr = { 1, 2, 5, 10 };
        // int[] arr = { 1, 2 };
        int[] arr = { 1, 3, 5 };
        System.out.println(cs.coinChange(arr, 9));
    }
}