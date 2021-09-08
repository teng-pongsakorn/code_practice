package easy;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

import java.util.ArrayList;
import java.util.List;

//public class Solution extends VersionControl {
//    public int firstBadVersion(int n) {
//
//    }
//}
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int hi = n-1;
        int lo = 0;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (!isBadVersion(mid)) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return hi+1;
    }

    boolean isBadVersion(int version) {
        return false;
    }

    public static void main(String[] args) {
        List<Boolean> list = new ArrayList<>();
        for (int i=0; i<3; i++) {
            list.add(false);
        }
        for (int i=0; i<2; i++) {
            list.add(true);
        }
        System.out.println(list);

        // expect first = 11 (index 10)
        int hi = list.size();
        int lo = 1;
        while (lo < hi) {
            System.out.println("lo:" + lo + " hi:" + hi);
            int mid = lo + (hi-lo)/2 - 1;
            if (!list.get(mid)) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        System.out.println("lo:" + lo + " hi:" + hi);
        System.out.println("result = " + (hi+1));
    }
}
