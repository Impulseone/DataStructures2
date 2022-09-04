import java.util.*;

class Heap {
    public int[] HeapArray;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        HeapArray = new int[depth];
        for (int key : a) {
            Add(key);
        }
    }

    public int GetMax() {
        if (HeapArray[0] == 0)
            return -1;
        int maxElement = HeapArray[0];
        int lastExistElementIndex = findLastExistElementIndex();
        int lastExistElement = HeapArray[lastExistElementIndex];
        HeapArray[0] = lastExistElement;
        HeapArray[lastExistElementIndex] = 0;
        changeDown(0);
        return maxElement;
    }

    private int findLastExistElementIndex() {
        for (int i = HeapArray.length - 1; i >= 0; i--) {
            int currentElement = HeapArray[i];
            if (currentElement != 0) return i;
        }
        return 0;
    }

    public boolean Add(int key) {
        if (HeapArray[0] == 0) {
            HeapArray[0] = key;
            return true;
        }
        int index = HeapIsFilled();
        if (index == -1)
            return false;
        HeapArray[index] = key;
        changeUp(index);
        return true;
    }

    private void changeDown(int currentIndex) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;
        if (leftChildIndex >= HeapArray.length || rightChildIndex >= HeapArray.length || currentIndex >= HeapArray.length)
            return;
        if (HeapArray[leftChildIndex] < HeapArray[currentIndex] && HeapArray[rightChildIndex] < HeapArray[currentIndex]) {
            return;
        }
        if (HeapArray[leftChildIndex] > HeapArray[currentIndex]) {
            int temp = HeapArray[leftChildIndex];
            HeapArray[leftChildIndex] = HeapArray[currentIndex];
            HeapArray[currentIndex] = temp;
            changeDown(leftChildIndex);
        } else if (HeapArray[rightChildIndex] > HeapArray[currentIndex]) {
            int temp = HeapArray[rightChildIndex];
            HeapArray[rightChildIndex] = HeapArray[currentIndex];
            HeapArray[currentIndex] = temp;
            changeDown(rightChildIndex);
        }

    }

    private void changeUp(int currentIndex) {
        int parentIndex = currentIndex / 2;
        if (HeapArray[parentIndex] > HeapArray[currentIndex] || currentIndex == 0) {
            return;
        }
        int temp = HeapArray[parentIndex];
        HeapArray[parentIndex] = HeapArray[currentIndex];
        HeapArray[currentIndex] = temp;
        changeUp(parentIndex);
    }

    private int HeapIsFilled() {
        if (HeapArray[HeapArray.length - 1] != 0) return HeapArray.length - 1;
        for (int i = HeapArray.length - 1; i >= 0; i--) {
            if (HeapArray[i] == 0 && HeapArray[i - 1] != 0) return i;
        }
        return -1;
    }

}
