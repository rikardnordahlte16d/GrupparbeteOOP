import javafx.scene.paint.Color;

public class Saab95 extends Car implements Moveable {

	public boolean turboOn; //Om turbo �r p� eller ej

	public Saab95() {
		super(Color.BLACK, 125, "Saab95");
		turboOn = false;
		stopEngine();
	}		

	/**
	 * 
	 * St�nger av turbon
	 * 
	 */
	public void setTurboOn() {
		turboOn = true;
	}

	/**
	 * Aktiverar Turbo
	 * 
	 */
	
	public void setTurboOff() {
		turboOn = false;
		
	}

	/**
	 * �kar farten med 30 % p� bilen n�r turboon �r. Returnerar bilens snabbhet formel, 
	 */
	public double speedFactor() {
		double turbo = 1;
		if (turboOn)
			turbo = 1.3;
		return getEnginePower() * 0.01 * turbo;
	}
}

