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
	 * Returnerar bilens färg
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
	 * Motor på bilen stoppar
	 */
	public void stopEngine() {
		currentSpeed = 0;
	}
	/**
	 * Returnerar formeln på bilens fart
	 * @return
	 */
	public double speedFactor() {
		return 0;
	}
	
	/**
	 * ökning av farten, i form av en variable av Currentspeed och speedfactor gånger amount
	 * @param amount
	 */
	
	public void incrementSpeed(double amount) {
		if (getCurrentSpeed() + speedFactor() * amount < currentSpeed || getCurrentSpeed() + speedFactor() * amount > enginePower) return;
		currentSpeed = getCurrentSpeed() + speedFactor() * amount;
		
	}
	
	
	/**
	 * minskning av farten, i form av en variable av Currentspeed och speedfactor gånger amount
	 * @param amount
	 */

	public void decrementSpeed(double amount) {
		if (getCurrentSpeed() - speedFactor() * amount > currentSpeed || getCurrentSpeed() - speedFactor() * amount < 0) return;
		currentSpeed = getCurrentSpeed() - speedFactor() * amount;
	}

	
	/**
	 * gasa bilen med amount förändring beroende på ökad fart.	
	 * @param amount
	 */
	
	public void gas(double amount) {
		if (amount >= 0 && amount <= 1) {
			incrementSpeed(amount);
		}
	}

	/**
	 * bromsar bilen beroende, på amount fart
	 * @param 
	 */
	
	public void brake(double amount) {
		if (amount >= 0 && amount <= 1) {
			decrementSpeed(amount);
		}
	}
	
	/**
	 * 
	 * Färgen på bilen 
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
	 * svänger vänster
	 * 
	 */
	public void turnLeft() {
		x-=currentSpeed;
	}
	
	/** 
	 * 
	 * svänger höger
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