package easy;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int diff = 0;  // Alice - Bob
        int totalAlice = 0;
//        Set<Integer> setAlice = new HashSet<>();
//        int totalBob = 0;
        Set<Integer> setBob = new HashSet<>();
        for (int size: aliceSizes) {
            totalAlice += size;
//            setAlice.add(size);
            diff += size;
        }
        for (int size: bobSizes) {
//            totalBob += size;
            setBob.add(size);
            diff -= size;
        }
        diff /= 2;
        int [] result = new int[]{};
        for (int alice: aliceSizes) {
            if (setBob.contains(alice - diff)) {
                result = new int[] {alice, alice - diff};
                break;
            }
        }
//        if (totalAlice > totalBob) {
//            int diff = (totalAlice - totalBob) / 2;
//            for (int alice: setAlice) {
//                if (setBob.contains(alice - diff)) {
//                    result = new int[]{alice, alice-diff};
//                    break;
//                }
//            }
//        } else {
//            int diff = (totalBob - totalAlice) / 2;
//            for (int bob: setBob) {
//                if (setAlice.contains(bob - diff)) {
//                    result = new int[] {bob - diff, bob};
//                    break;
//                }
//            }
//        }
        return result;
    }
}
