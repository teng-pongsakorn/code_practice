package easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int num=left; num<=right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private boolean isSelfDividing(int num) {
        int remainder = num;
        while (remainder > 0) {
            int divider = remainder % 10;
            if (divider == 0 || num%divider != 0) return false;
            remainder /= 10;
        }
        return true;
    }
}
