package LinkedList;

public class MergeLinkedList {

	public MergeLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> list1 = BuildLinkedList1();
		MyLinkedList<Integer> list2 = BuildLinkedList2();
		Node<Integer> result  = MergeList(list1,list2);
		list2.printList();
		//PrintLinkedList(result);
	}
	
	public static void PrintLinkedList(Node<Integer> _node)
	{

		StringBuffer buffer = new StringBuffer();
		while(_node!=null)
		{
			
			buffer.append(_node.data + "-->");
			_node = _node.next;
		}
		System.out.print(buffer.substring(0, buffer.length()-3));
		
	}
	
	public static Node<Integer> BuildLinkedList1()
	{
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.addToFront(8);
		list.addToFront(4);
		list.addToFront(1);
		return list.head;

	}
	
	
	public static MyLinkedList<Integer> BuildLinkedList2()
	{
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.addToFront(9);
		list.addToFront(3);
		list.addToFront(2);
		return list;


	}
	
	//simplified version
	public Node mergeTwoLists(Node<Integer> l1, Node<Integer> l2) {
		Node head = new Node(0);
		Node p = head;
	 
	    while(l1!=null||l2!=null){
	        if(l1!=null&&l2!=null){
	            if(l1.data < l2.data){
	                p.next = l1;
	                l1=l1.next;
	            }else{
	                p.next=l2;
	                l2=l2.next;
	            }
	            p = p.next;
	        }else if(l1==null){
	            p.next = l2;
	            break;
	        }else if(l2==null){
	            p.next = l1;
	            break;
	        }
	    }
	 
	    return head.next;
	}

	public static Node<Integer> MergeList(Node<Integer> head,MyLinkedList<Integer> list2)
	{
		if(head == null)
		{
			head = list2.head;
			return head;
		}
		
		Node<Integer> temp = head;
		Node<Integer> temp1 = list2.head;
		
		//compare and set the head node
		if(temp.data < temp1.data)
		{
			head = temp;
			temp = temp.next;
		}
		else
		{
			head = temp1;
			temp1 = temp1.next;
		}
		
		Node<Integer> mergedHead = head;
		
		//compare other nodes and attach it to head
		while(temp!=null && temp1!=null)
		{
			if(temp.data < temp1.data)
			{
				mergedHead.next = temp;
				temp = temp.next;
			
			}
			else if(temp1.data < temp.data)
			{
				mergedHead.next = temp1;
				temp1 = temp1.next;
				
			}
			mergedHead = mergedHead.next;
		}
		
		 if(temp != null) {
			 mergedHead.next = temp;
	        } else {
	        	mergedHead.next = temp1;
	        }
		return mergedHead;
	}
	

}
