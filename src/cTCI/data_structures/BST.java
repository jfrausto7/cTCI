package cTCI.data_structures;

import java.util.ArrayList;
import java.util.Random;

public class BST {
	
	private BSTNode root;	// root node
	private ArrayList<BSTNode> nodes;
	private Random randomGenerator;
	 
    /* Constructor */
    public BST()
    {
        root = null;
        nodes = new ArrayList<BSTNode>();
        randomGenerator = new Random();
    }
    
    /* insert function first */
    public void insert(int data)
    {
        root = insert(root, data);
        
    }
    
    /* Function to insert data recursively */
    private BSTNode insert(BSTNode node, int data)
    {
        if (node == null) {
            node = new BSTNode(data);
            nodes.add(node);
        }
        else
        {
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
    
    /* Delete function */
    public void delete(int k)
    {
        if (nodes.isEmpty())
            System.out.println("Tree Empty");
        else if (find(k) == false)
            System.out.println("Sorry "+ k +" is not present");
        else
        {
            root = delete(root, k);
            for(BSTNode n : nodes) {
            	if(n.data == k) {
            		nodes.remove(n);
            		break;
            	}
            }
            System.out.println(k+ " deleted from the tree");
        }
    }
    private BSTNode delete(BSTNode root, int k)
    {
        BSTNode p, p2, n;
        if (root.data == k)
        {
            BSTNode lt, rt;
            lt = root.left;
            rt = root.right;
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.left != null)
                    p = p.left;
                p.left = lt;
                return p2;
            }
        }
        if (k < root.data)
        {
            n = delete(root.left, k);
            root.left = n;
        }
        else
        {
            n = delete(root.right, k);
            root.right = n;             
        }
        return root;
    }
    
    /* Find method */
    public boolean find(int val)
    {
        return find(root, val);
    }
    /* Function to search for an element recursively */
    private boolean find(BSTNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.data;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = find(r, val);
        }
        return found;
    }
    
    /* Method for random node */
    public BSTNode getRandomNode() {
    	
    	int index = randomGenerator.nextInt(nodes.size());
    	return nodes.get(index);
    	
    }
    
    //driver code
//    public static void main(String[] args) {
//    	BST tree = new BST();
//    	
//    	//populate a bit
//    	tree.insert(7);
//    	tree.insert(17);
//    	tree.insert(3);
//    	tree.insert(5);
//    	tree.insert(1);
//    	
//    	tree.delete(17);
//    	tree.delete(23);
//    	
//    	System.out.println(tree.find(3));
//    	
//    	System.out.println(tree.getRandomNode().data);
//    }
}

/* Class BSTNode */
class BSTNode
{
    BSTNode left, right;
    int data;

    /* Constructor */
    public BSTNode(int n)
    {
        this.left = null;
        this.right = null;
        this.data = n;
    }
}
