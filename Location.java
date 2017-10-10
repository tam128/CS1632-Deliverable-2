public class Location{
	
	String location;		/**name of location*/
	String street;			/**name of one way street the location is on*/
	Location next;			/**Next location object reachable by the current location via a one way street*/
	Location turn;			/**Location object reachable by the current location via turning onto a two way street*/
	
	
	 /**
     * Constructor - creates a new Location object
     * Sets all variables to default empty String or null Object values
     */
	public Location(){
		String location = "";
		String street = "";
		Location next = null;
		Location turn = null;
	}
	
	/**
     * Constructor - creates a new Location object
     * Sets all variables to default empty String or null Object values
	 * @param String location -name of location
	 * @param String street -name of one way street the location is on
	 * @param Location next -Next location object reachable by the current location via a one way street
	 * @param Location turn -Location object reachable by the current location via turning onto a two way street
     */
	public Location(String location, String street, Location next, Location turn){
		this.location = location;
		this.street = street;
		this.next = next;
		this.turn = turn;
	}
	
	 /**
     * Sets location.  Simply sets the location variable to passed in String.
     */
	public void setLocation(String location){
		this.location = location;
	}
	
    /**
     * Accessor for location name.
	 * @return String -return name of location if set, empty String otherwise
     */
	public String getLocation(){
		return location;
	}
	
	/**
     * Sets street name.  Simply sets the street variable to passed in String.
     */
	public void setStreet(String street){
		this.street = street;
	}
	
    /**
     * Accessor for name of street.
     * @return String - return street name if set, empty String otherwise
     */
	public String getStreet(){
		return street;
	}
	
	/**
     * Sets the next location the driver is reaching via one way street.  
	 * Simply sets the next variable to passed in Location object.
     */
	public void setNext(Location next){
		this.next = next;
	}
	
	 /**
     * Accessor for next Location reachable by the current Location via a one way street.
     * @return Location -return Location object if set, null otherwise
     */
	public Location getNext(){
		return next;
	}

	 /**
     * Sets the location the driver is turning to via two way street.  
	 * Simply sets the turn variable to passed in Location object.
     */	
	public void setTurn(Location turn){
		this.turn = turn;
	}
	
    /**
     * Accessor for Location object reachable by the current Location via turning 
	 * on a two way street. 
     * @return Location -return Location object if set, null otherwise
     */
	public Location getTurn(){
		return turn;
	}
	
}