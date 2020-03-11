package eg.edu.alexu.csd.datastructure.linkedList.cs17_cs09;

public class Double_Linked_list implements ILinkedList{

	
	class Node{
		Object element;
		Node next,last;
	}
	int size;
	Node head,tail;
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
			pos.next.last=Nnew;
			pos.next=Nnew;
			Nnew.last=pos;
		}
		size++;
	}

	@Override
	public void add(Object element) {
		Node Nnew = new Node();
		Nnew.element=element;
		if (isEmpty()) {
			Nnew.last=null;
			Nnew.next=null;
			head=tail=Nnew;
		}else {
			Nnew.next=null;
			tail.next=Nnew;
			Nnew.last=tail;
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
		// TODO Auto-generated method stub
		return null;
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


}
