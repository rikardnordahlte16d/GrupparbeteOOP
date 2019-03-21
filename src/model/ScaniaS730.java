package model;
import javafx.scene.paint.Color;

public class ScaniaS730 extends Scania {
	
	private Car[] cars; //Alla bilar i lastet
	private int carCounter; //Vilken bil vi �r i p� listan 
	private int releaseCarCounter; //Vilken vi �r p� n�r vi sl�pper alla bilar
	private double releaseTimer; //En timer f�r n�r bilarna ska sl�ppas av
	public boolean firstOut, run; //firstOut �r om de bilarna som lastades f�rst, ska sl�ppas f�rst
	
	public ScaniaS730(int carAmount) {
		super(Color.BLUE, 5, "Scania S730");
		cars = new Car[carAmount];
		releaseTimer = System.currentTimeMillis();
	}
	/**
	 * L�gger till en bil i lasten
	 * @param car - Bilen som l�ggs till
	 */
	public void addCarToLift(Car car) {
		if (car == this) return;
		cars[carCounter] = car;
		carCounter++;
	}
	
	/** Tar bort alla bilar p� lastet. �r beroende om firstOut �r true eller inte
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