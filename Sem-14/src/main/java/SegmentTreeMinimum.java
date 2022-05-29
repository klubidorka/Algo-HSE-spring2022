import java.util.ArrayList;
import java.util.List;

/**
 * Дерево отрезков для поиска минимума на отрезке
 */
public class SegmentTreeMinimum {

    public SegmentTreeMinimum(List<Integer> array) {
        extendedArraySize = calculateExtendedArraySize(array.size());
        tree = new ArrayList<>(extendedArraySize * 2 - 1);
        initialArray = array;
        for (int i = 0; i < extendedArraySize * 2 - 1; i++) {
            tree.add(Integer.MAX_VALUE);
        }
        build(array, 0, extendedArraySize, 0);
    }

    /**
     * @param left  левая граница искомого полуинтервала
     * @param right правая граница искомого полуинтервала
     * @return Минимум на получинтервале [left, right)
     */
    public int minOnSegment(int left, int right) {
        return minOnSegment(left, right, 0, 0, extendedArraySize);
    }

    /**
     * @param left         левая граница искомого полуинтервала
     * @param right        правая граница искомого полуинтервала
     * @param i            индекс вершины в ДО
     * @param iLeft        левая граница полуинтервала вершины i
     * @param iRight       правая граница полуинтервала вершины i
     * @return минимум на полуинтервале [left, right)
     */
    private int minOnSegment(int left, int right, int i, int iLeft, int iRight) {
        if (left <= iLeft && right >= iRight) // текущий полуинтервал вкладывается в искомый
            return tree.get(i);
        if (iLeft >= right || iRight <= left) // текущий полуинтервал не пересекается с искомым
            return Integer.MAX_VALUE;
        int iMiddle = (iLeft + iRight) / 2;
        int minLeft = minOnSegment(left, right, 2 * i + 1, iLeft, iMiddle);
        int minRight = minOnSegment(left, right, 2 * i + 2, iMiddle, iRight);
        return Math.min(minLeft, minRight);
    }

    /**
     * Находим наименьшее k, такое что k является степенью двойки и k >= arraySize.
     * Для хранения ДО понадобится массив из 2k - 1 элементов
     *
     * @param arraySize размер исходного массива
     * @return размер расширенного до ближайшей степени двойки массива
     */
    private int calculateExtendedArraySize(int arraySize) {
        int size = 1;
        while (size < arraySize)
            size *= 2;
        return size;
    }

    /**
     * Рекурсивно строим ДО сверху. Функция рассчитывает минимум на полуинтервале [left, right) исходного массива и
     * сохраняет его в массив tree на позицию i
     *
     * @param array исходный массив
     * @param left  левая граница полуинтервала
     * @param right правая граница полуинтервала
     * @param i     индекс в массиве tree, по которому будет записан минимум на полуинтервале
     */
    private void build(List<Integer> array, int left, int right, int i) {
        if (right - left == 1) {
            if (left < array.size())
                tree.set(i, array.get(left));
            return;
        }
        int middle = (left + right) / 2;
        build(array, left, middle, 2 * i + 1);
        build(array, middle, right, 2 * i + 2);
        tree.set(i, Math.min(tree.get(2 * i + 1), tree.get(2 * i + 2)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Integer> extended = new ArrayList<>(List.copyOf(initialArray));
        for (int i = 0; i < extendedArraySize - initialArray.size(); i++)
            extended.add(Integer.MAX_VALUE);
        sb.append("Initial array: ")
                .append(initialArray)
                .append(" size = ")
                .append(initialArray.size())
                .append('\n')
                .append("Extended initial array: ")
                .append(extended)
                .append(" size = ")
                .append(extended.size())
                .append('\n')
                .append("Segment tree: (size = ")
                .append(tree.size())
                .append(")\n");
        int cnt = 0;
        int elemsOnCurrentLayer = 1;
        for (Integer el : tree) {
            sb.append(el).append(" ");
            cnt++;
            if (cnt == elemsOnCurrentLayer) {
                sb.append('\n');
                cnt = 0;
                elemsOnCurrentLayer *= 2;
            }
        }
        return sb.toString();
    }


    private final int extendedArraySize;
    private final List<Integer> initialArray;
    private final List<Integer> tree;
}
