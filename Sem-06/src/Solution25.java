import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (true) {
            String line = sc.nextLine();
            switch (line.charAt(0)) {
                case ('+'):
                    set.add(line.substring(2));
                    break;
                case ('-'):
                    set.remove(line.substring(2));
                    break;
                case ('?'):
                    if (set.contains(line.substring(2))) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
                default:
                    return;
            }
        }
    }
}
