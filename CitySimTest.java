import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;


public class CitySimTest{
	
	//Double test that an ArrayList of 10 Drivers is created
	//Program should add 10 drivers to the list
	@Test
    public void testMakeTenDriverList(){
		CitySim9005 cs = new CitySim9005();
		Driver d = Mockito.mock(Driver.class);
		ArrayList<Driver> driverList = new ArrayList<Driver>();
		
		driverList = cs.makeDriverList(10);
		assertEquals(10, driverList.size());
	}	
	
	//Test that 0 or negative drivers cannot be accepted as the size of an ArrayList
	//Should throw an IndexOutOfBoundsException if 0 or a negative number is 
	//entered as the size
	@Test(expected = IndexOutOfBoundsException.class)
    public void testZeroDrivers(){
		CitySim9005 cs = new CitySim9005();
		ArrayList<Driver> driverList = new ArrayList<Driver>();
		
		driverList = cs.makeDriverList(-1);
	}
	
	//Tests if integer argument serves as an upper bound for generating a 
	//random number
	@Test
	public void testRandNum(){
		CitySim9005 cs = new CitySim9005();
		Random rand = new Random();
		assertEquals(1, cs.generateRandNum(rand, 1));
	}
	
	//Test that there are 4 locations in the ArrayList 
	//Hotel, coffee, diner, and library locations added to the
	//ArrayList results in an ArrayList of size 4
	@Test
	public void testMakeMapListSize(){
		CitySim9005 cs = new CitySim9005();
		ArrayList<Location> locList = cs.makeMap();
		assertEquals(locList.size(), 4);		
	}
	
	
	//Mock and double testing that generateRandNum() method is called once 
	//generateRandNum() should be called at most once in the startDrive method
	@Test
	public void testRandNumStartDrive(){
		CitySim9005 cs = new CitySim9005();
		Random rand = new Random(1);
		ArrayList<Location> locList = new ArrayList<Location>();
		Driver d = Mockito.mock(Driver.class);
		
		cs.startDrive(d, rand, locList);
		verify(cs.generateRandNum(rand, 4), times(1));	
	}
	
	
	//Stubbing to verify that the current location changes to the new location 
	//after driving to a new location
	//Checks if the current location is set to the new location object when
	//current location is returned
	@Test
	public void testDrivingNewLocation(){
		CitySim9005 cs = Mockito.mock(CitySim9005.class);
		Random rand = new Random(1);
		Driver d = Mockito.mock(Driver.class);
		Location loc1 = Mockito.mock(Location.class);
		Location loc2 = Mockito.mock(Location.class);
		
		Mockito.when(loc1.getNext()).thenReturn(loc2);
		Mockito.when(d.getStreet()).thenReturn("Fifth Ave.");
		
		assertEquals(loc2, cs.cityDrive(d, rand));
		
	}
	
	//Mocking and stubbing to verify that the driver number getter is called.
	//Getting this number should be called once
	@Test
	public void testNumberInCityDrive(){
		CitySim9005 cs = new CitySim9005();
		Random rand = new Random(1);
		Driver d = Mockito.mock(Driver.class);
		Location loc1 = Mockito.mock(Location.class);
		Location loc2 = Mockito.mock(Location.class);
		
		Mockito.when(loc1.getNext()).thenReturn(loc2);
		Mockito.when(loc1.getTurn()).thenReturn(loc2);
		Mockito.when(d.getNumber()).thenReturn(1);
		Mockito.when(d.getDest()).thenReturn(loc2);
		Mockito.when(d.getStreet()).thenReturn("Fifth Ave.");
		
		cs.cityDrive(d, rand);
		Mockito.verify(d, times(1)).getNumber();
	}
	
	
	//Mocking and stubbing to verify that the Street getter is called once
	//Getting this number should be called once.
	@Test
	public void testStreetInCityDrive(){
		CitySim9005 cs = new CitySim9005();
		Random rand = new Random(1);
		Driver d = Mockito.mock(Driver.class);
		Location loc1 = Mockito.mock(Location.class);
		Location loc2 = Mockito.mock(Location.class);
		
		Mockito.when(loc1.getNext()).thenReturn(loc2);
		Mockito.when(loc1.getTurn()).thenReturn(loc2);
		Mockito.when(d.getNumber()).thenReturn(1);
		Mockito.when(d.getDest()).thenReturn(loc2);
		Mockito.when(d.getStreet()).thenReturn("Fifth Ave.");
		
		cs.cityDrive(d, rand);
		Mockito.verify(d, times(1)).getStreet();
	}
}