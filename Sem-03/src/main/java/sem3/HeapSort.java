package sem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> lst = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lst.add(sc.nextInt());
        }
        sort(lst);
        for (int i = lst.size() - 1; i >= 0; i--) {
            System.out.print(lst.get(i) + " ");
        }
    }

    static void sort(List<Integer> elements) {
        storage = elements;
        size = elements.size();
        buildHeap();
        for (int i = 0; i < elements.size(); i++) {
            swapElementsAt(0, elements.size() - 1 - i);
            size--;
            siftDown(0);
        }
    }

    private static void buildHeap() {
        for (int i = size / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    private static void siftDown(int idx) {
        // while at least one child exists
        while (idx * 2 + 1 < size) {
            final int leftChildIdx = idx * 2 + 1;
            final int rightChildIdx = idx * 2 + 2;
            int leastChildIdx = leftChildIdx;
            if (rightChildIdx < size && storage.get(rightChildIdx) < storage.get(leftChildIdx)) {
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

    private static void swapElementsAt(int i, int j) {
        int temp = storage.get(i);
        storage.set(i, storage.get(j));
        storage.set(j, temp);
    }

    private static List<Integer> storage;
    private static int size;
}
