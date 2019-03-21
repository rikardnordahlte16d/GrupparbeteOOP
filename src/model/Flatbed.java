package model;

public class Flatbed {
	private boolean bedActive; //Om flaket �r nere eller inte (true = nere)
	private double bedAngle; //Vilken vinkel flaket �r p�
	private double timer; //Timern som anv�nds �fr att s�nka flaket / ta upp flaket
	private double bedTimer; //Hur snabbt den s�nks / h�js
	
	public Flatbed() {
		bedAngle = 70;
		timer = System.currentTimeMillis();
		bedTimer = 20;

	}
	/**
	 * Tar upp eller ner flaket (g�r det stegvis med hj�lp av tid) 
	 * @param arg om den ska �ka upp eller inte 
	 */
	public void setTruckBed(boolean arg) {
		bedActive = arg;
		if (bedActive) {
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
