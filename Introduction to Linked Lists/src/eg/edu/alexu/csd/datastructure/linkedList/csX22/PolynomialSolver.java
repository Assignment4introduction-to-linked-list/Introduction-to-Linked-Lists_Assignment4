package eg.edu.alexu.csd.datastructure.linkedList.csX22;

public class PolynomialSolver implements IPolynomialSolver{
        
    class Polyn{
        char name;
        Single_Linked_list equation = new Single_Linked_list();
    }
    Polyn[] P = new Polyn[10];

    @Override
    public void setPolynomial(char poly, int[][] terms) { 
        // bubble sort
        int rcount = 0;
        int maxnInt = -2147483648;
        for (int i = 0; i < terms.length-1; i++) 
            for (int j = 0; j < terms.length-i-1; j++) 
                if (terms[j][1] > terms[j+1][1]) 
                {  
                    int[] temp = terms[j];
                    terms[j] = terms[j+1]; 
                    terms[j+1] = temp; 
                }
                /* adding terms with same exponent
                   move unwanted terms to the last of the array */
                else if(terms[j][1] == terms[j+1][1]){
                    terms[j][0] += terms[j+1][0];
                    terms[j+1][1] = maxnInt++;
                    rcount++; j--;
                }
/////////////////////// make the polynomial ///////////////////////
        // search for empty place in the array to set a new polynomial
        int temp = -1;
        for(int i=0; i<P.length; i++)
            if(P[i]==null){
                temp = i;
                break;
            }
        if(temp==-1)
            throw new RuntimeException("No space for more polynomials, you can remove some");
        P[temp] = new Polyn();
        P[temp].name = poly;
        for(int i=terms.length-1 ; i>=rcount; i--){
            if(terms[i][0]!=0) // check that coefficient not equal to zero
                P[temp].equation.add(terms[i]);
        }
    }

    @Override
    public String print(char poly) {
        StringBuilder equ = new StringBuilder("");
        int cur = this.getPolyIndex(poly);
        for(int i=0 ; i<P[cur].equation.size(); i++){
            // handling special cases when printing
            boolean coefOne,coefnOne,powerOne,powerZero;
            coefOne = this.getValue(poly,i)[0]==1;
            coefnOne = this.getValue(poly,i)[0]==-1;
            powerOne = this.getValue(poly,i)[1]==1;
            powerZero = this.getValue(poly,i)[1]==0;
            if(powerZero)
                equ.append(this.getValue(poly,i)[0]);
            else if(powerOne&&coefOne)
                equ.append("X");
            else if(powerOne&&coefnOne)
                equ.append("-X");
            else if(coefOne)
                equ.append(String.format("X^%d",this.getValue(poly,i)[1]));
            else if(coefnOne)
                equ.append(String.format("-X^%d",this.getValue(poly,i)[1]));
            else if(powerOne)
                equ.append(String.format("%dX",this.getValue(poly,i)[0]));
            else{ // this is the normal case
                equ.append(String.format("%dX^%d",this.getValue(poly,i)[0],
               ((int[])(P[cur].equation.get(i)))[1]));
            }   
            if(P[cur].equation.get(i+1)!=null&&
                    this.getValue(poly,i+1)[0]>0) 
                equ.append('+');
        }
        return equ.toString();
    }

    @Override
    public void clearPolynomial(char poly) {
        int cur = this.getPolyIndex(poly);
        P[cur] = null;
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        int cur = this.getPolyIndex(poly);
        double pvalue = 0;
        for(int i=0; P[cur].equation.get(i)!=null; i++){
            pvalue+= this.getValue(poly, i)[0] *Math.pow(value,this.getValue(poly, i)[1]);
        }
        return (float)pvalue;
    }

    @Override
    public int[][] add(char poly1, char poly2) {
        
        Single_Linked_list sum = new Single_Linked_list();
        int p1 = this.getPolyIndex(poly1);
        int p2 = this.getPolyIndex(poly2);
        int i=0, j=0;
/////////////////////// adding two sorted polynomials ///////////////////////
        while(i<P[p1].equation.size() && j<P[p2].equation.size()){
            // if two terms have same exponent
            if(this.getValue(poly1,i)[1]==this.getValue(poly2,j)[1]){
                if(this.getValue(poly1,i)[0]+this.getValue(poly2,j)[0]!=0)
                    sum.add(new int[]{this.getValue(poly1,i)[0]+this.getValue(poly2,j)[0],
                    this.getValue(poly1, i)[1]});
                i++; j++;
            }
            // if one is greater than another
            else if(this.getValue(poly1,i)[1]>this.getValue(poly2,j)[1])
                sum.add(new int[]{this.getValue(poly1, i)[0],this.getValue(poly1, i++)[1]});
            else
                sum.add(new int[]{this.getValue(poly2, j)[0],this.getValue(poly2, j++)[1]});
        }
        // adding the remaining elements to the array 
        while(i<P[p1].equation.size()){
            sum.add(new int[]{this.getValue(poly1, i)[0],this.getValue(poly1, i++)[1]});
        }
        while(j<P[p2].equation.size()){
            sum.add(new int[]{this.getValue(poly2, j)[0],this.getValue(poly2, j++)[1]});
        }
        return (int[][])sum.listToArr(sum);
    }

    @Override
    public int[][] subtract(char poly1, char poly2) {
        int cur = this.getPolyIndex(poly2);
        // make second polynomial negative itself
        for(int i=0; i<P[cur].equation.size(); i++){
            ((int[])(P[cur].equation.get(i)))[0]=-((int[])(P[cur].equation.get(i)))[0];
        }
        // use add function
        int[][] sub = this.add(poly1, poly2);
        // return second polynomial to its real values
        for(int i=0; i<P[cur].equation.size(); i++){
            ((int[])(P[cur].equation.get(i)))[0]=-((int[])(P[cur].equation.get(i)))[0];
        }
        return sub;
    }

    @Override
    public int[][] multiply(char poly1, char poly2) {
        Single_Linked_list multiply = new Single_Linked_list();
        int p1 = this.getPolyIndex(poly1);
        int p2 = this.getPolyIndex(poly2);
        // multiply
        for(int i=0; i<P[p1].equation.size(); i++)
            for(int j=0; j<P[p2].equation.size(); j++){
                multiply.add(new int[]{this.getValue(poly1,i)[0]*this.getValue(poly2,j)[0],
                this.getValue(poly1,i)[1]+this.getValue(poly2,j)[1]});
            }
        /* throw the multiplcation list to function setPolynomial becouse
        - setPolymial function add terms with same exponent
        - remove terms with zero coefficient */
        this.setPolynomial('t', (int[][])multiply.listToArr(multiply));
        int mulPoly = this.getPolyIndex('t');
        int[][] mularray = P[mulPoly].equation.listToArr(P[mulPoly].equation);
        this.clearPolynomial('t');
        return mularray;
    }
    private int getPolyIndex(char poly)
    {
        if(isExist(poly)){
            int cur = 0;
            while(cur<P.length && P[cur].name!=poly)
                cur++;
            return cur;
        }
        else
            throw new RuntimeException("Polynomial not found");
    }
    private int[] getValue(char poly, int index)
    {
        int cur = this.getPolyIndex(poly);
        int[] values = {((int[])(P[cur].equation.get(index)))[0],
            ((int[])(P[cur].equation.get(index)))[1]};
        return values;
    }
    private boolean isExist(char poly){
        for (Polyn P1 : P)
            if (P1 != null && P1.name == poly)
                return true;
        return false;
    }
	
}
