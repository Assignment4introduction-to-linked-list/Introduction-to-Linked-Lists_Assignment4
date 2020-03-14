package eg.edu.alexu.csd.datastructure.linkedList.csX22;

import java.util.Arrays;

public class PolynomialSolver implements IPolynomialSolver{
        
        class Polyn{
            char name;
            Single_Linked_list equation = new Single_Linked_list();
        }
        Polyn[] P = new Polyn[10];
        private int nOfPoly = 0;
        
	@Override
	public void setPolynomial(char poly, int[][] terms) { 
            // bubble sort and adding same exponent
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
                    else if(terms[j][1] == terms[j+1][1]){
                        terms[j][0] += terms[j+1][0];
                        terms[j+1][1] = maxnInt++;
                        rcount++; j--;
                    }
            // make the polynomial
            P[nOfPoly] = new Polyn();
            P[nOfPoly].name = poly;
            for(int i=terms.length-1 ; i>=rcount; i--){
                if(terms[i][0]!=0)
                    P[nOfPoly].equation.add(terms[i]);
            }
            nOfPoly++;
	}

	@Override
	public String print(char poly) {
            StringBuilder equ = new StringBuilder("");
            int cur = this.getPolyIndex(poly);
            for(int i=0 ; i<P[cur].equation.size(); i++){
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
                else{
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
            int [][] sumArr = new int[100][2]; 
            int p1 = this.getPolyIndex(poly1);
            int p2 = this.getPolyIndex(poly2);
            int i=0, j=0, counter = 0;
            while(i<P[p1].equation.size() && j<P[p2].equation.size()){
                if(this.getValue(poly1,i)[1]==this.getValue(poly2,j)[1]){
                    if(this.getValue(poly1,i)[0]+this.getValue(poly2,j)[0]!=0){
                        sumArr[counter][1] = this.getValue(poly1, i)[1];
                        sumArr[counter++][0] = this.getValue(poly1,i)[0]+this.getValue(poly2,j)[0];
                    }
                    i++; j++;
                }
                else if(this.getValue(poly1,i)[1]>this.getValue(poly2,j)[1]){
                    sumArr[counter][1] = this.getValue(poly1, i)[1];
                    sumArr[counter++][0] = this.getValue(poly1, i++)[0];
                }
                else{
                    sumArr[counter][1] = this.getValue(poly2, j)[1];
                    sumArr[counter++][0] = this.getValue(poly2, j++)[0];
                }
            }
            while(i<P[p1].equation.size()){
                sumArr[counter][1] = this.getValue(poly1, i)[1];
                sumArr[counter++][0] = this.getValue(poly1, i++)[0];
            }
            while(j<P[p2].equation.size()){
                sumArr[counter][1] = this.getValue(poly2, j)[1];
                sumArr[counter++][0] = this.getValue(poly2, j++)[0];
            }
            return Arrays.copyOfRange(sumArr,0,counter);
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
            int cur = this.getPolyIndex(poly2);
            for(int i=0; i<P[cur].equation.size(); i++){
                ((int[])(P[cur].equation.get(i)))[0]=-((int[])(P[cur].equation.get(i)))[0];
            }
            int[][] sub = this.add(poly1, poly2);
            for(int i=0; i<P[cur].equation.size(); i++){
                ((int[])(P[cur].equation.get(i)))[0]=-((int[])(P[cur].equation.get(i)))[0];
            }
            return sub;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
            int [][] mulArr = new int[1000][2];
	    int p1 = this.getPolyIndex(poly1);
            int p2 = this.getPolyIndex(poly2);
            int counter=0;
            for(int i=0; i<P[p1].equation.size(); i++)
                for(int j=0; j<P[p2].equation.size(); j++){
                    mulArr[counter][0] = this.getValue(poly1,i)[0]*this.getValue(poly2,j)[0];
                    mulArr[counter++][1] = this.getValue(poly1,i)[1]+this.getValue(poly2,j)[1];
                }
            this.setPolynomial('t', mulArr);
            int mulPoly = this.getPolyIndex('t');
            int[][] fmulArr = new int [1000][2];
            int cou = 0;
            for(int i=0; i<P[mulPoly].equation.size(); i++){
                fmulArr[cou][0] = this.getValue('t', i)[0];
                fmulArr[cou++][1] = this.getValue('t', i)[1];
            }
            this.clearPolynomial('t');
            nOfPoly--;
            return fmulArr;
	}
        private int getPolyIndex(char poly)
        {
            int cur = 0;
            while(cur<nOfPoly && P[cur].name!=poly)
                cur++;
            return cur;
        }
        private int[] getValue(char poly, int index)
        {
            int cur = this.getPolyIndex(poly);
            int[] values = {((int[])(P[cur].equation.get(index)))[0],
                ((int[])(P[cur].equation.get(index)))[1]};
            return values;
        }
	
}
