package abstract_segment_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Обобщенное дерево отрезков, которое работает с произвольной ассоциативной бинарной операцией.
 * То есть с операцией * такой, что  (a * b) * c = a * (b * c) для любых элементов множества, на котором определена *.
 *
 * Для работы со структурой необходимо отнаследоваться от данного класса и определить операцию * (метод operation(T left, T right))
 * и нейтральный элемент операции (метод getNeutralElement())
 *
 * @see STMinimum
 * @see STMatrixMul
 * @see STSum
 * @param <T> тип элементов множества, на котором определена операция *
 */
public abstract class AbstractSegmentTree<T> {
    public AbstractSegmentTree(List<T> array) {
        extendedArraySize = calculateExtendedArraySize(array.size());
        tree = new ArrayList<>(extendedArraySize * 2 - 1);
        for (int i = 0; i < extendedArraySize * 2 - 1; i++) {
            tree.add(getNeutralElement());
        }
        build(array, 0, extendedArraySize, 0);
    }

    public T resultOnSegment(int left, int right) {
        return resultOnSegment(left, right, 0, 0, extendedArraySize);
    }

    protected abstract T getNeutralElement();

    protected abstract T operation(T left, T right);

    private T resultOnSegment(int left, int right, int i, int iLeft, int iRight) {

        if (left <= iLeft && right >= iRight) // текущий полуинтервал вкладывается в искомый
            return tree.get(i);

        if (iLeft >= right || iRight <= left) // текущий полуинтервал не пересекается с искомым
            return getNeutralElement();

        int iMiddle = (iLeft + iRight) / 2;
        T resultLeft = resultOnSegment(left, right, 2 * i + 1, iLeft, iMiddle);
        T resultRight = resultOnSegment(left, right, 2 * i + 2, iMiddle, iRight);
        return operation(resultLeft, resultRight);
    }

    private int calculateExtendedArraySize(int arraySize) {
        int size = 1;
        while (size < arraySize)
            size *= 2;
        return size;
    }

    private void build(List<T> array, int left, int right, int i) {
        if (right - left == 1) {
            if (left < array.size())
                tree.set(i, array.get(left));
            return;
        }
        int middle = (left + right) / 2;
        build(array, left, middle, 2 * i + 1);
        build(array, middle, right, 2 * i + 2);
        tree.set(i, operation(tree.get(2 * i + 1), tree.get(2 * i + 2)));
    }

    private final int extendedArraySize;
    private final List<T> tree;
}
