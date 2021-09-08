package easy;

public class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(hexChars[num & 15]);
            num >>>= 4;
        } while (num > 0);
        return sb.reverse().toString();
    }
    public String toHex_v1(int num) {
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(hexChars[num & 0x0000000f]);
        if (num < 0) {
            num >>>= 4;
        } else {
            num >>= 4;
        }
        while (num > 0) {
            sb.append(hexChars[num & 0x0000000f]);
            num >>= 4;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertNumberToHexadecimal solve = new ConvertNumberToHexadecimal();
//        solve.toHex(-1);
        System.out.println(solve.toHex(26).equals("1a"));
        System.out.println(solve.toHex(-1));
//        System.out.println(Integer.toBinaryString(4 >> -1));
//        System.out.println(-1&0x0000000f);
//        System.out.println(-1&0x000000f0);
//        System.out.println(-1&0x000000f0 >> 4);
//        byte x = 0xf;
//        System.out.println(Integer.toBinaryString(-1>>>28));
//        System.out.println(-1>>>28);
//        System.out.println((-1>>>28) & 0x0000000f);
//        System.out.println(Integer.toBinaryString(-1>>>32));
//        System.out.println(Integer.toBinaryString(-1>>>28));
//        System.out.println((-1>>>28)>>>4);
    }
}
