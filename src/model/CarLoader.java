package model;


public class CarLoader {
	private Vehicle[] vehicles; //Alla bilar i lastet
	private int carCounter; //Vilken bil vi är i på listan 
	private int releaseCarCounter; //Vilken vi är på när vi släpper alla bilar
	private double releaseTimer; //En timer för när bilarna ska släppas av
	public boolean firstOut, run; //firstOut är om de bilarna som lastades först, ska släppas först
	private Flatbed flatbed;
	
	
	public CarLoader(int carAmount, Flatbed flatbed) {
		vehicles = new Vehicle[carAmount];
		releaseTimer = System.currentTimeMillis();
		this.flatbed = flatbed;
	}
	
	/**
	 * Lägger till en bil i lasten
	 * @param car - Bilen som läggs till
	 */
	public void addVehicleToLift(Vehicle vehicle) {
		//if (car == this) return;
		vehicles[carCounter] = vehicle;
		System.out.println("Added Vehicle: " + vehicle.getClass());
		carCounter++;
	}
	
	/** Tar bort alla bilar på lastet. Är beroende om firstOut är true eller inte
	 * 
	 */
	public void removeVehicles() {
		run = true;
		if (!firstOut) releaseCarCounter = 4; else releaseCarCounter = 0;
		
		if (!flatbed.getBedActive()) {
			flatbed.setTruckBed(true);
			removeVehicles();
		}
		int ok = 0;
		for(int i=0; i < vehicles.length; i++) {
			if (vehicles[i] != null) ok = i;
		}
		while(run) {
			Vehicle c = vehicles[0];
			if (firstOut) c = vehicles[ok];
			
			if (c == null) run = false;
			
			if (System.currentTimeMillis() - releaseTimer >= 300) {
			    if (vehicles[releaseCarCounter] != null) {
					System.out.println(vehicles[releaseCarCounter] + " removed");
					vehicles[releaseCarCounter] = null;
				}
				if (!firstOut && releaseCarCounter > 0) releaseCarCounter--; 
				if (firstOut && releaseCarCounter < vehicles.length - 1) releaseCarCounter++;
				releaseTimer = System.currentTimeMillis();
			}
		}
		
		System.out.println("Vehicles emptied");
	}
	
	public Vehicle[] getVehicles() {
		return vehicles;
	}
}
