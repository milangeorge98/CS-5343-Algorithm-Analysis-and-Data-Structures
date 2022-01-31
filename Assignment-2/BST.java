public class BST {
    static class Node{
        int data;
        Node left, right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }

    //function to insert nodes into the binary tree

    Node insertNode(Node temp, int data){
        if(temp==null){
            return (new Node(data));
        }else{
            if(data<temp.data){
                temp.left =insertNode(temp.left,data);
            }else{
                temp.right=insertNode(temp.right,data);
            }
            return temp;
        }
    }

    //function to perform an inorder traversal

    void inOrderTraversal(Node node)
    {
        if (node == null)
            return;

        inOrderTraversal(node.left);

        System.out.print(node.data + " ");

        inOrderTraversal(node.right);
    }

    //function to delete a node from a BST taking into account three cases.
    Node deleteNode(Node root, int data)
    {
        //if the head is null
        if (root == null)
            return root;

        //traversing through the tree
        if (data < root.data)
            root.left = deleteNode(root.left, data);
        else if (data > root.data)
            root.right = deleteNode(root.right, data);

        else {
            // if there is only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            //determining the inorder successor
            root.data = inorderSuccessor(root.right);

            // Deleting the inorder successor
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    int inorderSuccessor(Node root)
    {
        int minNodeVal = root.data;
        while (root.left != null)
        {
            minNodeVal = root.left.data;
            root = root.left;
        }
        return minNodeVal;
    }

    public static void main(String[] args){
        BST tree= new BST();

        Node head = null;
        int i =0;

        int[] BSTNodes ={40, 60, 20, 80, 50, 10, 30, 15, 5, 35, 25, 45, 55, 70, 90, 32, 33, 48, 46};

        //to determine the length of the array above for easy insertion into the BST
        int len=0;

        for(int j:BSTNodes) len++;

        head = tree.insertNode(head, BSTNodes[i]);

        for(i=1; i<len; i++){
            tree.insertNode(head,BSTNodes[i]);
        }

        System.out.println("Inorder traversal of the given BST: ");
        tree.inOrderTraversal(head);
        System.out.println("\n");
        tree.deleteNode(head,40);
        System.out.println("After node with value 40 is deleted: ");
        tree.inOrderTraversal(head);
        System.out.println("\n");
        tree.deleteNode(head,20);
        System.out.println("After node with value 20 is deleted: ");
        tree.inOrderTraversal(head);
        System.out.println("\n");


    }



}
