package model;
import javafx.scene.paint.Color;

public class Vehicle implements Moveable {
	private double enginePower; // Engine power of the car
	public double currentSpeed; // The current speed of the car
	private Color color; // Color of the car
	private String modelName; // The car model name
	private float x,y;
	
	public Vehicle(Color color, double enginePower, String modelName) {
		this.color = color;
		this.enginePower = enginePower;
		this.modelName = modelName;
	}
	
	/**
	 * Returnerar bilens motor kraft
	 * @return
	 */
	public double getEnginePower() {
		return enginePower;
	}
	/**
	 * Returnerar bilens fart 
	 * @return
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}
	/**
	 * Returnerar bilens f�rg
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Startar upp bilens motor 
	 */
	public void startEngine() {
		currentSpeed = 0.1;
	}
	/**
	 * Motor p� bilen stoppar
	 */
	public void stopEngine() {
		currentSpeed = 0;
	}
	/**
	 * Returnerar formeln p� bilens fart
	 * @return
	 */
	public double speedFactor() {
		return 0;
	}
	
	/**
	 * �kning av farten, i form av en variable av Currentspeed och speedfactor g�nger amount
	 * @param amount
	 */
	
	public void incrementSpeed(double amount) {
		if (getCurrentSpeed() + speedFactor() * amount < currentSpeed || getCurrentSpeed() + speedFactor() * amount > enginePower) return;
		currentSpeed = getCurrentSpeed() + speedFactor() * amount;
		
	}
	
	
	/**
	 * minskning av farten, i form av en variable av Currentspeed och speedfactor g�nger amount
	 * @param amount
	 */

	public void decrementSpeed(double amount) {
		if (getCurrentSpeed() - speedFactor() * amount > currentSpeed || getCurrentSpeed() - speedFactor() * amount < 0) return;
		currentSpeed = getCurrentSpeed() - speedFactor() * amount;
	}

	
	/**
	 * gasa bilen med amount f�r�ndring beroende p� �kad fart.	
	 * @param amount
	 */
	
	public void gas(double amount) {
		if (amount >= 0 && amount <= 1) {
			incrementSpeed(amount);
		}
	}

	/**
	 * bromsar bilen beroende, p� amount fart
	 * @param 
	 */
	
	public void brake(double amount) {
		if (amount >= 0 && amount <= 1) {
			decrementSpeed(amount);
		}
	}
	
	/**
	 * 
	 * F�rgen p� bilen 
	 * @param color
	 */
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * 
	 * flyttar fordonet
	 */
	public void move() {
		
	}
	
	/**
	 * 
	 * sv�nger v�nster
	 * 
	 */
	public void turnLeft() {
		x-=currentSpeed;
	}
	
	/** 
	 * 
	 * sv�nger h�ger
	 */
	
	public void turnRight() {
		x+=currentSpeed;
	}
	
	public float getXPos() {
		return x;
	}
	public float getYPos() {
		return y;
	}
	
	public String getModelName() {
		return modelName;
	}
}