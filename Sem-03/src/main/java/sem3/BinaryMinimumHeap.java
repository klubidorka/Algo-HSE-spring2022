package sem3;

import java.util.*;


public class BinaryMinimumHeap {
    BinaryMinimumHeap() {
        storage = new ArrayList<>();
    }

    BinaryMinimumHeap(List<Integer> elements) {
        storage = new ArrayList<>(elements);
        buildHeapFast();
    }

    public void addElement(int element) {
        storage.add(element);
        siftUp(storage.size() - 1);
    }

    public int extractMinElement() {
        if (storage.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        int minElement = storage.get(0);
        storage.set(0, storage.get(storage.size() - 1));
        storage.remove(storage.size() - 1);
        siftDown(0);
        return minElement;
    }

    /**
     * Build heap adding elements one by one and then sift element up
     * Time complexity: O(NlogN)
     */
    private void buildHeapSlow() {
        for (int i = 1; i < storage.size(); i++) {
            siftUp(i);
        }
    }

    /**
     * Build heap adding elements one by one and then sift element down
     * Time complexity: O(N)
     */
    private void buildHeapFast() {
        for (int i = storage.size() / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * If the element is too small for its node, we move it closer to the root
     *
     * @param idx -- index of the element in storage to sift up
     */
    private void siftUp(int idx) {
        // while element is not the root
        while (idx > 0) {
            int parentIdx = (idx - 1) / 2;
            if (storage.get(idx) > storage.get(parentIdx)) {
                // Heap invariant is valid for idx
                return;
            }
            swapElementsAt(idx, parentIdx);
            idx = parentIdx;
        }
    }

    /**
     * If the element is too great for its node, we move it away from the root
     *
     * @param idx -- index of the element in storage to sift down
     */
    private void siftDown(int idx) {
        // while at least one child exists
        while (idx * 2 + 1 < storage.size()) {
            final int leftChildIdx = idx * 2 + 1;
            final int rightChildIdx = idx * 2 + 2;
            int leastChildIdx = leftChildIdx;
            if (rightChildIdx < storage.size() && storage.get(rightChildIdx) < storage.get(leftChildIdx)) {
                leastChildIdx = rightChildIdx;
            }
            if (storage.get(idx) <= storage.get(leastChildIdx)) {
                // Heap invariant is valid for idx
                break;
            }
            swapElementsAt(idx, leastChildIdx);
            idx = leastChildIdx;
        }
    }

    private void swapElementsAt(int i, int j) {
        int temp = storage.get(i);
        storage.set(i, storage.get(j));
        storage.set(j, temp);
    }

    private final List<Integer> storage;
}
