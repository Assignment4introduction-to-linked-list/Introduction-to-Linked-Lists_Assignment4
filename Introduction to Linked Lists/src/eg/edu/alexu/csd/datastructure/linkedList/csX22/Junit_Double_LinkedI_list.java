package eg.edu.alexu.csd.datastructure.linkedList.csX22;

import static org.junit.Assert.*;

import org.junit.Test;

public class Junit_Double_LinkedI_list {

	 @Test
	    void adding_and_logic() {
	    	Double_Linked_list  doubleTesting = new Double_Linked_list();
	    	doubleTesting.add("1");
	    	doubleTesting.add("2");
	    	doubleTesting.add(1,"3");
	    	doubleTesting.add(2,"4");
	    	doubleTesting.add(doubleTesting.size(),"5");
	        assertEquals(doubleTesting.get(0),"1");
	        assertEquals(doubleTesting.get(1),"3");
	        assertEquals(doubleTesting.get(2),"4");
	        assertEquals(doubleTesting.get(3),"2");
	        assertEquals(doubleTesting.get(doubleTesting.size()-1),"5");
	        doubleTesting.set(2,"king");
	        assertEquals(doubleTesting.get(2),"king");
	        assertEquals(doubleTesting.size(),5);
	        doubleTesting.remove(1);
	        assertFalse(doubleTesting.isEmpty());
	        assertEquals(doubleTesting.get(2),"2");
	        assertEquals(doubleTesting.size(),4);
	        assertFalse(doubleTesting.contains("lion"));
	        assertFalse(doubleTesting.contains("frog"));
	        assertTrue(doubleTesting.contains("king"));
	        assertFalse(doubleTesting.contains("car"));
	        doubleTesting.clear();
	        assertTrue(doubleTesting.isEmpty());
	    }	    	    
	    @Test
	    void deletingingTest() {
	    	Double_Linked_list  doubleTesting = new Double_Linked_list();
	    	int i;
	    	for(i=0;i<50;i++) {
	    		doubleTesting.add(i+10);
	    	}
	    	doubleTesting.clear();
		    assertTrue(doubleTesting.isEmpty());
	    }	 
	    @Test
	    void subList() {
	    	Double_Linked_list  doubleTesting = new Double_Linked_list();
	    	Double_Linked_list  testingSub = new Double_Linked_list();
	        int i;
	        for (i=0;i<15;i++) {
	        	doubleTesting.add(i);
	        }
	        for(i=6;i<12;i++) {
	        	testingSub.add(i);
	        }
	        assertEquals(doubleTesting.sublist(6,11),testingSub);
	        assertFalse(testingSub.contains(90));
	        testingSub.clear();
	        testingSub.add(400);
	        assertFalse(testingSub.isEmpty());
	    }
	}