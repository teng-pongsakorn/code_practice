package easy;

public class BackspaceStringCompare {
    private final char BACKSPACE = '#';
    public boolean backspaceCompare(String s, String t) {
        // compare from back of each string
        int tIdx = t.length() - 1;
        int sIdx = s.length() - 1;
        int backspaceCount = 0;
        while (tIdx >= 0 || sIdx >= 0) {
            // reset counter
            backspaceCount = 0;
            while (tIdx >= 0 && (t.charAt(tIdx)==BACKSPACE || backspaceCount > 0)) {
                if (t.charAt(tIdx) == BACKSPACE) {
                    backspaceCount++;
                } else {
                    backspaceCount--;
                }
                tIdx--;
            }
            // reset counter
            backspaceCount = 0;
            while (sIdx >= 0 && (s.charAt(sIdx)==BACKSPACE || backspaceCount > 0)) {
                if (s.charAt(sIdx) == BACKSPACE) {
                    backspaceCount++;
                } else {
                    backspaceCount--;
                }
                sIdx--;
            }

            if (tIdx >= 0 && sIdx >= 0 && s.charAt(sIdx) != t.charAt(tIdx)) {
                return false;
            }
            if ((tIdx < 0 && sIdx >= 0) || (tIdx >= 0 && sIdx < 0)) {
                return false;
            }
            sIdx--;
            tIdx--;
        }
        return true;
    }

    public boolean backspaceCompare_nSpace(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private String processString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == BACKSPACE) {
                sb.setLength(sb.length()-1 >= 0 ? sb.length()-1 : 0);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare sol = new BackspaceStringCompare();
        System.out.println(sol.backspaceCompare("ab#c","ad#c") == true);
        System.out.println(sol.backspaceCompare("ab##","c#d#") == true);
        System.out.println(sol.backspaceCompare("a##c","#a#c") == true);
        System.out.println(sol.backspaceCompare("a#c","b") == false);
        System.out.println(sol.backspaceCompare("nzp#o#g", "b#nzp#o#g") == true);
        System.out.println(sol.backspaceCompare("bxj##tw", "bxj###tw") == false);



    }
}
