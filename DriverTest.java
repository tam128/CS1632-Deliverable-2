import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;

public class DriverTest{
	
	//Test to see if a Driver object with number 1 is created,
	//and the driver number returned is 1
	//The driver number should return as 1
	@Test
    public void testGetDriverNumber(){
		Driver d = new Driver(1);
		assertTrue(d.getNumber()==1);
	}	
	
	//Test to see if an ArithmeticException is thrown when a negative number
	//is passed as a driver number. An exception should be thrown and the 
	//driver number should be -1 by default.
	
	public void testThrowNegException(){
		Driver d = new Driver(1);
		try{
			d.setNumber(-5);
			// Note that if fail() is called, result will be "null" and that is
			// what will be displayed in the TestRunner
			fail();
		} catch (ArithmeticException e) {
		}
		//Driver number should be -1 by default
		assertEquals(-1, d.getNumber());
	}
	
	
	//Test to see if the street getter method returns the
	//same street passed to the setter method
	//Compares the street with the passed in String
	@Test
    public void testGetDriverStreet(){
		Driver d = new Driver(1);
		d.setStreet("Fifth Ave.");
		assertEquals("Fifth Ave.", d.getStreet());
	}	
	
	//Test double test to see if the destination getter method returns
	//the same Location passed to the setter method
	//Compares the original Location and the returned Location
	@Test
    public void testGetDestination(){
		Driver d = new Driver(1);
		Location loc = Mockito.mock(Location.class);
		d.setDest(loc);
		Location returnedLoc = d.getDest();
		assertEquals(loc, returnedLoc);
	}	
	
	
	
}