package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Решение задачи
 * https://informatics.msk.ru/mod/statements/view.php?id=42416&chapterid=3313#1
 */
public class PrefixSumSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> ints = new ArrayList<>(size);
        int cnt = 0;
        ints.add(cnt);
        for (String str : br.readLine().split(" ")) {
            cnt += Objects.equals(str, "0") ? 1 : 0;
            ints.add(cnt);
        }
        int queriesSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < queriesSize; i++) {
            String[] query = br.readLine().split(" ");
            System.out.printf("%d ", ints.get(Integer.parseInt(query[1])) - ints.get(Integer.parseInt(query[0]) - 1));
        }
    }
}
