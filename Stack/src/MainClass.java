

/*

class MainClass
{
	int[] stack=new int[5]; 
	int top=0;
	void push(int data)
	{
		
	if(top==stack.length)
	{
		System.out.println("Overflow");
	    return;
	}
	else
	{
	stack[top]=data;
	top++;}
	}
	int pop()
	{
		int element=0;//before returning we have to assign some value
		if(isEmpty())
		{
			System.out.println("Underflow condition");
		}
		else
		{		
		top--;
		element=stack[top];
		}
		return element;
	}
	int peak()
	{
		if(top==0)
			System.out.println("No elements in the stack");
		int ele;
		ele=stack[top-1];
		return ele;
	}
	int size()
	{
	return top;
	}
	public boolean isEmpty()
	{
		return top<=0;
	}
	void show()
	{
		for(int x=0;x<top;x++)
			System.out.print(stack[x]+" ");
	}
	public static void main(String[] args)
	{
		
		MainClass obj=new MainClass();
		//obj.push(1);
		//obj.push(2);
		//System.out.println(obj.size());
		//obj.push(3);
		//obj.push(4);
		//obj.push(5);
		//System.out.println(obj.size());
		//obj.push(5);
	
		//System.out.println(obj.pop());
		//System.out.println(obj.pop());
		//System.out.println(obj.pop());
		//System.out.println(obj.pop());
		//System.out.println(obj.pop());
		//System.out.println(obj.pop());
		//obj.show();
		
		//System.out.println(obj.peak());
		//obj.show();
		
			
	}
}
*/


// USING DYNAMIC ARRAY
//LINKED LIST
import java.util.*;
class MainClass
{
	public ListNode head;
	public int length=0;
	class ListNode
	{
		ListNode next;
		int data;
		public ListNode(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	public void push(int data)
	{
		ListNode newNode=new ListNode(data);
		if(length==0)
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
			
		}
		length++;
			
	}
	public void pop()
	{
		if(length==0)
		{
			System.out.println("Underflow condition, Stack is empty");
			return;
		}
		if(length==1)
		{
			head=null;
		}
		else
		{
		ListNode last=head;
		ListNode preToLast=head;
		while(last.next!=null)
		{
			preToLast=last;
			last=last.next;
		}
		preToLast.next=null;
		}
		length--;
	}
	public void peek()
	{
		if(length==0)
		{
			System.out.println("Stack is empty");
			return;
		}
		else
		{
		ListNode temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		System.out.println("Peek valuse is:"+temp.data);
		}
	}
	public void show()
	{
		ListNode temp=head;
		while(temp!=null)
		{
			
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args)
	{
		MainClass obj=new MainClass();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		
	//	System.out.println(obj.length);
		obj.show();
		obj.pop();
		obj.pop();
		obj.pop();
		obj.pop();
		//System.out.println(obj.length);
		//obj.pop();
		//obj.pop();
		obj.peek();
		
		
		obj.show();
	}
	
	
}
