package BinaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void findExistingNodeByKey() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        BSTFind<Integer> result = bst.FindNodeByKey(0);
        assertEquals(root, result.Node);
    }

    @Test
    public void findExistingNodeByKey2() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        BSTFind<Integer> result = bst.FindNodeByKey(0);
        assertEquals(root, result.Node);
    }

    @Test
    public void findLeftAbsentNodeByKey() {
        BSTNode<Integer> root = new BSTNode<>(5, 0, null);
        BST<Integer> bst = new BST<>(root);
        BSTFind<Integer> result = bst.FindNodeByKey(1);
        assertEquals(result.Node, root);
        assertFalse(result.NodeHasKey);
        assertTrue(result.ToLeft);
    }

    @Test
    public void findRightAbsentNodeByKey() {
        BSTNode<Integer> root = new BSTNode<>(5, 0, null);
        BST<Integer> bst = new BST<>(root);
        BSTFind<Integer> result = bst.FindNodeByKey(6);
        assertEquals(result.Node, root);
        assertFalse(result.NodeHasKey);
        assertFalse(result.ToLeft);
    }

    @Test
    public void findNodeByKeyInEmptyTree() {
        BST<Integer> bst = new BST<>(null);
        BSTFind<Integer> result = bst.FindNodeByKey(0);
        assertNull(result.Node);
    }

    @Test
    public void addRight() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAdding = bst.AddKeyValue(1, 2);
        assertTrue(resultAdding);
        BSTFind<Integer> resultSearching = bst.FindNodeByKey(1);
        assertEquals(root.RightChild, resultSearching.Node);
    }

    @Test
    public void addLeft() {
        BSTNode<Integer> root = new BSTNode<>(6, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAdding = bst.AddKeyValue(1, 2);
        assertTrue(resultAdding);
        BSTFind<Integer> resultSearching = bst.FindNodeByKey(1);
        assertEquals(root.LeftChild, resultSearching.Node);
    }

    @Test
    public void addExistingTest() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAdding = bst.AddKeyValue(0, 2);
        assertFalse(resultAdding);
    }

    @Test
    public void addExistingTest2() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAddingT = bst.AddKeyValue(1, 0);
        boolean resultAddingT2 = bst.AddKeyValue(-1, 0);
        boolean resultAddingT3 = bst.AddKeyValue(2, 0);

        assertTrue(resultAddingT);
        assertEquals(root.LeftChild.NodeKey, -1);
        assertTrue(resultAddingT2);
        assertEquals(root.RightChild.NodeKey, 1);
        assertTrue(resultAddingT3);
        assertEquals(root.RightChild.RightChild.NodeKey, 2);
        assertNull(root.RightChild.LeftChild);

        boolean resultAdding = bst.AddKeyValue(1, 1);
        boolean resultAdding2 = bst.AddKeyValue(-1, 1);
        boolean resultAdding3 = bst.AddKeyValue(0, 1);
        boolean resultAdding4 = bst.AddKeyValue(2, 1);

        assertFalse(resultAdding);
        assertFalse(resultAdding2);
        assertFalse(resultAdding3);
        assertFalse(resultAdding4);
    }

    @Test
    public void addExistingTest3() {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> bst = new BST<>(root);
        boolean resultAddingT = bst.AddKeyValue(1, 0);
        boolean resultAddingT2 = bst.AddKeyValue(-1, 0);
        boolean resultAddingT3 = bst.AddKeyValue(2, 0);
        boolean resultAddingT4 = bst.AddKeyValue(3, 0);
        boolean resultAddingT5 = bst.AddKeyValue(4, 0);
        boolean resultAdding = bst.AddKeyValue(1, 0);
        boolean resultAdding2 = bst.AddKeyValue(-1, 0);
        boolean resultAdding3 = bst.AddKeyValue(0, 0);
        boolean resultAdding4 = bst.AddKeyValue(3, 0);
        boolean resultAdding5 = bst.AddKeyValue(4, 0);

        assertTrue(resultAddingT);
        assertTrue(resultAddingT2);
        assertTrue(resultAddingT3);
        assertTrue(resultAddingT4);
        assertTrue(resultAddingT5);

        assertFalse(resultAdding);
        assertFalse(resultAdding2);
        assertFalse(resultAdding3);
        assertFalse(resultAdding4);
        assertFalse(resultAdding5);
        assertEquals(bst.Count(), 6);
    }

    @Test
    public void addExistingTest4() {
        BST<Integer> tree = new BST<Integer>(new BSTNode<Integer>(8, 0, null));
        boolean result = tree.AddKeyValue(8, 0);
        assertFalse(result);
        assertNull(tree.Root.LeftChild);
        assertNull(tree.Root.RightChild);
    }

    @Test
    public void addExistingTest5() {
        BST<Integer> tree = new BST<Integer>(new BSTNode<Integer>(8, 0, null));
        tree.DeleteNodeByKey(8);
        boolean result = tree.AddKeyValue(8, 0);
        assertTrue(result);
    }

    @Test
    public void addInEmptyTreeTest() {
        BST<Integer> bst = new BST<>(null);
        boolean resultAdding = bst.AddKeyValue(0, 2);
        assertTrue(resultAdding);
    }

    @Test
    public void findMaxFromRootTest() {
        BSTNode<Integer> root = new BSTNode<>(10, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(11, 4);
        BSTNode<Integer> result = bst.FinMinMax(root, true);
        assertEquals(11, result.NodeKey);
    }

    @Test
    public void findMaxFromChildTest() {
        BSTNode<Integer> root = new BSTNode<>(10, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(11, 4);
        bst.AddKeyValue(7, 4);
        BSTNode<Integer> result = bst.FinMinMax(root.LeftChild, true);
        assertEquals(7, result.NodeKey);
    }

    @Test
    public void findMaxInEmptyTreeTest() {
        BST<Integer> bst = new BST<>(null);
        BSTNode<Integer> result = bst.FinMinMax(new BSTNode<>(10, 0, null), true);
        assertNull(result);
    }

    @Test
    public void findMinFromRootTest() {
        BSTNode<Integer> root = new BSTNode<>(10, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(11, 4);
        BSTNode<Integer> result = bst.FinMinMax(root, false);
        assertEquals(5, result.NodeKey);
    }

    @Test
    public void findMinFromChildTest() {
        BSTNode<Integer> root = new BSTNode<>(7, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(13, 4);
        bst.AddKeyValue(9, 4);
        BSTNode<Integer> result = bst.FinMinMax(root.RightChild, false);
        assertEquals(9, result.NodeKey);
    }

    @Test
    public void deleteLeftChildTest() {
        BSTNode<Integer> root = new BSTNode<>(8, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(4, 2);
        bst.AddKeyValue(12, 4);
        boolean result = bst.DeleteNodeByKey(4);
        assertNull(bst.Root.LeftChild);
        assertTrue(result);

    }

    @Test
    public void deleteTest2() {
        BSTNode<Integer> root = new BSTNode<>(8, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(4, 2);
        bst.AddKeyValue(12, 4);
        bst.AddKeyValue(2, 4);
        boolean result = bst.DeleteNodeByKey(4);
        assertTrue(result);
        assertEquals(bst.Root.LeftChild.NodeKey, 2);
    }

    @Test
    public void deleteTest3() {
        BSTNode<Integer> root = new BSTNode<>(8, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(4, 2);
        bst.AddKeyValue(2, 4);
        bst.AddKeyValue(6, 4);
        boolean result = bst.DeleteNodeByKey(4);
        assertTrue(result);
    }

    @Test
    public void deleteTest4() {
        BST<Integer> bst = new BST<>(null);
        boolean result = bst.DeleteNodeByKey(4);
        assertFalse(result);
    }

    @Test
    public void countTest() {
        BSTNode<Integer> root = new BSTNode<>(7, 0, null);
        BST<Integer> bst = new BST<>(root);
        bst.AddKeyValue(5, 2);
        bst.AddKeyValue(13, 4);
        bst.AddKeyValue(9, 4);
        int count = bst.Count();
        assertEquals(4, count);
    }

    @Test
    public void countTest2() {
        BST<Integer> bst = new BST<>(null);
        int count = bst.Count();
        assertEquals(0, count);
    }

    @Test
    public void wideNodesTest() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 0, null));
        bst.AddKeyValue(0, 0);
        bst.AddKeyValue(7, 0);
        bst.AddKeyValue(3, 0);
        bst.AddKeyValue(8, 0);
        List<BSTNode> list = bst.WideAllNodes();
        assertEquals(5, list.get(0).NodeKey);
        assertEquals(0, list.get(1).NodeKey);
        assertEquals(7, list.get(2).NodeKey);
        assertEquals(3, list.get(3).NodeKey);
        assertEquals(8, list.get(4).NodeKey);
    }

    @Test
    public void deepNodesPreOrderTest() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 0, null));
        bst.AddKeyValue(0, 0);
        bst.AddKeyValue(7, 0);
        bst.AddKeyValue(3, 0);
        bst.AddKeyValue(8, 0);
        List<BSTNode> list = bst.DeepAllNodes(2);
        assertEquals(5, list.get(0).NodeKey);
        assertEquals(0, list.get(1).NodeKey);
        assertEquals(3, list.get(2).NodeKey);
        assertEquals(7, list.get(3).NodeKey);
        assertEquals(8, list.get(4).NodeKey);
    }

    @Test
    public void deepNodesInOrderTest() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 0, null));
        bst.AddKeyValue(0, 0);
        bst.AddKeyValue(7, 0);
        bst.AddKeyValue(3, 0);
        bst.AddKeyValue(8, 0);
        List<BSTNode> list = bst.DeepAllNodes(0);
        assertEquals(0, list.get(0).NodeKey);
        assertEquals(3, list.get(1).NodeKey);
        assertEquals(5, list.get(2).NodeKey);
        assertEquals(7, list.get(3).NodeKey);
        assertEquals(8, list.get(4).NodeKey);
    }

    @Test
    public void deepNodesPostOrderTest() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 0, null));
        bst.AddKeyValue(0, 0);
        bst.AddKeyValue(7, 0);
        List<BSTNode> list = bst.DeepAllNodes(1);
        assertEquals(0, list.get(0).NodeKey);
        assertEquals(7, list.get(1).NodeKey);
        assertEquals(5, list.get(2).NodeKey);
    }
}
