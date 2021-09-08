package easy;

import java.util.Stack;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) != '-') {
                if (sb.length() % (k+1) == k) {
                    sb.append('-');
                }
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        return sb.reverse().toString();
    }
    public String licenseKeyFormatting_v1(String s, int k) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '-') continue;
            sb.append(s.charAt(i));
            if (sb.length() == k) {
                stack.push(sb.reverse().toString().toUpperCase());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            stack.push(sb.reverse().toString().toUpperCase());
            sb.setLength(0);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(stack.isEmpty() ? "" : "-");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LicenseKeyFormatting solution = new LicenseKeyFormatting();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));  // 5F3Z-2E9W
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2)); // 2-5G-3J
        System.out.println(solution.licenseKeyFormatting("--a-a-a-a--", 2)); // AA-AA
        System.out.println(solution.licenseKeyFormatting("--------EyRfCyHxyUJzhygiazYpjuDFdHvrnDwoQKQEsccLDiwhpmjueADIzqIvExbDDFnEGovAxYeszbzuTekRuWUPXRPbVKJuDQzIzzTj"
                ,16));
    }
}
