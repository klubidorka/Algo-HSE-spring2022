package sem3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class HeapTest {
    @Test
    void sortTest() {
        final int SIZE = 100_000;
        List<Integer> longs = new Random().ints(SIZE).boxed().collect(Collectors.toList());
        BinaryMinimumHeap heap = new BinaryMinimumHeap(longs);
        List<Integer> sortedLongs = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            sortedLongs.add(heap.extractMinElement());
        }
        for (int i = 0; i < SIZE - 1; i++) {
            assert (sortedLongs.get(i) <= sortedLongs.get(i + 1));
        }
    }
}
