package model;
public class Lift {

	private boolean bedActive; //Om flaket �r nere eller inte (true = nere)
	private double bedAngle; //Vilken vinkel flaket �r p�
	private double timer; //Timern som anv�nds �fr att s�nka flaket / ta upp flaket
	private double bedTimer; //Hur snabbt den s�nks / h�js

	public Lift() {
		bedAngle = 70;
		timer = System.currentTimeMillis();
		bedTimer = 20;
	}
	
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
	 * Returnerar om flaket �r nere eller inte
	 * @return
	 */
	public boolean getBedActive() {
		return bedActive;
	}
	
}
