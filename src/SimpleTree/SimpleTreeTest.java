package SimpleTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTreeTest {
    @Test
    public void addNodeTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(1, root));
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(2, root));
        assertEquals(3, simpleTree.Count());
    }

    @Test
    public void getCountTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        int count = simpleTree.Count();
        assertEquals(1, count);
    }

    @Test
    public void getLeafsCountTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> firstNode = new SimpleTreeNode<Integer>(1, root);
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(1, root));
        simpleTree.AddChild(root, firstNode);
        simpleTree.AddChild(firstNode, new SimpleTreeNode<Integer>(2, root));
        int count = simpleTree.LeafCount();
        assertEquals(2, count);
    }

    @Test
    public void deleteNodeTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        assertEquals(1, simpleTree.Count());
        SimpleTreeNode<Integer> nodeToDelete = new SimpleTreeNode<Integer>(1, root);
        simpleTree.AddChild(root, nodeToDelete);
        assertEquals(2, simpleTree.Count());
        simpleTree.AddChild(nodeToDelete, new SimpleTreeNode<Integer>(2, nodeToDelete));
        simpleTree.DeleteNode(nodeToDelete);
        assertEquals(1, simpleTree.Count());
        assertEquals(1, simpleTree.LeafCount());
    }

    @Test
    public void deleteNodeTest2() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        assertEquals(1, simpleTree.Count());
        SimpleTreeNode<Integer> nodeToDelete = new SimpleTreeNode<Integer>(1, root);
        simpleTree.AddChild(root, nodeToDelete);
        assertEquals(2, simpleTree.Count());
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(2, root));
        simpleTree.DeleteNode(nodeToDelete);
        assertEquals(2, simpleTree.Count());
        assertEquals(1, simpleTree.LeafCount());
    }

    @Test
    public void findNodesByValueTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(1, root));
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(1, root));
        simpleTree.AddChild(root, new SimpleTreeNode<Integer>(2, root));
        int size = simpleTree.FindNodesByValue(1).size();
        assertEquals(2, size);
    }

    @Test
    public void moveNodeTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> firstNode = new SimpleTreeNode<Integer>(1, root);
        simpleTree.AddChild(root, firstNode);
        SimpleTreeNode<Integer> secondNode = new SimpleTreeNode<Integer>(2, root);
        simpleTree.AddChild(firstNode, secondNode);
        SimpleTreeNode<Integer> thirdNode = new SimpleTreeNode<Integer>(3, root);
        simpleTree.AddChild(secondNode, thirdNode);
        simpleTree.MoveNode(secondNode, root);
        assertEquals(secondNode.Parent, root);
        assertEquals(1, secondNode.Children.size());
        assertNull( firstNode.Children);
    }

}
