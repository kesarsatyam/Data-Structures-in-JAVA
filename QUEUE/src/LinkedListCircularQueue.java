
public class LinkedListCircularQueue {
	
	public ListNode last;
	public int length=0;
	public class ListNode
	{
		ListNode next;
		int data;
		public ListNode (int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	public void enQueue(int data)
	{
		ListNode newNode=new ListNode(data);
		if(length==0)
		{
			last=newNode;
			last.next=newNode;
		}
		else
		{
			last.next=newNode;
			newNode.next=last;
			last=newNode;
		}
		length++;
	}
	public void show()
	{
		if(length==0)
		{
			System.out.println("Queue is empty");
			return;
		}
		ListNode temp=last.next;
		while(temp!=last)
		{
			System.out.print(temp.data+" ->");
			temp=temp.next;
		}
		System.out.println(temp.data+"-> null");
	}
	public void deQueque()
	{
		if(length==0)
		{
			System.out.println("Queue is empty, UNDERFLOW!!");
		}
		
		else
		{
			last.next=last.next.next;
		}
		length--;
	}
	public void front()
	{
		if(length==0)
		{
			System.out.println("Queue is empty");
		}
		else
		{
			System.out.println("Front element is "+last.next.data);
		}
	}
	
public static void main(String[] args)
{
	LinkedListCircularQueue obj=new LinkedListCircularQueue();
	obj.enQueue(1);
	obj.enQueue(2);
	obj.front();
	obj.show();
	obj.deQueque();
	
	obj.front();
	//obj.deQueque();
	obj.show();
	obj.front();
	
}
}
