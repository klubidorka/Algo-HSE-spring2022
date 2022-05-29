package abstract_segment_tree;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.List;

/**
 * Дерево отрезков для перемножения квадратных матриц размера 2 x 2 на отрезке
 */
public class STMatrixMul extends AbstractSegmentTree<RealMatrix> {
    public STMatrixMul(List<RealMatrix> array) {
        super(array);
    }

    @Override
    protected RealMatrix getNeutralElement() {
        double[][] matrixData = {{1d, 0d}, {0d, 1d}};
        return MatrixUtils.createRealMatrix(matrixData);
    }

    @Override
    protected RealMatrix operation(RealMatrix left, RealMatrix right) {
        return left.multiply(right);
    }
}