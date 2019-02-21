import javafx.scene.paint.Color;

public class ScaniaS730 extends Scania {
	
	private Car[] cars;
	private int carCounter;
	private int releaseCarCounter;
	private double releaseTimer;
	
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
		releaseCarCounter = 4;
		if (!getBedActive()) {
			setTruckBed(true);
			removeCars();
		} else {
			while(cars[0] != null) {
					if (System.currentTimeMillis() - releaseTimer >= 300) {
						if (cars[releaseCarCounter] != null) {
							System.out.println(cars[releaseCarCounter] + " removed");
							cars[releaseCarCounter] = null;
						}
						if (releaseCarCounter > 0) releaseCarCounter--; 
						releaseTimer = System.currentTimeMillis();
					}
				}
			}
			System.out.println("Cars emptied");
		}
	}