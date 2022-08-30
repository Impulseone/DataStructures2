import java.util.*;

class BSTNode {
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int Level; // глубина узла

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root; // корень дерева

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        Arrays.sort(a);
        Root = generate(a, null);
    }

    private BSTNode generate(int[] a, BSTNode parent) {
        if (a.length == 0) return null;
        int middleElementIndex = a.length / 2;
        BSTNode bstNode = new BSTNode(a[middleElementIndex], parent);
        if (parent != null) bstNode.Level = parent.Level + 1;
        else bstNode.Level = 0;
        bstNode.LeftChild = generate(Arrays.copyOfRange(a, 0, middleElementIndex), bstNode);
        bstNode.RightChild = generate(Arrays.copyOfRange(a, middleElementIndex + 1, a.length), bstNode);
        return bstNode;
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node == null) return false;
        LinkedList<BSTNode> queue = new LinkedList<>();
        queue.add(root_node);
        while (queue.size() > 0) {
            var tempNode = queue.get(0);
            queue.remove(0);
            if (tempNode.LeftChild != null) {
                if (tempNode.LeftChild.NodeKey >= tempNode.NodeKey) return false;
                queue.add(tempNode.LeftChild);
            }
            if (tempNode.RightChild != null) {
                if (tempNode.RightChild.NodeKey < tempNode.NodeKey) return false;
                queue.add(tempNode.RightChild);
            }
        }
        return calculateLevel(root_node.LeftChild, 0) - calculateLevel(root_node.RightChild, 0) < 2;
    }

    private int calculateLevel(BSTNode root_node, int currentLevel) {
        if (root_node == null) return currentLevel;
        LinkedList<BSTNode> queue = new LinkedList<>();
        queue.add(root_node);
        while (queue.size() > 0) {
            var tempNode = queue.get(0);
            queue.remove(0);
            if (tempNode.LeftChild != null) {
                currentLevel = tempNode.LeftChild.Level;
                queue.add(tempNode.LeftChild);
            }
            if (tempNode.RightChild != null) {
                currentLevel = tempNode.RightChild.Level;
                queue.add(tempNode.RightChild);
            }
        }
        return currentLevel;
    }
}
