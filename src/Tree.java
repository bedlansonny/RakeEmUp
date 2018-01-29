import java.util.*;

public class Tree
{
    int[] leafCounts;
    int currentInd;
    int leftDepth;
    HashMap<Integer, Integer> piles;    //<position, leafcount>

    public Tree(int[] leafCounts)
    {
        this.leafCounts = leafCounts;
        currentInd = 0;
        leftDepth = 0;
        piles = new HashMap<>();
    }

    public void visit(Node parent)
    {
        piles.put(parent.pos, leafCounts[currentInd]);
        leftNode(parent);
        rightNode(parent);
    }

    public void leftNode(Node parent)
    {
        currentInd++;
        if(leafCounts[currentInd] == -1)
            return;
        leftDepth++;
        parent.left = new Node(parent.pos-1, leafCounts[currentInd]);
        visit(parent.left);
    }

    public void rightNode(Node parent)
    {
        currentInd++;
        if(leafCounts[currentInd] == -1)
            return;
        parent.right = new Node(parent.pos+1, leafCounts[currentInd]);
        visit(parent.right);
    }

    public String pilesOutput
    {
        String output = "";
    }


    public class Node
    {
        Node left, right;
        int leaves;
        int pos;

        public Node(int pos, int leaves)
        {
            this.pos = pos;
            this.leaves = leaves;
        }
    }
}
