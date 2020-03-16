package eg.edu.alexu.csd.datastructure.linkedList.csX22;

import java.util.Arrays;
import java.util.Scanner;

public class UI_Application {
	public static void main (String [] args) {
		try (Scanner s = new Scanner(System.in)) {
			PolynomialSolver p =new PolynomialSolver();
			int choose;
			//int test=0;
			char Vname1,Vname2;
			while (true) {
				/*for (int i=0;i<20;i++)System.out.println();
				if (test!=0) {
					System.out.println("Please Insert A Correct Number");
				}
				test=0;*/
				System.out.println("Please Choose An Action\n------------------------\n1- Set a polynomial variable\n"+
				"2- Print the value of a polynomial variable\n3- Add two polynomials\n4- Subtract two polynomials\n5- Multiply two polynomials\r\n" + 
				"6- Evaluate a polynomial at some point\n7- Clear a polynomial variable\n====================================================================");
				choose=s.nextInt();
				switch(choose) {
				case 1:{
					System.out.println("Insert the variable name: A, B or C");
					Single_Linked_list l=new Single_Linked_list();
					String str;
					int x=0;
					Vname1=s.next().charAt(0);
					int [][] CoEx =new int[20][2]; 
					System.out.println("Insert the polynomial terms in the form:\n(coeff1, exponent1), (coeff2, exponent2), .. ");
					str=s.next();
					boolean v = true;
					for (int i=0;i<str.length();i++) {
						if (Character.isDigit(str.charAt(i))) {
							if (v) {
								CoEx[x][0]=Integer.parseInt(String.valueOf(str.charAt(i)));
							}
							else {
								CoEx[x][1]=Integer.parseInt(String.valueOf(str.charAt(i)));
								l.add(CoEx[x]);
								x++;
							}
							v=!v;
						}
					}
					p.setPolynomial(Vname1,Arrays.copyOf(CoEx, x+1));
					System.out.println("Polynomial "+Vname1+
							" is set\n====================================================================");
					break;
					}
				case 2:{
					System.out.println("Insert the variable name: A, B, C or R ");
					Vname1 = s.next().charAt(0);
					System.out.println("Value in"+Vname1+":"+p.print(Vname1)+
							"\n====================================================================");
					break;
					}
				case 3 :{System.out.println("Insert the first variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					System.out.println("Insert the Second variable name: A, B, C or R ");
					Vname2=s.next().charAt(0);
					p.setPolynomial('R',p.add(Vname1, Vname2));
					System.out.println("the result of adding :"+p.print('R')+
							"\n====================================================================");
					break;
					}
				case 4 :{
					System.out.println("Insert the first variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					System.out.println("Insert the Second variable name: A, B, C or R ");
					Vname2=s.next().charAt(0);
					p.setPolynomial('R',p.subtract(Vname1, Vname2));
					System.out.println("the result of Subtracting :"+p.print('R')+
							"\n====================================================================");
					break;
					}
				case 5 :{
					System.out.println("Insert the first variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					System.out.println("Insert the Second variable name: A, B, C or R ");
					Vname2=s.next().charAt(0);
					p.setPolynomial('R',p.multiply(Vname1, Vname2));
					System.out.println("the result of Multiplying :"+p.print('R')+
							"\n====================================================================");
					break;
					}
				case 6:{
					System.out.println("Insert the variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					System.out.println("Enter the Value you want to Evaluate Polynomial at it:");
					float x = s.nextFloat();
			        System.out.println("Value of "+Vname1+" when x = "+ x + " is : "+p.evaluatePolynomial(Vname1,x)+
			        		"\n====================================================================");break;
					}
				case 7:{
					System.out.println("Insert the variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					p.clearPolynomial(Vname1);
					System.out.println("Done\n====================================================================");break;
					}
				default : 	//test=1;
					System.out.println("Please Insert a Correct Number\n====================================================================");
				}
			}
		}
	}
}
