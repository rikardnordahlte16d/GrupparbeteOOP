package model;
import javafx.scene.paint.Color;

public class ScaniaS730 extends Scania {
	
	private Car[] cars; //Alla bilar i lastet
	private int carCounter; //Vilken bil vi är i på listan 
	private int releaseCarCounter; //Vilken vi är på när vi släpper alla bilar
	private double releaseTimer; //En timer för när bilarna ska släppas av
	public boolean firstOut, run; //firstOut är om de bilarna som lastades först, ska släppas först
	
	public ScaniaS730(int carAmount) {
		super(Color.BLUE, 5, "Scania S730");
		cars = new Car[carAmount];
		releaseTimer = System.currentTimeMillis();
	}
	/**
	 * Lägger till en bil i lasten
	 * @param car - Bilen som läggs till
	 */
	public void addCarToLift(Car car) {
		if (car == this) return;
		cars[carCounter] = car;
		carCounter++;
	}
	
	/** Tar bort alla bilar på lastet. Är beroende om firstOut är true eller inte
	 * 
	 */
	public void removeCars() {
		run = true;
		if (!firstOut) releaseCarCounter = 4; else releaseCarCounter = 0;
		if (!getBedActive()) {
			setTruckBed(true);
			removeCars();
		} else {
			int ok = 0;
			for(int i=0; i < cars.length; i++) {
				if (cars[i] != null) ok = i;
			}
			while(run) {
				Car c = cars[0];
				if (firstOut) c = cars[ok];
				
				if (c == null) run = false;
				
				if (System.currentTimeMillis() - releaseTimer >= 300) {
					    if (cars[releaseCarCounter] != null) {
							System.out.println(cars[releaseCarCounter] + " removed");
							cars[releaseCarCounter] = null;
						}
						if (!firstOut && releaseCarCounter > 0) releaseCarCounter--; 
						if (firstOut && releaseCarCounter < cars.length - 1) releaseCarCounter++;
						releaseTimer = System.currentTimeMillis();
					}
				}
			}
			System.out.println("Cars emptied");
		}
	}