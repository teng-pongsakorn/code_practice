package easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gIdx = 0, sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (g[gIdx] <= s[sIdx]) {
                count++;
                gIdx++;
            }
            sIdx++;
        }
        return count;
    }

    public static void main(String[] args) {
        AssignCookies solve = new AssignCookies();
        int[] children, cookies;

        children = new int[]{1,2,3};
        cookies = new int[]{1,1};
        System.out.println(solve.findContentChildren(children, cookies));  // 1

        cookies = new int[]{2,2,1};
        System.out.println(solve.findContentChildren(children, cookies));  // 2

        cookies = new int[]{3,2,1};
        System.out.println(solve.findContentChildren(children, cookies));  // 3

    }
}
