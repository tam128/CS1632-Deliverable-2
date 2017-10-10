import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;


public class LocationTest{
	
	
	//Test to see if the location getter method returns the same
	//location String passed to the setter method
	@Test
    public void testGetLocation(){
		Location loc = new Location();
		loc.setLocation("Coffee");
		assertEquals("Coffee", loc.getLocation());
	}	
	
	//Test to see if the street getter method returns the
	//same street passed to the setter method
	@Test
    public void testGetLocationStreet(){
		Location loc = new Location();
		loc.setStreet("Fifth Ave.");
		assertEquals("Fifth Ave.", loc.getStreet());
	}	
	
	//Test double test to see if the next Location returned
	//is equal to the Location passed to the setter method
	//Locations should match
	@Test
    public void testGetNext(){
		Location loc1 = new Location();
		Location loc2 = new Location();
		loc1.setNext(loc2);
		assertEquals(loc2, loc1.getNext());
	}	
	
	//Test double test to see if the next Location returned
	//is equal to the Location passed to the setter method
	//Locations should match
	@Test
    public void testGetTurn(){
		Location loc1 = new Location();
		Location loc2 = new Location();
		loc1.setTurn(loc2);
		assertEquals(loc2, loc1.getTurn());
	}	
	
}