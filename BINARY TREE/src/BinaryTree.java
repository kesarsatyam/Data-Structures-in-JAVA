import java.util.*;


class BinaryTree
{
	public static TreeNode root;
	public class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int data;
		public TreeNode(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public void createNode()
	{
		/*
		 *             root(1)
		 *             /     \
		 *            2       3
		 *           /       /  \
		 *          4       5    6
		 *         / \     / \  /  \
		 *       N   N    7   N N   N
		 *               /  \
		 *              N   8
		 *                 /
		 *                 9
		 *                / \
		 *               N   N
		 */
		TreeNode first=new TreeNode(1);
		TreeNode second=new TreeNode(2);
		TreeNode third=new TreeNode(3);
		TreeNode fourth=new TreeNode(4);
		TreeNode fifth=new TreeNode(5);
		TreeNode sixth=new TreeNode(6);
		TreeNode seventh=new TreeNode(7);
		TreeNode eight=new TreeNode(8);
		TreeNode nine=new TreeNode(9);
		root=first;
		first.left=second;
		first.right=third;
		second.left=fourth;
		third.left=fifth;
		third.right=sixth;
		fifth.left=seventh;
		seventh.right=eight;
		eight.left=nine;
		
	}
	public void preOrder(TreeNode root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.data+ " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void preOrderIterative(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		Stack<TreeNode> queue = new Stack<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			TreeNode temp=queue.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
			{
				queue.add(temp.right);
			}
			if(temp.left!=null)
			{
				queue.add(temp.left);
			}
			
			
		}
	}
	public void postOrder(TreeNode root)
	{
		if(root==null)
		{
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+ " ");
	}
	
	// USING ON ESTACK
	// 
	public void postOrderIterativeUsingTwoStack(TreeNode root)
	{
		if(root==null)
		{
			return;
		}
		Stack <TreeNode> s1= new Stack<TreeNode>();
		Stack <TreeNode> s2= new Stack<TreeNode>();
		s1.push(root);
		while(s1.size()>0)
		{
			TreeNode temp=s1.pop();
			if(temp.left!=null)
			{
				s1.push(temp.left);
			}
			if(temp.right!=null)
			{
				s1.push(temp.right);
			}
			s2.push(temp);
		}
		while(s2.size()>0)
		{
			System.out.print(s2.pop().data+ " ");
		}
	}
	
	public void inOrder(TreeNode root)
	{
		if(root==null)
		{
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+ " ");
		inOrder(root.right);
	}
	
	// MAINTAIN ONE STACK WHICH STORES THE LEFT NODE AND CHECK IF LEFT IS NULL THEN THEN PRINT THE NODE
	// AND CALL THE RIGHT NODE OF THE DATA .
	public void inOrderIterative(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp=root;
		while(!stack.isEmpty() || temp!=null)
		{
			if(temp!=null)
			{
				stack.push(temp);
				temp=temp.left;
			}
			else
			{
				temp=stack.pop();
				System.out.print(temp.data+" ");
				temp=temp.right;
			}
		
		}
	}
	
	public void levelOrderTraversal(TreeNode root) 
	
	{
		if(root ==null)
		{
			return ;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			
			TreeNode temp=queue.poll();
			
			System.out.print(temp.data+" ");
			
			if(temp.left!=null)
			{
				queue.add(temp.left);
			}
			if(temp.right!=null)
			{
				queue.add(temp.right);
			}
		}	
	}
	// FIRST MAKE QUESE AND STACK 
	// STARTING FROM ROOT NODE PUT INTO THE STACK
	// THEN CEHCK IF IT'S RIGHT NODE IS NOT NULL THEN PUSH TO THE STACK AND ALSO CHECK FOR LEFT NODE
	// AND THEN PUSH to the stack popped queue element till queue size is zero
	// then print the stack element
	public void reverseLevelOrderTraversel(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		Queue<TreeNode> que = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		que.add(root);
		while(que.size()>0)
		{
			TreeNode element=que.remove();
			if(element.right!=null)
			{
				que.add(element.right);
			}
			if(element.left!=null)
			{
				que.add(element.left);
			}
			stack.push(element);
		}
		while(stack.size()>0)
		{
			System.out.print(stack.pop().data+" ");
		}
			
	}
	// GET THE HIEGHT OF THE BINARY TREE THEN PRINT EACH LEVEL NODES BY CALLING PRINTATGIVEN LEVEL FUNCTION
	public void levelOrderUsingRecurison(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		int height=heightOfTree(root);
		for (int i=0;i<=height;i++)
		{
			printNodesAtGivenLevel(root,i+1);		
		}
	}
	public void reverseLevelOrderTraversalUsingRecursion(TreeNode rort)
	{
		if(root==null)
		{
			return;
		}
		int height=heightOfTree(root);
		for(int i=height+1;i>=1;i--)
		{
			printNodesAtGivenLevel(root,i);
			
		}
	}
	public int sumOfNodes(TreeNode root)
	{
		if(root==null)
		{
			return 0;
		}
	
		return root.data+sumOfNodes(root.left)+sumOfNodes(root.right);
	}
	public int differenceOfEvenOddLevel(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		return root.data - differenceOfEvenOddLevel(root.left)-differenceOfEvenOddLevel(root.right);
	}
	public int noOfNodes(TreeNode root)
	{
		if(root==null)
		{
			return 0;
		}
		
		return 1+noOfNodes(root.left)+noOfNodes(root.right);
	}
	public void printLeafNodes(TreeNode root)
	{
		if(root ==  null)
		{
			return;
		}
		if(root.left==null && root.right== null)
		{
			System.out.print(root.data+" ");
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}
	public int getNumberOfLeafNodes(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{
			return 1;
		}
		return getNumberOfLeafNodes(root.left)+getNumberOfLeafNodes(root.right);
	}
	public int heightOfTree(TreeNode root)
	{
		if(root==null)
		{
			return -1;
		}
		return Math.max(heightOfTree(root.left), heightOfTree(root.right))+1;
	}
	
	public void printNodesAtGivenLevel(TreeNode root,int level)
	{
		if(root == null)
		{
			return;
		}
		
		if(level==1)
		{
			System.out.print(root.data+ " ");
			return;
		}
		printNodesAtGivenLevel(root.left,level-1);
		printNodesAtGivenLevel(root.right,level-1);
		
	}
	// WE WILL TAEK ONE VARIBALE MAXLEVEL SET 0 
	// our root node is at level 0 so we check in if condition if leval>=maxlevel then print data
	// count maxlevel++
	// the recursively call left and right of thr data
	// suposr if second level has 2 nodes then it will omnly print left and maxlevel +1 so that right
	// of the data will not print because maxlevel is incresed.
	
	int maxlevel=0; // initialize one var wich will record maxlevel 
	
	public void printLeftView(TreeNode root,int level)
	{
		if(root == null)
		{
			return;
		}
	    if(maxlevel<level)
	    {
	    	System.out.print(root.data+ " ");
	    	maxlevel++;
	    }
		printLeftView(root.left,level+1);
		printLeftView(root.right,level+1);
	}
	
	int maxlevel1=0;
	public void printRightView(TreeNode root,int level)
	{

		if(root == null)
		{
			return;
		}
	    if(maxlevel1<level)
	    {
	    	System.out.print(root.data+ " ");
	    	maxlevel1++;
	    }
		
		printRightView(root.right,level+1);
		printRightView(root.left,level+1);
	}
	
	public void printTopView(TreeNode root)
	{
	}
	public TreeNode mirrorBinaryTree(TreeNode root)
	{
		if(root == null)
		{
			return null;
		}
		TreeNode t=root.left;
		root.left=root.right;
		root.right=t;
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
		return root;
	}
	public static void main(String[] args)
	{
	
		BinaryTree obj=new BinaryTree();
		
		obj.createNode();
		
		System.out.print("preOrder: ");
	    obj.preOrder(root);
	    
	    System.out.println();
	    System.out.print("preOrder ITERATIVE: ");
	    obj.preOrderIterative(root);
	    
	    System.out.println();
	    System.out.print( "postOrder: ");
	    obj.postOrder(root);
	    System.out.println();
	    
	    System.out.print("postOrder ITERATIVE: ");
	    obj.postOrderIterativeUsingTwoStack(root);
	    System.out.println();
	    
	    /*System.out.print( "inOrder: ");
	    obj.inOrder(root);
	    System.out.println();
	    
	    
	    System.out.print( "inOrder ITERATIVE: ");
	    obj.inOrderIterative(root);
	    System.out.println();
	   
	    System.out.print("LEVEL ORDER WITHOUT RECURSION: ");
		obj.levelOrderTraversal(root);
		System.out.println();
		
		System.out.print("LEVEL ORDER USING RECURSION: ");
		obj.levelOrderUsingRecurison(root);
		System.out.println();
		
		System.out.print("REVERSE LEVEL ORDER USING RECURSION: ");
		obj.reverseLevelOrderTraversalUsingRecursion(root);
		System.out.println();
		
		System.out.print("REVERSE LEVEL ORDER WITHONT RECURSION: ");
		obj.reverseLevelOrderTraversel(root);
		System.out.println();
	
		System.out.println("Sums of Nodes: "+obj.sumOfNodes(root));
	  
		System.out.println("Difference between even odd level: "+obj.differenceOfEvenOddLevel(root));
	    
		System.out.println("Number of all the nodes: "+obj.noOfNodes(root));
	    
		System.out.print("Leaf Nodes: ");
	    obj.printLeafNodes(root);
	    System.out.println();
	    
	    System.out.println("Number Of Leaf Nodes: "+  obj.getNumberOfLeafNodes(root));
	    
	    System.out.println("Height of Tree: "+obj.heightOfTree(root));
	    
	    System.out.print("Nodes at given level: "); obj.printNodesAtGivenLevel(root, 4);
	    
	    System.out.println();
	   System.out.print("Left View: ");  obj.printLeftView(root, 1);
	    
	    System.out.println();
	    System.out.print("Right View: "); obj.printRightView(root, 1);
	    
	    System.out.println();
	    System.out.print("Top View: "); obj.printTopView(root);*/
	    
	    System.out.println();
	    System.out.print("Mirroe Binary tree: "); obj.mirrorBinaryTree(root);
	    
	    System.out.println();
	    obj.preOrder(root);
	}
}