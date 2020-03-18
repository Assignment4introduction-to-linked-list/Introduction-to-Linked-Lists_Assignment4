package eg.edu.alexu.csd.datastructure.linkedList.csX22;

import static org.junit.Assert.*;

import org.junit.Test;

public class Junit_Polynomial_Solver {

// error in set test 
    @Test
    void FirstAdditionTest() {
        PolynomialSolver polynomial = new PolynomialSolver();
        int[][] first = {{9, 11},{5,8}, {3,7},{2,4}};
        int[][] second = {{7,8},{6,2},{3,3},{1,0}};
        polynomial.setPolynomial('A',first);
        polynomial.setPolynomial('B',second);
        int[][] result = polynomial.add('B','A');
        int[][] expected = {{9,11},{12,8},{3,7},{2,4},{3,3},{6,2},{1,0}};
        assertArrayEquals(expected,result);
    }
   
    
    @Test
    void AdditionTestAgain() {
        PolynomialSolver polynomial = new PolynomialSolver();
        final int[][] first = {{7,3},{2,2},{5,1}};
        final int[][] second = {{8,5},{7,3},{8,0}};
        polynomial.setPolynomial('A', first);
        polynomial.setPolynomial('B', second);
        int[][] result = polynomial.add('A', 'B');
        final int[][] expected = {{8,5},{14,3},{2,2},{5,1},{8,0}};
        assertArrayEquals(expected, result);
    }
    
    
    @Test
    void FirstSubtractTest() {
        PolynomialSolver polynomial = new PolynomialSolver();
        final int[][] first = {{1,5},{-1, 3},{0,7}};
        final int[][] second = {{1,5},{-1, 3},{0,7}};
        polynomial.setPolynomial('A',first);
        polynomial.setPolynomial('B',second);
        int[][] result = polynomial.subtract('A','B');
        int[][] expected = {{0,5},{0, 3},{0,7}};
        assertArrayEquals(expected,result);
    }

    
    @Test
    void SubtractTestAgain() {
        PolynomialSolver polynomial = new PolynomialSolver();
        final int[][] first = {{8,4},{6,3},{4,2},{1,0}};
        final int[][] second = {{7,4},{5,3},{2,1},{1,0}};
        polynomial.setPolynomial('A',first);
        polynomial.setPolynomial('B',second);
        int[][] result = polynomial.subtract('A', 'B');
        int[][] expected = {{1,4},{2,3},{5,2},{-2,1},{0,0}};
        assertArrayEquals(expected, result);
    }
   
    
    
    @Test
    void FirstMultiplyTest() {
        PolynomialSolver polynomial = new PolynomialSolver();
        int[][] first = {{-13,3}, {12,8}, {3,9}};
        int[][] second = {{10,0}};
        polynomial.setPolynomial('A',first);
        polynomial.setPolynomial('B',second);
        int[][] result = polynomial.multiply('A','B');
        int[][] expected = {{-130,3},{120,8},{30,9}};
        assertArrayEquals(expected,result);
    }
    
    
    @Test
    void MultiplyTestAgain() {
        PolynomialSolver polynomial = new PolynomialSolver();
        final int[][] first = {{5,6},{4,4},{5,3},{2,1},{3,0}};
        final int[][] second = {{7,1}};
        polynomial.setPolynomial('A',first);
        polynomial.setPolynomial('B',second);
        final int[][] result = polynomial.multiply('A','B');
        final int[][] expected = {{35,7},{28,5},{35,4},{14,2},{21,1}};
        assertArrayEquals(expected,result);
    }
                                                                      
    
    @Test
    void Evaluating_test() {
        PolynomialSolver polynomial = new PolynomialSolver();
        int[][] testing = {{7,2},{1,4},{3,7}};
        polynomial.setPolynomial('A',testing);
        float number = 2;
        float result = polynomial.evaluatePolynomial('A',number);
        int result1 = (int) result;
        int expected =  428 ;
        assertEquals(expected,result1);
    }
    
    @Test
    void Evaluating_test2() {
        PolynomialSolver polynomial = new PolynomialSolver();
        int[][] testing = {{7,4},{2,2},{8,6}};
        polynomial.setPolynomial('A',testing);
        float number = 3;
        float result = polynomial.evaluatePolynomial('A',number);
        int result1 = (int) result;
        int expected =  6417 ;
        assertEquals(expected,result1);
    }

}
