



public class SinglyLinkedListSecond {
	
	
	public ListNode head;
	
	public  class ListNode
	{
		int data;
		
		ListNode next;
		public ListNode(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	public void insert(int data)
	{
		ListNode newNode=new ListNode(data);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			ListNode current =head;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next=newNode;
		}
	}
	
	public void insertNodeAtBegining(int data)
	{
		ListNode newNode=new ListNode(data);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			ListNode temp=head;
			newNode.next=temp;
			head=newNode;
		}
		return;
	}
	
	public void insertNodeAtEnd(int data)
	{
		ListNode newNode= new ListNode(data);
		if(head==null)
		{
		  head=newNode;
		  
		}
		else
		{
			ListNode temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newNode;
			return;
		}
	}
	public void insertNodeAftertGivenNode(int previous,int data)
	{
		
		ListNode newNode =new ListNode(data);
		if(head==null)
		{
			System.out.println("Operation can't be performmed");
		}
		else
		{
			ListNode temp=head;
			while(temp.data!=previous)
			{
				temp=temp.next;
			}
			
			newNode.next=temp.next;
			temp.next=newNode;
		}
		
	}
	
	public void insertNodeAtGievnPosition(int position,int data)
	{
		if(head==null)
		{
			System.out.println("LL is  emplty");
		}
		
		ListNode newNode= new ListNode(data);
		ListNode current=head;
		if(position==1)
		{
			ListNode temp=head;
			newNode.next=temp;
			head=newNode;
			
		}
		else {
		int count=1;
		while(count<position-1)
		{
			count++;
			 current= current.next;
		}
		newNode.next= current.next;
		 current.next=newNode;
		}
    }
 	
	//************DELETION********
	
public void deleteAtFirst()
{
	if(head==null)
	{
		System.out.println("LL is  emplty, cant be deleted");
	}
	ListNode temp=head;
	head=head.next;
	temp=null;
}
public void deleteAtLast()
{
	if(head==null)
	{
		System.out.println("LL is  emplty, cant be deleted");
	}
	// we go with two pointer which is last and previous to last 
	ListNode last=head;
	ListNode previousToLast=null;
	while(last.next!=null)
	{
		previousToLast=last;
		last=last.next;
	}
	previousToLast.next=null;
}

public void deletAtGivenPosition(int position)
{
	if(head==null)
	{
		System.out.println("LL is  emplty, cant be deleted");
	}
	ListNode current=head;
	int count=1;
	while(count<position-1)
	{
		count++;
		current=current.next;
	}
	System.out.println("Deleted node is: "+current.next.data);
	ListNode temp=current.next;
	current.next=temp.next;
	
	temp=null;
}

public void deleteTheGivenNodeValue(int key)
{
	if(head==null)
	{
		System.out.println("LL is  emplty, cant be deleted");
	}
	
	if(head.data==key)
	{
		ListNode temp=head;
		head=head.next;
		temp=null;
	}
	else
	{
	ListNode current=head;
	//int count=1;
	while(current.next.data!=key)
	{
		current=current.next;
	}
	ListNode temp=current.next;
	current.next=temp.next;
	temp=null;
	}
}
// SEARCH THE ELEMENT IN LL
public boolean searchTHeValue(int value)
{
	while(head.next!=null)
	{
		if(head.data==value)
		{
			return true;
		}
		head=head.next;
	}
	return false;
}

public void reverseandMakeAnotherLL()
{
	ListNode temp=head;
	while(temp!=null)
	{	
		insertNodeAtBegining(temp.data);
		temp=temp.next;
	}
	temp.next=null;
	return;

}
public void reverseTheLinkedList()
{
	ListNode current=head;
	ListNode previous=null;
	ListNode next=null;
	while(current!=null)
	{
		next=current.next;
		current.next=previous;
		previous=current;
		current=next;	
	}
   head=previous;
}

public void secongHalfReveresedLL()
{
	int count=1;
	ListNode current=head;
	while(current.next!=null)
	{
		count++;
		current=current.next;
	}
	ListNode temp=head;
	for (int i=1;i<(count/2);i++)
	{
		temp=temp.next;
	}
	ListNode joint=temp.next;
	temp.next=null;
	display();
	ListNode current1=joint;
	ListNode previous=null;
	ListNode next=null;
	while(current1!=null)
	{
		next=current1.next;
		current1.next=previous;
		previous=current1;
		current1=next;	
	}
	ListNode n=head;
	while(n.next!=null)
	{
		n=n.next;
	}
    n.next=previous;
}

public void firstHalfReveresdLL()
{
	ListNode c=head;
	int count=1;
	while(c.next!=null)
	{
		count++;
		c=c.next;
	}
	ListNode current=head;
	for(int i=1;i<(count/2);i++)
    {
	  current=current.next;
    }
	ListNode joint=current.next;
	current.next=null;
	display();
	ListNode current1=head;
	ListNode previous=null;
	ListNode next=null;
	while(current1!=null)
	{
		next=current1.next;
		current1.next=previous;
		previous=current1;
		current1=next;	
	}
	head=previous;
	display();
	ListNode n=head;
	while(n.next!=null)
	{
		n=n.next;
	}
	n.next=joint;
}

public void firstKthElementHalfReveresdLL(int k)
{

	ListNode current=head;
	for(int i=1;i<k;i++)
    {
	  current=current.next;
    }
	ListNode joint=current.next;
	current.next=null;
	//display();
	ListNode current1=head;
	ListNode previous=null;
	ListNode next=null;
	while(current1!=null)
	{
		next=current1.next;
		current1.next=previous;
		previous=current1;
		current1=next;	
	}
	head=previous;
	//display();
	ListNode n=head;
	while(n.next!=null)
	{
		n=n.next;
	}
	n.next=joint;
}

public void rotateFromKthWithClockWise( int k) {
    if(k==0)
    {
    	return;
    }
    ListNode current=head;
    int count=1;
    while(count<k && current!=null)
    {
    	current=current.next;
    	count++;
    }
    if(current==null)
    {
    	return;
    }
    ListNode temp=current;
    while(current.next!=null)
    {
    	current=current.next;
    }
    //connect lastnode to first node 60-->1
    current.next=head;
    //set head = temp next element
    head=temp.next;
    //set last temp value as null
    temp.next=null;
}
public void nthNodeFromtheEndOfTheLL(int n)
{
	if(n>sizeofLL())
	{
		System.out.println("Index out of range");
	}
	else
	{
	int count=1;
	ListNode current=head;
	while(current.next!=null)
	{
		count++;
		current=current.next;
	}
	int c=count-n;
	ListNode temp=head;
	for (int i=1;i<=c;i++)
	{
		temp=temp.next;
	}
	
	System.out.println("Value is: "+temp.data);
	}
}

// REMOVE THE DUPLICATES OF THE SORTED LL
public void removeDuplicatesOfSortedLL()
{
	ListNode temp=head;
	while(temp!=null && temp.next!=null)
	{
		if(temp.data==temp.next.data)
		{
			temp.next=temp.next.next;
		}
		else
		{
			temp=temp.next;
		}
	}
}
// ADD NODE IN SORTED SINGLY LINKED LIST

public void insertNodeAtSortedSLL(int data)
{
	ListNode newNode= new ListNode(data);
	ListNode current=head;
	ListNode temp=null;
	while(current!=null && current.data<newNode.data)
	{
		temp=current;
		current=current.next;
	}
	newNode.next=current;
	temp.next=newNode;
	
}

public int sizeofLL()
	{
		int count=1;
		ListNode temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
			count++;
		}
		return count;
	}

   public  void display()
   {
	   if(head==null)
	   {
		   System.out.println("Null");
		  
	   }
	   else
	   {
		   ListNode current =head;
		   while(current.next!=null)
		   {
			   System.out.print(current.data+"--> ");
			   current=current.next;
		   }
		   System.out.println(current.data+"--> null");   
	   }	  
   }
   
   public void afterMiddlePrint(ListNode head)
   {
	   ListNode temp=head;
	   int count=1;
	   while(temp.next!=null)
	   {
		   count++;
		   temp=temp.next;
	   }
	   for (int i=0;i<(count/2);i++)
	   {
		   head=head.next;
	   }
	   while(head.next!=null)
	    {
	   		System.out.print(head.data+"-->");
	 	   head=head.next;
	 	   
	    }
	   	System.out.println(head.data+"-->null");
   }
   
   public ListNode middleNode(ListNode head) {
      ListNode current=head;
      int count=1;
      while(current.next!=null)
      {
    	  current=current.next;
    	  count++;
      }
      for (int j=0;j<(count/2);j++)
      {
    	  head=head.next;
      }
      return head;
	}
       
   
   public boolean compute(ListNode head)
   {
       StringBuilder c= new StringBuilder();
      ListNode temp=head;
      int count=0;
      while(temp.next!=null)
      {
          temp=temp.next;
          count++;
      }
      System.out.println(count);
      ListNode temp1=head;
      while(temp1!=null)
      {
          c.append(temp1.data);
          System.out.println(temp1.data);
          temp1=temp1.next;
          
      }
      System.out.println(count);
      System.out.print(c);
      int a=0;
      int b=c.length()-1;
      System.out.println(b);
      System.out.println(c.charAt(a));
      System.out.println(c.charAt(b));
      while(a<b)
      {
          if(c.charAt(a)!=c.charAt(b))
          {
              return false;
          }
          a++;
          b--;
      }
      return true;
   }
   

   public int sum(ListNode head, int k){
	     ListNode temp=head;
	      System.out.println(sizeofLL());
	      for(int i=0;i<(sizeofLL()-k);i++)
	      {
	    	  System.out.println(temp.data);
	          temp=temp.next;
	      }
	      ListNode curr=temp;
	    //  temp=null;
	      int res=0;
	      while(curr!=null)
	      {
	          res=res+curr.data;
	          curr=curr.next;
	      }
	      return res;
	   
	  
	    }
	
   public void alternate()
   {
	   ListNode n = head;
	   int count = 0;
	   while(n!=null){
	   if(count%2==0){
	   System.out.print(n.data+" ");

	   }
	   n = n.next;
	   count++;
	   }
	  
   }
	public static void main(String[] args)
	{
		SinglyLinkedListSecond obj= new SinglyLinkedListSecond();
	    obj.insert(1);
		obj.insert(2);
		obj.insert(30);
		obj.insert(4);
		obj.insert(5);
		obj.insert(6);
		//obj.insert(7);
		obj.display();
		
		//System.out.println(obj.size());
		//obj.insertNodeAtBegining(99);
		//obj.display();
		
		//obj.insertNodeAtEnd(8);
		//obj.display();
		
		//obj.insertNodeAftertGivenNode(2, 100);
		//obj.display();
		
		
		//obj.insertNodeAtGievnPosition(1, 1000);
		//obj.display();
		//obj.insertNodeAtGievnPosition(3, 100);
		//obj.display();
	
//***************DELETION**********
		
		//obj.deleteAtFirst();
		//obj.display();
		
		//obj.deleteAtLast();
		//obj.display();
		
		//obj.deletAtGivenPosition(2);
		//obj.display();
		
		//obj.deleteTheGivenNodeValue(1);
		//obj.display();
	
		//System.out.println(obj.searchTHeValue(0));
		
		//obj.reverseTheLinkedList();
		//obj.display();
	
		//obj.nthNodeFromtheEndOfTheLL(7);
		
		    /*obj.insert(1);
			obj.insert(1);
			obj.insert(30);
			obj.insert(50);
			obj.insert(50);
			obj.insert(60);
			obj.insert(70);
			obj.insert(70);
			obj.display();
		
		obj.removeDuplicatesOfSortedLL();
		obj.display();*/
		
		//obj.secongHalfReveresedLL();
		//obj.display();
		
		//obj.firstHalfReveresdLL();
		//obj.display();
		
		//obj.firstKthElementHalfReveresdLL(4);
		//obj.display();
		
		   /* obj.insert(1);
			obj.insert(8);
		    obj.insert(10);
			obj.insert(16);
			obj.display();
		obj.insertNodeAtSortedSLL(18);*/
		
		/*obj.display();
		obj.insert(1);
		obj.insert(8);
	    obj.insert(8);
		obj.insert(1);
		obj.display();
		boolean k=obj.compute(head);
		System.out.println(k);*/
		
		//obj.rotateFromKthWithClockWise(3);
		//obj.display();
		
		//obj.reverseandMakeAnotherLL();
		
		
		//int lk=obj.sum(head, 3);
		//System.out.println(lk);
		//obj.display();
		
		//obj.alternate();
		
		//ListNode ab=obj.middleNode(head);
		//System.out.println(ab.data);
		//obj.afterMiddlePrint(head);
	}
}
