import java.util.Random;
import java.util.ArrayList;

public class CitySim9005{
	/**
     * Main method for similuating a city with four locations.
	 * Takes a single command line integer argument as the seed number for
	 * the random number generator and exits if no argument or any non-integer argument is
	 * passed
     * @param args - seed number for the random number generator
     */
	public static void main(String args[]){
		
		CitySim9005 cs = new CitySim9005();
		ArrayList<Location> locList = cs.makeMap();
		
		if(args.length!=0 && args.length<2){
			try {  
				long seed = Long.parseLong(args[0]);
				Random rand = new Random(seed);
				ArrayList<Driver> driverList = cs.makeDriverList(5);		
				
				for(Driver d: driverList){
					cs.startDrive(d, rand, locList);
					cs.cityDrive(d, rand);
					System.out.println("-----------");
				}	
			}  
			catch(NumberFormatException e){  
				System.out.println("Please enter one integer argument");
				System.exit(0);
			}  
		}
		else{
			System.out.println("Please enter one integer argument");
		}
	}
	
	/**
     * Initializes the list of drivers by adding new drivers to an ArrayList
	 * @returns ArrayList<Driver> -returns a list of Driver objects
     */
	
	public ArrayList<Driver> makeDriverList(int num) throws IndexOutOfBoundsException{
		
		if(num<1){
			throw new IndexOutOfBoundsException();
		}
		else{
			ArrayList<Driver> driverList = new ArrayList<Driver>();
			
			for(int i=1; i<=num; i++){
				driverList.add(new Driver(i));
			}		
			return driverList;
		}
	}
	
	
	/**
     * Initializes the city map by linking the individual locations and adds 
	 * these locations to an ArrayList
	 * @returns ArrayList<Location> -returns a list of Location objects
     */
	public ArrayList<Location> makeMap(){
		ArrayList<Location> locList = new ArrayList<Location>();
		
		Location philly = new Location("Philadelphia", "Fourth Ave.", null, null);
		Location cleveland = new Location("Cleveland", "Fifth Ave.", null, null);
		Location coffee = new Location("Coffee", "Fifth Ave.", null, null);
		Location diner = new Location("Diner", "Fourth Ave.", null, null);
		Location hotel = new Location("Hotel", "Fourth Ave.", null, null);
		Location library = new Location("Library", "Fifth Ave.", null, null);
		
		coffee.setNext(library);
		coffee.setTurn(diner);
		
		diner.setNext(philly);
		diner.setTurn(coffee);
				
		hotel.setNext(diner);
		hotel.setTurn(library);
		
		library.setNext(cleveland);
		library.setTurn(hotel);
		
		locList.add(hotel);
		locList.add(diner);
		locList.add(library);
		locList.add(coffee);
		
		return locList;
	}

	
	public static int generateRandNum(Random rand, int bound){
		return rand.nextInt(bound)+1;
	}
	
	
	/**
     * Randomly sets the driver's starting location using the random number generator.
     * @param Driver d - Current driver
     * @param Random rand - Random number generator
     */
	
	public void startDrive(Driver d, Random rand, ArrayList<Location> locList){
		int rand_start = generateRandNum(rand, 4);
		Location hotel = locList.get(0);
		Location diner = locList.get(1);
		Location library = locList.get(2);
		Location coffee = locList.get(3);
		
		switch(rand_start){
			case 1:
				d.setDest(hotel);
				break;
			case 2:
				d.setDest(diner);
				break;
			case 3:
				d.setDest(library);
				break;
			case 4:
				d.setDest(coffee);
				break;
		}
	}
	
	 /**
     * Generates a random path for the driver from the starting location. 
	 * The driver moves from the current Location to one of the possible Locations that can 
	 * be reached from the original Location. 
     * @param Driver d - Current driver
     * @param Random rand - Random number generator
     */
	public Location cityDrive(Driver d, Random rand){	
		Location curLoc = new Location();
		curLoc = d.getDest();
		Location newLoc = new Location();
		
		while(!curLoc.getLocation().equals("Philadelphia") && !curLoc.getLocation().equals("Cleveland")){
			int rand_num = generateRandNum(rand, 2);
			if(rand_num==1){
				d.setDest(curLoc.getNext());
				d.setStreet(curLoc.getStreet());
				newLoc = d.getDest();
			}
			else{
				d.setDest(curLoc.getTurn());
				newLoc = d.getDest();
				
				if(newLoc.getLocation().equals("Library") || newLoc.getLocation().equals("Hotel")){
					d.setStreet("Bill St.");
				}
				else{
					d.setStreet("Phil St.");
				}
			}

			System.out.println("Driver " + d.getNumber() + " heading from " + curLoc.getLocation() + " to " + newLoc.getLocation() + " via " + d.getStreet());
			curLoc = newLoc;
		}
		System.out.println("Driver " + d.getNumber() + " has gone to " + d.getDest().getLocation() + "!");
		return newLoc;
	}
	
}