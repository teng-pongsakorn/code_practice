package easy;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] < target) {
                lo = mid + 1;
            } else if (letters[mid] > target) {
                hi = mid - 1;
            } else {
                if (mid+1 < letters.length && letters[mid+1] != letters[mid]) {
                    return letters[(mid + 1) % letters.length];
                }
                lo = mid + 1;
            }
        }
        return letters[lo % letters.length];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget sol = new FindSmallestLetterGreaterThanTarget();

        System.out.println(sol.nextGreatestLetter("cfj".toCharArray(), 'a'));   // 'c'
        System.out.println(sol.nextGreatestLetter("cfj".toCharArray(), 'c'));   // 'f'
        System.out.println(sol.nextGreatestLetter("cfj".toCharArray(), 'd'));   // 'f'
        System.out.println(sol.nextGreatestLetter("cfj".toCharArray(), 'g'));   // 'j'
        System.out.println(sol.nextGreatestLetter("cfj".toCharArray(), 'j'));   // 'c'
        System.out.println(sol.nextGreatestLetter("ab".toCharArray(), 'z'));    // 'a'
    }
}
