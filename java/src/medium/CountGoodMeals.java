package medium;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    int[] twoPowers = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152};
    int mod = 1000000007;

    public int countPairs(int[] deliciousness) {
        int count = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num: deliciousness) {
            for (int power: twoPowers) {
                if (numCount.containsKey(power - num)) {
                    count = (count + numCount.get(power - num)) % mod;
                }
            }
            numCount.put(num, numCount.getOrDefault(num, 0)+1);
        }
        return count;
    }

    public int countPairs_naive(int[] deliciousness) {
        int count = 0;
        for (int i=0; i<deliciousness.length-1; i++) {
            for (int j=i+1; j<deliciousness.length; j++) {
                if ((deliciousness[j]+deliciousness[i]!=0) && isPowerOfTwo(deliciousness[i] + deliciousness[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPowerOfTwo(int num) {
        return (num & (num-1)) == 0;
    }

    public static void main(String[] args) {
        CountGoodMeals sol = new CountGoodMeals();
        int[] deliciousness;

        // 4
        deliciousness = new int[] {1,3,5,7,9};
        System.out.println(sol.countPairs(deliciousness));

        // 15
        deliciousness = new int[] {1,1,1,3,3,3,7};
        System.out.println(sol.countPairs(deliciousness));

        // 528
        deliciousness = new int[] {64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64};
        System.out.println(sol.countPairs(deliciousness));

        // 53
        deliciousness = new int[] {2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
        System.out.println(sol.countPairs_naive(deliciousness));

//        int n = 100000;
//        System.out.println(n * (n-1)/ 2);
//        System.out.println(n / 2 * (n-1));
//        List<Integer> list = new ArrayList<>();
//        for (int i=0; i<=21; i++) {
//            list.add((int) Math.pow(2.0, i));
//        }
//        System.out.println(list);
    }
}
