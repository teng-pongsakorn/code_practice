package easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    // floyd's cycle algorithm
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sumSquareDigits(slow);
            fast = sumSquareDigits(sumSquareDigits(fast));
            if (slow == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    private static int sumSquareDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += (tmp * tmp);
            n /= 10;
        }
        return sum;
    }

    // hashmap
    public static boolean isHappy_v1(int n) {
        Set<Integer> visited = new HashSet<>();

        while (true) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (visited.contains(sum)) {
                return false;
            }
            visited.add(sum);
            n = sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.isHappy(19));  // true
        System.out.println(HappyNumber.isHappy(2));  // false
    }
}
