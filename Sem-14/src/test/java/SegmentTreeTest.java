import abstract_segment_tree.STMinimum;
import abstract_segment_tree.STSum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SegmentTreeTest {

    @Test
    void smallSegmentTreeTest() {
        List<Integer> ints = List.of(1, 3, -1, 4, 8);
        STMinimum tree = new STMinimum(ints);
        System.out.println(tree);
        Assertions.assertThat(tree.resultOnSegment(0, 1)).isEqualTo(1);
        Assertions.assertThat(tree.resultOnSegment(1, 2)).isEqualTo(3);
        Assertions.assertThat(tree.resultOnSegment(2, 3)).isEqualTo(-1);
        Assertions.assertThat(tree.resultOnSegment(3, 4)).isEqualTo(4);
        Assertions.assertThat(tree.resultOnSegment(4, 5)).isEqualTo(8);

        Assertions.assertThat(tree.resultOnSegment(0, 5)).isEqualTo(-1);
        Assertions.assertThat(tree.resultOnSegment(0, 3)).isEqualTo(-1);
        Assertions.assertThat(tree.resultOnSegment(0, 2)).isEqualTo(1);
        Assertions.assertThat(tree.resultOnSegment(2, 5)).isEqualTo(-1);
        Assertions.assertThat(tree.resultOnSegment(3, 5)).isEqualTo(4);
    }

    @RepeatedTest(5)
    void randomSegmentTreeMinTest() {
        Random random = new Random();
        int size = random.nextInt(10, 1_000_000);
        List<Integer> ints = new Random().ints().limit(size).boxed().toList();
        STMinimum segmentTreeMinimum = new STMinimum(ints);
        for (int i = 0; i < 1000; i++) {
            int left = random.nextInt(0, size);
            int right = random.nextInt(left, size + 1);
            int segmentTreeMin = segmentTreeMinimum.resultOnSegment(left, right);
            int actualMin = ints.stream()
                    .skip(left)
                    .limit(right - left)
                    .min(Integer::compare)
                    .orElse(0);
            assertThat(actualMin).isEqualTo(segmentTreeMin);
        }
    }

    @RepeatedTest(5)
    void randomSegmentTreeSumTest() {
        Random random = new Random();
        int size = random.nextInt(10, 1000);
        List<Integer> ints = new Random().ints().map(k -> Math.abs(k) > Integer.MAX_VALUE / 1000 ? k / 1000 : k).limit(size).boxed().toList();
        STSum segmentTreeSum = new STSum(ints);
        for (int i = 0; i < 1000; i++) {
            int left = random.nextInt(0, size);
            int right = random.nextInt(left, size + 1);
            int sum = segmentTreeSum.resultOnSegment(left, right);
            int actualSum = ints.stream()
                    .skip(left)
                    .limit(right - left)
                    .mapToInt(k -> k)
                    .sum();
            assertThat(actualSum).isEqualTo(sum);
        }
    }
}