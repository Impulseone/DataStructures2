package BST2;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedBSTTest {

    @Test
    public void generateTreeTest() {
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{1, 2, 3});
        assertEquals(2, balancedBST.Root.NodeKey);
        assertEquals(1, balancedBST.Root.LeftChild.NodeKey);
        assertEquals(3, balancedBST.Root.RightChild.NodeKey);
    }

    @Test
    public void generateTreeTest2() {
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{1, 2, 3, 4, 5});
        assertEquals(3, balancedBST.Root.NodeKey);
        assertEquals(2, balancedBST.Root.LeftChild.NodeKey);
        assertEquals(5, balancedBST.Root.RightChild.NodeKey);
    }

    @Test
    public void isBalancedTest1(){
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{1, 2, 3});
        assertTrue(balancedBST.IsBalanced(balancedBST.Root));
    }

    @Test
    public void isBalancedTest2(){
        BalancedBST balancedBST = new BalancedBST();
        balancedBST.GenerateTree(new int[]{1, 2, 3, 4, 5});
        assertTrue(balancedBST.IsBalanced(balancedBST.Root));
    }

}