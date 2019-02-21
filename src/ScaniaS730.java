import javafx.scene.paint.Color;

public class ScaniaS730 extends Scania {
	
	private Car[] cars;
	private int carCounter;
	private int releaseCarCounter;
	private double releaseTimer;
	private boolean firstOut, run;
	
	public ScaniaS730(int carAmount) {
		super(Color.BLUE, 5, "Scania S730");
		cars = new Car[carAmount];
		releaseTimer = System.currentTimeMillis();
	}
	
	public void addCarToLift(Car car) {
		if (car == this) return;
		cars[carCounter] = car;
		carCounter++;
	}

	
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