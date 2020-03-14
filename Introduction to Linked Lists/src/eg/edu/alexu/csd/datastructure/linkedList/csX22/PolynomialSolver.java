package eg.edu.alexu.csd.datastructure.linkedList.csX22;

public class PolynomialSolver implements IPolynomialSolver{
        
        class Polyn{
            char name;
            Single_Linked_list equation = new Single_Linked_list();
        }
        Polyn[] P = new Polyn[5];
        private int nOfPoly = 0;
        
	@Override
	public void setPolynomial(char poly, int[][] terms) { 
            // bubble sort
            for (int i = 0; i < terms.length-1; i++) 
                for (int j = 0; j < terms.length-i-1; j++) 
                    if (terms[j][1] > terms[j+1][1]) 
                    {  
                        int[] temp = terms[j]; 
                        terms[j] = terms[j+1]; 
                        terms[j+1] = temp; 
                    }
            // make the polynomial
            P[nOfPoly] = new Polyn();
            P[nOfPoly].name = poly;
            for(int i=terms.length-1 ; i>=0; i--)
                P[nOfPoly].equation.add(terms[i]);
            nOfPoly++;
	}

	@Override
	public String print(char poly) {
            StringBuilder equ = new StringBuilder("");
            int cur = 0;
            while(cur<nOfPoly && P[cur].name!=poly)
                cur++;
            for(int i=0 ; i<P[cur].equation.size(); i++){
                boolean coefOne,coefnOne,powerOne,powerZero;
                coefOne = ((int[])(P[cur].equation.get(i)))[0]==1;
                coefnOne = ((int[])(P[cur].equation.get(i)))[0]==-1;
                powerOne = ((int[])(P[cur].equation.get(i)))[1]==1;
                powerZero = ((int[])(P[cur].equation.get(i)))[1]==0;
                if(powerZero)
                    equ.append(((int[])(P[cur].equation.get(i)))[0]);
                else if(powerOne&&coefOne)
                    equ.append("X");
                else if(powerOne&&coefnOne)
                    equ.append("-X");
                else if(coefOne)
                    equ.append(String.format("X^%d",((int[])(P[cur].equation.get(i)))[1]));
                else if(coefnOne)
                    equ.append(String.format("-X^%d",((int[])(P[cur].equation.get(i)))[1]));
                else if(powerOne)
                    equ.append(String.format("%dX",((int[])(P[cur].equation.get(i)))[0]));
                else{
                    equ.append(String.format("%dX^%d",((int[])(P[cur].equation.get(i)))[0],
                   ((int[])(P[cur].equation.get(i)))[1]));
                }
                if(P[cur].equation.get(i+1)!=null&&
                        ((int[])(P[cur].equation.get(i+1)))[0]>0) 
                    equ.append('+');
            }
            System.out.println(equ.toString());
            return equ.toString();
	}

	@Override
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
