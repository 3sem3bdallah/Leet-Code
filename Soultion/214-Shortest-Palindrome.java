import java.util.Scanner;

public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String revS = new StringBuilder(s).reverse().toString();
        String combined = s + # + revS;

        int[] lps = new int[combined.length()];
        int j = 0;

        for (int i = 1; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
                lps[i] = j;
            } else {
                lps[i] = 0;
            }
        }

        int longestPalinPrefixLength = lps[lps.length - 1];
        String toPrepend = revS.substring(0, s.length() - longestPalinPrefixLength);

        return toPrepend + s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        String input = scanner.nextLine();

        Solution solution = new Solution();
        String result = solution.shortestPalindrome(input);
        System.out.println(result);

        scanner.close();
    }
}
