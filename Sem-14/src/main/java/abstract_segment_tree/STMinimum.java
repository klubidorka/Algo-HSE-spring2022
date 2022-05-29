package abstract_segment_tree;

import java.util.List;

public class STMinimum extends AbstractSegmentTree<Integer> {
    public STMinimum(List<Integer> array) {
        super(array);
    }

    @Override
    protected Integer getNeutralElement() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected Integer operation(Integer left, Integer right) {
        return Math.min(left, right);
    }
}
