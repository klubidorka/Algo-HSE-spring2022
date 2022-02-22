import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RabinKarp {
    private static final long p = 29;
    private static final long M = 1_000_000_000 + 7;

    private static long hash(String s) {
        long ans = 0;
        for (char ch : s.toCharArray()) {
            ans = (ans * p + ch - 'a' + 1) % M;
        }
        return ans;
    }

    private static List<Integer> rabinKarp(String text, String pattern) {
        List<Integer> ans = new LinkedList<>();
        long textHash = hash(text.substring(0, pattern.length()));
        long patternHash = hash(pattern);
        long power = 1;
        for (int i = 0; i < pattern.length(); i++) {
            power = (power * p) % M;
        }
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (textHash == patternHash) {
                ans.add(i);
            }
            if (i != text.length() - pattern.length()) {
                textHash = (p * textHash + (text.charAt(i + pattern.length()) - 'a' + 1) + M) % M;
                textHash = (textHash - (power * (text.charAt(i) - 'a' + 1)) % M + M) % M;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        for (int pos : rabinKarp(text, pattern)) {
            System.out.print(pos + " ");
        }
    }
}

