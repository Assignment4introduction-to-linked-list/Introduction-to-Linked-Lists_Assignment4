package eg.edu.alexu.csd.datastructure.linkedList.csX22;

import java.util.Scanner;

public class UI_Application {
	public static void main (String [] args) {
		try (Scanner s = new Scanner(System.in)) {
			PolynomialSolver p =new PolynomialSolver();
			char Vname1,Vname2,choose;;
			while (true) {
				System.out.println("Please Choose An Action\n------------------------\n1- Set a polynomial variable\n"+
				"2- Print the value of a polynomial variable\n3- Add two polynomials\n4- Subtract two polynomials\n5- Multiply two polynomials\r\n" + 
				"6- Evaluate a polynomial at some point\n7- Clear a polynomial variable\n====================================================================");
				choose=s.next().charAt(0);
				switch(choose) {
				case '1':{
					System.out.println("Insert the variable name: A, B or C");
					Single_Linked_list l=new Single_Linked_list();
					String str;
					Vname1=s.next().charAt(0);
					System.out.println("Insert the polynomial terms in the form:\n(coeff1, exponent1), (coeff2, exponent2), .. ");
					s.nextLine();
					str=s.nextLine();
					int current ;
					for (int i=0;i<str.length();i++) {
						char check = str.charAt(i);
						if (Character.isDigit(check)) {
							current = Integer.parseInt(String.valueOf(str.charAt(i)));
							while (Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i+1))) {
								current *= 10;
								i++;
								current += Integer.parseInt(String.valueOf(str.charAt(i)));
							}
							l.add(current);
						}
						else if (check == '-') {
							i++;
							check = str.charAt(i);
							if (Character.isDigit(check)) {
								current = -1*Integer.parseInt(String.valueOf(check));
								while (Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i+1))) {
									current *= 10;
									i++;
									current -= Integer.parseInt(String.valueOf(str.charAt(i)));
								}
								l.add(current);
							}
						}
					}
					p.setPolynomial(Vname1,l.SpecialListToArr(l));
					System.out.println("Polynomial "+Vname1+
							" is set\n====================================================================");
					break;
					}
				case '2':{
					System.out.println("Insert the variable name: A, B, C or R ");
					Vname1 = s.next().charAt(0);
					System.out.println("Value in "+Vname1+" : "+p.print(Vname1)+
							"\n====================================================================");
					break;
					}
				case '3' :{System.out.println("Insert the first variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					System.out.println("Insert the Second variable name: A, B, C or R ");
					Vname2=s.next().charAt(0);
					p.setPolynomial('R',p.add(Vname1, Vname2));
					System.out.println("the result of adding :"+p.print('R')+
							"\n====================================================================");
					break;
					}
				case '4' :{
					System.out.println("Insert the first variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					System.out.println("Insert the Second variable name: A, B, C or R ");
					Vname2=s.next().charAt(0);
					p.setPolynomial('R',p.subtract(Vname1, Vname2));
					System.out.println("the result of Subtracting :"+p.print('R')+
							"\n====================================================================");
					break;
					}
				case '5' :{
					System.out.println("Insert the first variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					System.out.println("Insert the Second variable name: A, B, C or R ");
					Vname2=s.next().charAt(0);
					p.setPolynomial('R',p.multiply(Vname1, Vname2));
					System.out.println("the result of Multiplying :"+p.print('R')+
							"\n====================================================================");
					break;
					}
				case '6':{
					System.out.println("Insert the variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					System.out.println("Enter the Value you want to Evaluate Polynomial at it:");
					float x = s.nextFloat();
			        System.out.println("Value of "+Vname1+" when x = "+ x + " is : "+p.evaluatePolynomial(Vname1,x)+
			        		"\n====================================================================");break;
					}
				case '7':{
					System.out.println("Insert the variable name: A, B, C or R ");
					Vname1=s.next().charAt(0);
					p.clearPolynomial(Vname1);
					System.out.println("Done\n====================================================================");break;
					}
				default : 	   
					System.out.println("Please Insert a Correct Number\n====================================================================");
				}
			}
		}
	}
}
