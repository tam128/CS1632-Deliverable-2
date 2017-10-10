public class Driver{
	int number; 	/**Number of the driver, -1 by default*/
	Location destination;	/**Current location of the driver*/
	String street;	/**The street driver uses to get to the location*/
	
	public Driver(){
		int number = -1; 	
		Location destination = new Location();
		String street = "";
	}
	
	public Driver(int number) throws ArithmeticException{
		if(number<0){
			throw new ArithmeticException();
		}
		else{
			this.number = number;
			Location destination = new Location();
		}
	}
	
	public void setNumber(int number) throws ArithmeticException{
		if(number<0){
			throw new ArithmeticException();
		}
		else{
			this.number = number;
		}
	}

	public int getNumber(){
		return number;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	
	public String getStreet(){
		return street;
	}
	
	public void setDest(Location destination){
		this.destination = destination;
	}
	
	public Location getDest(){
		return destination;
	}
	
}