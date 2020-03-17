package eg.edu.alexu.csd.datastructure.linkedList.csX22;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleLinkedListTest {

	@Test
    void adding() {
        Single_Linked_list testing = new Single_Linked_list();
        testing.add(1);
        testing.add(2);
        testing.add(1,3);
        testing.add(2,4);
        assertEquals(testing.get(0),1);
        assertEquals(testing.get(1),3);
        assertEquals(testing.get(2),4);
        assertEquals(testing.get(3),2);
        testing.set(2,76);
        assertEquals(testing.get(2),76);
        assertEquals(testing.size(),4);
        testing.remove(1);
        assertEquals(testing.get(2),2);
        assertEquals(testing.size(),3);
        assertTrue(testing.contains(1));
        assertFalse(testing.contains(4));
        assertTrue(testing.contains(76));
        assertFalse(testing.contains(19));
        assertFalse(testing.isEmpty());
        assertFalse(testing.contains(773));
        testing.clear();
        assertTrue(testing.isEmpty());
        testing.add("mohamed");
        testing.add("tree");
        testing.add(1,"seif");
        testing.add(2,"ali");
        assertEquals(testing.get(0),"mohamed");
        assertEquals(testing.get(1),"seif");
        assertEquals(testing.get(2),"ali");
        assertEquals(testing.get(3),"tree");
    }
    @Test
    void subList() {
        Single_Linked_list testing = new Single_Linked_list();
        int i;
        for (i=0;i<15;i++) {
        	testing.add(i);
        }
        Single_Linked_list testingSub = (Single_Linked_list) testing.sublist(3,7);
        assertEquals(testingSub.size(),15);
        assertFalse(testingSub.contains(30));
        assertEquals(testingSub.get(2),5);
    }

    @Test
    void List_of_objects() {
        Single_Linked_list testing = new Single_Linked_list();
        testing.add("Actualfr");
        testing.add(210);
        testing.add(492);
        testing.add(352);
        assertEquals(((String)(testing.get(0))).substring(6),"fr");
        assertEquals(((Integer) testing.get(1)).toString(),"210");
        assertEquals(((Integer) testing.get(2)).toString(),"492");
        assertEquals(((Integer) testing.get(2)).toString(),"352");
    }
    
    
}
