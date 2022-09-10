package Forest;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleTreeTest {

    @Test
    public void evenTreesTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<Integer>(root);
        simpleTree.AddChild(root, new SimpleTreeNode<>(1, root));
        simpleTree.AddChild(root, new SimpleTreeNode<>(2, root));
        simpleTree.AddChild(root.Children.get(0), new SimpleTreeNode<>(3, root.Children.get(0)));
        ArrayList<Integer> result = simpleTree.EvenTrees();
        assertEquals(2, result.size());
        assertEquals(0, (int) result.get(0));
        assertEquals(1, (int) result.get(1));
    }

    @Test
    public void evenTreesTest2() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<>(root);
        simpleTree.AddChild(root, new SimpleTreeNode<>(2, root));
        simpleTree.AddChild(root, new SimpleTreeNode<>(3, root));
        simpleTree.AddChild(root, new SimpleTreeNode<>(6, root));
        simpleTree.AddChild(root.Children.get(0), new SimpleTreeNode<>(5, root.Children.get(0)));
        simpleTree.AddChild(root.Children.get(0), new SimpleTreeNode<>(7, root.Children.get(0)));
        simpleTree.AddChild(root.Children.get(1), new SimpleTreeNode<>(4, root.Children.get(1)));
        simpleTree.AddChild(root.Children.get(2), new SimpleTreeNode<>(8, root.Children.get(2)));
        simpleTree.AddChild(root.Children.get(2).Children.get(0), new SimpleTreeNode<>(9, root.Children.get(2).Children.get(0)));
        simpleTree.AddChild(root.Children.get(2).Children.get(0), new SimpleTreeNode<>(10, root.Children.get(2).Children.get(0)));
        ArrayList<Integer> result = simpleTree.EvenTrees();
        assertEquals(4, result.size());
        assertEquals(1, (int) result.get(0));
        assertEquals(3, (int) result.get(1));
        assertEquals(1, (int) result.get(2));
        assertEquals(6, (int) result.get(3));
    }

    @Test
    public void evenTreesTest3() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<>(root);
        simpleTree.AddChild(root, new SimpleTreeNode<>(2, root));
        simpleTree.AddChild(root, new SimpleTreeNode<>(3, root));
        simpleTree.AddChild(root.Children.get(0), new SimpleTreeNode<>(4, root.Children.get(0)));
        simpleTree.AddChild(root.Children.get(1), new SimpleTreeNode<>(5, root.Children.get(1)));
        simpleTree.AddChild(root.Children.get(0).Children.get(0), new SimpleTreeNode<>(6, root.Children.get(0).Children.get(0)));
        ArrayList<Integer> result = simpleTree.EvenTrees();
        assertEquals(4, result.size());
        assertEquals(2, (int) result.get(0));
        assertEquals(4, (int) result.get(1));
        assertEquals(1, (int) result.get(2));
        assertEquals(3, (int) result.get(3));
    }

    @Test
    public void evenTreesTest4() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> simpleTree = new SimpleTree<>(root);
        simpleTree.AddChild(root, new SimpleTreeNode<>(2, root));
        simpleTree.AddChild(root, new SimpleTreeNode<>(3, root));
        ArrayList<Integer> result = simpleTree.EvenTrees();
        assertEquals(0, result.size());
    }


}