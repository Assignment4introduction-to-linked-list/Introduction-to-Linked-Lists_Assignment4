package eg.edu.alexu.csd.datastructure.linkedList.csX22;

public class OurMain {

    public static void main(String[] args) {
     /*   System.out.println("Let's count from 1 to 10");
        for(int i=1; i<=10; i++)
        {
            System.out.println(i); 
        }
        */
    	Double_Linked_list l=new Double_Linked_list ();
    	l.add(20);
    	l.add(50);
    	l.add('b');
    	l.add("ahmed");
    	l.add(2,"car");
    	l.remove(0);
    	l.set(2, "khaled");
    	l.print();
    	Object x= l.get(3);
    	System.out.println("\n\n"+x);
    	System.out.println(l.contains(10));
    	//l.clear();
    	//l.print();
    	Double_Linked_list sub=new Double_Linked_list ();
    	sub=(Double_Linked_list) l.sublist(1,2);
    	sub.print();
    }
}
