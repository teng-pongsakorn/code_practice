package medium;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {

//    1 <= coins.length <= 12
//    1 <= coins[i] <= 2^31 - 1
//    0 <= amount <= 10^4
//    public int coinChange(int[])
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        boolean isDone = false;
        while (!isDone) {
            isDone = true;
            int minVal = 0;
            for (int val=0; val <= amount; val++) {
                if (dp[val] > 0) {
                    for (int coin: coins) {
                        if (coin+val <= amount && dp[coin+val]==0) {
                            isDone = false;
                            dp[coin+val] = dp[val]+1;
                            if (dp[amount] != 0) {
                                return dp[amount]-1;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }


    public int coinChange_slow(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size > 0) {
                int x = queue.poll();
                for (int coin: coins) {
                    if (coin + x == amount) {
                        return count;
                    } else if (coin + x < amount) {
                        queue.add(coin+x);
                    }
                }
                size--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        int[] coins;
        int amount;

        coins = new int[] {1,2,5};
        amount = 11;
        System.out.println(sol.coinChange(coins, amount));

        coins = new int[] {2};
        amount = 3;
        System.out.println(sol.coinChange(coins, amount));

        coins = new int[] {1};
        amount = 0;
        System.out.println(sol.coinChange(coins, amount));

        coins = new int[] {1};
        amount = 1;
        System.out.println(sol.coinChange(coins, amount));

//        [186,419,83,408]
//        6249


        coins = new int[] {1};
        amount = 2;
        System.out.println(sol.coinChange(coins, amount));

        coins = new int[] {2,4,6,8,10};
        amount = 151;
        System.out.println(sol.coinChange(coins, amount));
    }
}
