package model;


public class CarLoader {
	private Vehicle[] vehicles; //Alla bilar i lastet
	private int carCounter; //Vilken bil vi �r i p� listan 
	private int releaseCarCounter; //Vilken vi �r p� n�r vi sl�pper alla bilar
	private double releaseTimer; //En timer f�r n�r bilarna ska sl�ppas av
	public boolean firstOut, run; //firstOut �r om de bilarna som lastades f�rst, ska sl�ppas f�rst
	private Flatbed flatbed;
	
	
	public CarLoader(int carAmount, Flatbed flatbed) {
		vehicles = new Vehicle[carAmount];
		releaseTimer = System.currentTimeMillis();
		this.flatbed = flatbed;
	}
	
	/**
	 * L�gger till en bil i lasten
	 * @param car - Bilen som l�ggs till
	 */
	public void addVehicleToLift(Vehicle vehicle) {
		//if (car == this) return;
		vehicles[carCounter] = vehicle;
		System.out.println("Added Vehicle: " + vehicle.getClass());
		carCounter++;
	}
	
	/** Tar bort alla bilar p� lastet. �r beroende om firstOut �r true eller inte
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
