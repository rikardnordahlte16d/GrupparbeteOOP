package model;
import javafx.scene.paint.Color;

public class Scania extends Car {

	private boolean bedActive; //Om flaket är nere eller inte (true = nere)
	private double bedAngle; //Vilken vinkel flaket är på
	private double timer; //Timern som används öfr att sänka flaket / ta upp flaket
	private double bedTimer; //Hur snabbt den sänks / höjs
	
	public Scania(Color color, double enginePower, String name) {
		super(color, enginePower, name);
		bedAngle = 70;
		timer = System.currentTimeMillis();
		bedTimer = 20;
	}
	/**
	 * Tar upp eller ner flaket (gör det stegvis med hjälp av tid) 
	 * @param arg om den ska åka upp eller inte 
	 */
	public void setTruckBed(boolean arg) {
		bedActive = arg;
		if (bedActive && currentSpeed > 0) {
			while (bedAngle > 0) {
				if (System.currentTimeMillis() - timer >= bedTimer) {
					bedAngle-=0.5;
					System.out.println(bedAngle);
					timer = System.currentTimeMillis();
				}
			}
		} else {
			if (!bedActive) {
				while (bedAngle < 70) {
					if (System.currentTimeMillis() - timer >= bedTimer) {
						bedAngle+=0.5;
						timer = System.currentTimeMillis();
					}
				}
			}
		}
	}
	/**
	 * Returnerar flakets vinkel
	 * @return
	 */
	public double getBedAngle() {
		return bedAngle;
	}
	/**
	 * Returnerar om flaket är nere eller inte
	 * @return
	 */
	public boolean getBedActive() {
		return bedActive;
	}
}
