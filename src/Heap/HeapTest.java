package Heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void MakeHeapTest() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1}, 3);
        assertEquals(heap.HeapArray[0], 1);
    }

    @Test
    public void MakeHeapTest2() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{2, 1}, 3);
        assertEquals(heap.HeapArray[0], 2);
        assertEquals(heap.HeapArray[1], 1);
    }

    @Test
    public void MakeHeapTest3() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{2, 1, 3}, 3);
        assertEquals(3, heap.HeapArray[0]);
        assertEquals(1, heap.HeapArray[1]);
        assertEquals(2, heap.HeapArray[2]);
    }

    @Test
    public void MakeHeapTest4() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 3, 2}, 4);
        assertEquals(4, heap.HeapArray[0]);
        assertEquals(2, heap.HeapArray[1]);
        assertEquals(3, heap.HeapArray[2]);
        assertEquals(1, heap.HeapArray[3]);
    }

    @Test
    public void MakeHeapTest5() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{11, 9, 4, 7, 8, 3, 1, 2, 5, 6}, 3);
        assertEquals(11, heap.HeapArray[0]);
        assertEquals(9, heap.HeapArray[1]);
        assertEquals(4, heap.HeapArray[2]);
    }

    @Test
    public void AddTest() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 3, 2}, 4);
        assertTrue(heap.Add(333));
    }

    @Test
    public void AddTest2() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4}, 4);
        assertTrue(heap.Add(333));
        assertEquals(heap.HeapArray[0], 333);
    }

    @Test
    public void getMaxTest() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4}, 4);
        int max = heap.GetMax();
        assertEquals(4, max);
        assertEquals(1, heap.HeapArray[0]);
    }

    @Test
    public void getMaxTest2() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 2}, 4);
        int max = heap.GetMax();
        assertEquals(4, max);
        assertEquals(2, heap.HeapArray[0]);
        assertEquals(1, heap.HeapArray[1]);
    }

    @Test
    public void getMaxTest3() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 2, 5}, 4);
        int max = heap.GetMax();
        assertEquals(5, max);
        assertEquals(4, heap.HeapArray[0]);
        assertEquals(1, heap.HeapArray[1]);
        assertEquals(2, heap.HeapArray[2]);
    }

    @Test
    public void getMaxTest4() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 4, 2, 5, 8}, 6);
        int max = heap.GetMax();
        assertEquals(8, max);
    }

}