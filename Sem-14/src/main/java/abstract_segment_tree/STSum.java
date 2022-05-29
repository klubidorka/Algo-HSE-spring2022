package abstract_segment_tree;

import java.util.List;

public class STSum extends AbstractSegmentTree<Integer> {
    public STSum(List<Integer> array) {
        super(array);
    }

    @Override
    protected Integer getNeutralElement() {
        return 0;
    }

    @Override
    protected Integer operation(Integer left, Integer right) {
        return left + right;
    }
}