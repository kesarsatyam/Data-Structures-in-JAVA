
public class DoublyLL {
	private ListNode head;
	private ListNode tail;
	private int length;
	
public class ListNode
{
	ListNode previous;
	ListNode next;
	int data;
	public ListNode(int data)
	{
		this.data=data;
	}
}

public DoublyLL()
{
	this.head=null;
	this.tail=null;
	this.length= 0;
}
public boolean isEmpty()
{
		return length==0;//head=null
}
public int lengthofDLL()
{
	return length;
}
public void insert(int data)
{
	ListNode newNode= new ListNode (data);
	if(isEmpty())
	{
		head=newNode;
	}
	else
	{
		tail.next=newNode;		
	}
	newNode.previous=tail;
	tail=newNode;
	length++;
}
public void insertTFront(int data)
{
	ListNode newNode= new ListNode(data);
	if(isEmpty())
	{
		tail=newNode;
	}
	else
	{
		head.previous=newNode;
	}
	newNode.next=head;
	head=newNode;
	length++;
}
public void insertAtLast(int data)
{
	ListNode newNode = new ListNode(data);
	if(isEmpty())
	{
		head=newNode;
	}
	else
	{
		tail.next=newNode;
		newNode.previous=tail;
	}
	tail=newNode;
	length++;
}

public void deletAtFront() throws NoSuchElementException
{
	ListNode temp=head;
	if(isEmpty())
	{
		System.out.println("DLL is empty");
		throw new NoSuchElementException();
	}
	if(head==tail)
	{
		tail.next=null;
	}
	else
	{
		head.next.previous=null;
	}
	head=head.next;
	temp.next=null;
	length--;
}

public void deleteAtLast() throws NoSuchElementException
{
	if(isEmpty())
	{
		System.out.println("DLL is empty");
		throw new NoSuchElementException();
	}
	ListNode temp=tail;
	if(head==tail)
	{
		head=tail;
	}
	else
	{
		tail.previous.next=null;
	}
	tail.previous=tail;
	temp.previous=null;
	length--;
}
public void reversedDLL()
{
	ListNode current=head;
	ListNode nextNode;
	while(current!=null)
	{
		nextNode=current.next;
		current.next=current.previous;
		current.previous=nextNode;
		current=nextNode;
	}
	current=head;
	head=tail;
	//tail=current;
}
public void show()
{
	if(isEmpty())
	{
		System.out.println("null");
	}
	else
	{
	ListNode temp=head;
	while(temp!=null)
	{
		System.out.print(temp.data+"-->");
		temp=temp.next;
	}
	System.out.println("null");
	}
}
	public static void main(String[] args) throws NoSuchElementException {
		
		DoublyLL obj=new DoublyLL();
		//obj.show();
	    //obj.insert(1);
		//obj.insert(2);
		//obj.show();
		
		//obj.insertAtLast(3);
	    //obj.insertAtLast(4);
		//obj.show();
		
		//obj.insertTFront(6);
		//obj.insertTFront(5);
		//obj.insertTFront(4);
		//obj.show();
		
		obj.insert(6);
		obj.insert(5);
		obj.insert(4);
		obj.show();
		/*obj.deletAtFront();
		obj.deletAtFront();
		obj.deletAtFront();
		obj.deletAtFront();
		obj.show();*/
		
		/*obj.deletAtFront();
		obj.deletAtFront();
		obj.deletAtFront();
		obj.deletAtFront();
		obj.show();
		*/
		obj.reversedDLL();
		obj.show();
		
		
		
		

	}

}
