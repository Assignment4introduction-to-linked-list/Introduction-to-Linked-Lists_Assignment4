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
        PolynomialSolver poly = new PolynomialSolver();
        int[][] ab = {{3,3},{2,3},{2,2},{1,1},{-2,2}};
        int[][] bd = {{3,3},{2,0},{+2,2},{-1,1}};
        poly.setPolynomial('a', ab);
        poly.setPolynomial('b', bd);
        System.out.println("1st : "+poly.print('a'));
        System.out.println("2nd : "+poly.print('b'));
        poly.setPolynomial('c',poly.add('a', 'b'));
        System.out.println("Sum : "+poly.print('c'));
        poly.setPolynomial('d', poly.subtract('a', 'b'));
        System.out.println("Sub : "+poly.print('d'));
        poly.setPolynomial('m', poly.multiply('a', 'b'));
        System.out.println("Mul : "+poly.print('m'));
        System.out.println("Value of 1st when x = 2.25 is "+poly.evaluatePolynomial('a', 2.25F));

    }
}
