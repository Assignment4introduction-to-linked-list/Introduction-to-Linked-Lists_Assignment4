package eg.edu.alexu.csd.datastructure.linkedList.csX22;

public class Double_Linked_list implements ILinkedList{

	
	class Node{
		Object element;
		Node next,previous;
	}
	private int size;
	private Node head,tail;
	Double_Linked_list(){
		size=0;
		head=tail=null;
	}
	@Override
	public void add(int index, Object element) {
		Node Nnew=new Node();
		Nnew.element=element;
		Node pos=head;
		if (index==size-1) {
			add(element);
		}else {
			for (int i=0;i<index-1;i++) {
				pos=pos.next;
			}
			Nnew.next=pos.next;
			pos.next.previous=Nnew;
			pos.next=Nnew;
			Nnew.previous=pos;
		}
		size++;
	}

	@Override
	public void add(Object element) {
		Node Nnew = new Node();
		Nnew.element=element;
		if (isEmpty()) {
			Nnew.previous=null;
			Nnew.next=null;
			head=tail=Nnew;
		}else {
			Nnew.next=null;
			tail.next=Nnew;
			Nnew.previous=tail;
			tail=Nnew;
		}
		size++;	
	}

	@Override
	public Object get(int index) {
		Node temp=head;
		for (int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp.element;
	}

	@Override
	public void set(int index, Object element) {
		Node Temp;
		Temp=head;
		for (int i=0;i<index;i++) {
			Temp=Temp.next;
		}
		Temp.element=element;
	}

	@Override
	public void clear() {
		head=tail=null;
		size=0;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void remove(int index) {
		if (isEmpty()) {
			throw new RuntimeException("the list is empty can't remove from it");
		}else {
			if (index==0) {
				head=head.next;
			}else if (index==size-1) {
				Node N1=head;
				while(true) {
					if (N1.next==tail)break;
				}
				tail=N1;
				tail.next=null;
			}else {
				Node N1=head,N2=head.next;
				for (int i=0;i<index-1;i++) {
					N1=N1.next;
					N2=N2.next;
				}
				N2=N2.next;
				N1.next=N2;
			}
			size--;
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (isEmpty()) {
			throw new RuntimeException("the list is empty");
		}else {
			if (toIndex>size-1) {
				throw new RuntimeException("the border of the list you need is bigger than the base list");
			}else {
				Double_Linked_list sublist = new Double_Linked_list();
				sublist.size=toIndex-fromIndex+1;
				Node temp = head;
				for (int i=0;i<size;i++) {
					if (i==fromIndex) {
						sublist.head=temp;
					}else if(i==toIndex) {
						sublist.tail=temp;
					}
					temp=temp.next;
				}
				return sublist;
			}
		}
	}

	@Override
	public boolean contains(Object o) {
		if (isEmpty()) {
			return false;
		}else {
			boolean test=false;
			Node temp = head;
			for (int i=0;i<size;i++) {
				if (temp.element==o) {
					test=true;
					break;
				}
				temp=temp.next;
			}
			return test;
		}
	}
	
	
	public void print() { //this function for testing the code
		Node temp=head;
		for (int i=0;i<size;i++) {
			System.out.println(temp.element);
			temp=temp.next;
		}
	}

	public Object[] listToArr(Double_Linked_list list) {
		Object [] arr = new Object [list.size()];
		for (int i=0;i<list.size();i++) {
			arr[i]=list.get(i);
		}
		return arr;
	}
	
	public Double_Linked_list arrToList (Object[] arr) {
		Double_Linked_list list = new Double_Linked_list();
		for (int i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		return list;
	}
}
